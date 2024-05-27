package todo.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import todo.util.SimpleToDoListManager1;

@WebServlet("/firstservlet")
public class FirstServletTodo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SimpleToDoListManager1 manager;

    public FirstServletTodo() throws ClassNotFoundException, SQLException {
        super();
        manager = new SimpleToDoListManager1();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("action");
        System.out.println("opt: " + option);
        
        if ("Signup".equals(option)) {
            handleSignup(request, response);
        } else if ("Login".equals(option)) {
            handleLogin(request, response);
        }
    }

    private void handleSignup(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("managerName");
        String password = request.getParameter("managerPassword");

        try {
            if (!manager.signUp(name, password)) {
                System.out.println("This username already exists.");
                request.getRequestDispatcher("Registration.html").forward(request, response);
            } else {
                System.out.println("next page");
                request.getRequestDispatcher("EmployeeDetails.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("managerName");
        String password = request.getParameter("managerPassword");

        try {
            if (!manager.login(name, password)) {
                // Create a session and store user information
                HttpSession session = request.getSession();
                session.setAttribute("ManagerName", name);
               
                // Redirect to EmployeeDetails.html
               response.sendRedirect("EmployeeDetails.jsp");
//                request.getRequestDispatcher("EmployeeDetails.html").forward(request, response);

                System.out.println("Redirecting to EmployeeDetails.jsp");
            } else {
                System.out.println("Invalid username or password.");
                request.getRequestDispatcher("Login.html").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal error occurred.");
        }
    }
}
