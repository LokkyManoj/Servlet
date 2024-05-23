package com.maintain.server;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintain.model.PojoClasses;
import com.maintain.util.UserCrudOp;

/**
 * Servlet implementation class MyserverApp2
 */
@WebServlet("/UpdateUserServlet")
public class MyserverApp2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public UserCrudOp userCrudOp = new UserCrudOp();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyserverApp2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		System.out.println(action);
		if(action != null && action.equals("Update")){
			/*
			 * System.out.println( "id from dopost" +request.getParameter("deleteid"));
			 */
			 int id = Integer.parseInt(request.getParameter("updateid"));
			 System.out.println(id);
		        String name = request.getParameter("name");
		        String mobile = request.getParameter("mobile");
		        String dob = request.getParameter("dob");
		        String email = request.getParameter("email");

		        PojoClasses user = new PojoClasses();
		        user.setId(id);
		        user.setUserName(name);
		        user.setMobileNo(mobile);
		        user.setDate(dob);
		        user.setEmail(email);

		        userCrudOp.updateUser(user);
		        ArrayList<PojoClasses> userList = userCrudOp.getAllUsers();
	    		request.setAttribute("userList", userList);

	    		request.getRequestDispatcher("UserCred.jsp").forward(request, response);


        }

	}

}
