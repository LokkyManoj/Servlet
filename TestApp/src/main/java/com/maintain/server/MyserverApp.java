package com.maintain.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintain.model.PojoClasses;
import com.maintain.util.UserConnection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Servlet implementation class MyserverApp
 */
@WebServlet("/openServlet")
public class MyserverApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Users user = new Users();
	PojoClasses pj=new PojoClasses();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyserverApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");

		String mobile = request.getParameter("mobile");
		String date=request.getParameter("date");
		String email=request.getParameter("email");
		
		pj.setUserName(username);
		
		pj.setMobileNo(mobile);
		pj.setDate(date);
		pj.setEmail(email);
		
		
		
		
		
		System.out.println(date);
		user.addUser(username, mobile, date,email);
		request.setAttribute("user", user.getUser());
		
		  try (Connection con = UserConnection.getConnection()) {
	            String query = "INSERT INTO userinfo (name, mobile, date_of_birth, email) VALUES (?, ?, ?, ?)";
	            try (PreparedStatement pstmt = con.prepareStatement(query)) {
	                // Setting parameters for the query
	                pstmt.setString(1, username);
	                pstmt.setString(2, mobile);
	                pstmt.setString(3, date);
	                pstmt.setString(4, email);

	                // Executing the query
	               int set =  pstmt.executeUpdate();
	               System.out.println(set);
	            } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } catch (ClassNotFoundException | SQLException ex) {
	        	System.out.println("catch");
	        	Logger.getLogger(MyserverApp.class.getName()).log(Level.SEVERE, null, ex);
			} 		
//		request.getRequestDispatcher("UserCred.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
