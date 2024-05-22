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
import com.maintain.util.UserCrudOp;

import java.util.ArrayList;
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
    public UserCrudOp userCrudOp = new UserCrudOp();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyserverApp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");

		String mobile = request.getParameter("mobile");
		String date=request.getParameter("date");
		String email=request.getParameter("email");
		
//		pj.setUserName(username);
//		
//		pj.setMobileNo(mobile);
//		pj.setDate(date);
//		pj.setEmail(email);
//	user.addUser(username, mobile, date,email);
//		request.setAttribute("user", user.getUser());
//	
//		  		request.getRequestDispatcher("UserCred.jsp").forward(request, response);
		 PojoClasses pj = new PojoClasses(username, mobile, date, email);
	        userCrudOp.addUser(pj);

	        request.setAttribute("user", pj);
	        ArrayList<PojoClasses> userList = userCrudOp.getAllUsers();
	        request.setAttribute("userList", userList);


	        request.getRequestDispatcher("UserCred.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
