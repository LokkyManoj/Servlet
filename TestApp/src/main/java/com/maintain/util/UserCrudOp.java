package com.maintain.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.maintain.model.PojoClasses;
import com.maintain.server.MyserverApp;

import com.maintain.util.UserConnection;

public class UserCrudOp

{
//	public Connection connection;
//
//	public UserCrudOp() throws ClassNotFoundException, SQLException {
//		this.connection =UserConnection.getConnection();
//	}

	public void addUser(PojoClasses pj) {
		try (Connection con = UserConnection.getConnection()) {
			String query = "insert into userinfo (name, mobile, date_of_birth, email) values (?, ?, ?, ?)";
			try (PreparedStatement pstmt = con.prepareStatement(query)) {
				pstmt.setString(1, pj.getUserName());
				pstmt.setString(2, pj.getMobileNo());
				pstmt.setString(3, pj.getDate());
				pstmt.setString(4, pj.getEmail());

				int rowsAffected = pstmt.executeUpdate();
				System.out.println("Rows affected: " + rowsAffected);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Error: " + ex.getMessage());
			Logger.getLogger(UserCrudOp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public ArrayList<PojoClasses> getAllUsers() {
		ArrayList<PojoClasses> userList = new ArrayList<>();
		try (Connection con = UserConnection.getConnection()) {
			String query = "select * from userinfo where deleted=0 order by name";
			try (PreparedStatement pstmt = con.prepareStatement(query)) {
				try (ResultSet rs = pstmt.executeQuery()) {
					while (rs.next()) {
						PojoClasses user = new PojoClasses();
						user.setId(rs.getInt("id"));
						user.setUserName(rs.getString("name"));
						user.setMobileNo(rs.getString("mobile"));
						user.setDate(rs.getString("date_of_birth"));
						user.setEmail(rs.getString("email"));
						userList.add(user);
					}
				}
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(UserCrudOp.class.getName()).log(Level.SEVERE, null, ex);
		}
		return userList;
	}

//	public void deleteUser(int id) {
//		try (Connection con = UserConnection.getConnection()) {
//			String query = "delete from userinfo where id = ?";
//			try (PreparedStatement pstmt = con.prepareStatement(query)) {
//				pstmt.setInt(1, id);
//				pstmt.executeUpdate();
//			}
//		} catch (ClassNotFoundException | SQLException ex) {
//			Logger.getLogger(UserCrudOp.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}

	public void updateUser(PojoClasses user) {
		try (Connection con = UserConnection.getConnection()) {
			String query = "update userinfo set name=?, mobile=?, date_of_birth=?, email=? WHERE id=?";
			try (PreparedStatement pstmt = con.prepareStatement(query)) {
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, user.getMobileNo());
				pstmt.setString(3, user.getDate());
				pstmt.setString(4, user.getEmail());
				pstmt.setInt(5, user.getId());
				int rowsAffected = pstmt.executeUpdate();
				System.out.println("Rows affected: " + rowsAffected);
			}
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(UserCrudOp.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public ArrayList<PojoClasses> searchUsersByName(String name) throws ClassNotFoundException, SQLException {
		ArrayList<PojoClasses> userList = new ArrayList<>();
		Connection conn = UserConnection.getConnection();
		String pattern = "select * from users where username like ?";
		PreparedStatement ps = conn.prepareStatement(pattern);
		ps.setString(1, "%" + name + "%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			PojoClasses user = new PojoClasses();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setMobileNo(rs.getString("mobile"));
			user.setDate(rs.getString("date"));
			user.setEmail(rs.getString("email"));
			userList.add(user);
		}
		rs.close();
		ps.close();
		conn.close();
		return userList;
	}

	public void deleteUser(int id) {
		try (Connection con = UserConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("update userinfo set deleted = 1 where id = ?")) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean signUp(String managerUsername, String managerPassword) throws SQLException, ClassNotFoundException {

		try (Connection con = UserConnection.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT task_id FROM todo4 WHERE manager_username = ?")) {
				statement.setString(1, managerUsername);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
					// System.out.println("This username already exists.");
					return false;
				} else {

					return true;
				}
			}
		}
	}


