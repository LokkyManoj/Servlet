package todo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.util.SimpleToDoListManager1;
import todo.util.ToDoListConnection1;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class FirstServletTodo
 */
@WebServlet("/firstservlet")
public class FirstServletTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleToDoListManager1 manager;  

    public FirstServletTodo() throws ClassNotFoundException, SQLException {
        super();
        manager = new SimpleToDoListManager1();
    }

     /**
     * @see HttpServlet#HttpServlet()
     */
//    public FirstServletTodo() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String option = request.getParameter("action");
		System.out.println("opt: "+ option);
		if(option.equals("Signup"))
		{
			String name = request.getParameter("managerName");
			String password = request.getParameter("managerPassword");
			
			try {
				if(!manager.signUp(name, password))
				{
					System.out.println("This username already exists.");
					request.getRequestDispatcher("Registration.html").forward(request, response);
				}
				else
				{
					System.out.println("next page");

					String empName=request.getParameter("EmpName");
					int empID=Integer.parseInt(request.getParameter("EmpID"));
					int taskID=Integer.parseInt(request.getParameter("TaskID"));
					String task=request.getParameter("Task");
					int prior=Integer.parseInt(request.getParameter("Prior"));
					String dueDate=request.getParameter("date");
					String dueDateString = request.getParameter("date");

					// Define the date format you expect the dueDate string to be in
//					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//					Date dueDate = null;
//					try {
//					    dueDate = dateFormat.parse(dueDateString);
//					} catch (ParseException e) {
//					    e.printStackTrace();
//					    // Handle the error appropriately
//					}

					
					manager.addTask1(name, password, taskID, task,null, name, empID, prior);
							
					
					request.getRequestDispatcher("EmployeeDetails.html").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
