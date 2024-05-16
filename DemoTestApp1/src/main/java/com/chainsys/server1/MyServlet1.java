package com.chainsys.server1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegistrationPojo;

/**
 * Servlet implementation class MyServlet1
 */
@WebServlet("/activeServlet")
public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> userDetails = new ArrayList<>();
	RegistrationPojo reg=new RegistrationPojo();
	Users user=new Users();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet1() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");

		String mobile = request.getParameter("mobile");
		String date=request.getParameter("date");
		String email=request.getParameter("email");
		System.out.println(date);
		user.addUser(username, mobile, date,email);
		request.setAttribute("user", user.getUser());
		
		request.getRequestDispatcher("UserCred.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
