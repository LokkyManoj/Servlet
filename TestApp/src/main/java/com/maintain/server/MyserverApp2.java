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
public class MyserverApp2 extends HttpServlet {
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
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		if(action != null && action.equals("Update")){
            // Handle other POST requests (e.g., update)
            System.out.println( "id from dopost" +request.getParameter("deleteid"));

			 int id = Integer.parseInt(request.getParameter("updateid"));
		        String name = request.getParameter("name");
		        String mobile = request.getParameter("mobile");
		        String dob = request.getParameter("dob");
		        String email = request.getParameter("email");

		        // Create a PojoClasses object with the updated information
		        PojoClasses user = new PojoClasses();
		        user.setId(id);
		        user.setUserName(name);
		        user.setMobileNo(mobile);
		        user.setDate(dob);
		        user.setEmail(email);

		        // Update the user information in the database
		        userCrudOp.updateUser(user);

		        // Redirect back to a success page or refresh the current page
	            response.sendRedirect("UserCred.jsp");


        }

	}

}
