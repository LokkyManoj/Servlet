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
	private UserCrudOp userCrudOp = new UserCrudOp();

	public MyserverApp() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		String username = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		String date = request.getParameter("date");
		String email = request.getParameter("email");

		PojoClasses pj = new PojoClasses(username, mobile, date, email);
		userCrudOp.addUser(pj);

		request.setAttribute("user", pj);
		ArrayList<PojoClasses> userList = userCrudOp.getAllUsers();
		request.setAttribute("userList", userList);

		request.getRequestDispatcher("UserCred.jsp").forward(request, response);
		
		
	}
		
		
		  

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
        if(action != null && action.equals("Delete")){
            System.out.println( "id from dopost" +request.getParameter("deleteid"));

            int id =Integer.parseInt( request.getParameter("deleteid"));
            userCrudOp.deleteUser(id);
            // Redirect to a success page or refresh the current page
    		ArrayList<PojoClasses> userList = userCrudOp.getAllUsers();
    		request.setAttribute("userList", userList);

    		request.getRequestDispatcher("UserCred.jsp").forward(request, response);

        } else {
            // Handle other POST requests (e.g., update)
        }
    }
	
	}

