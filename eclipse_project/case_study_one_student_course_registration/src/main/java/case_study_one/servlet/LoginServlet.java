package case_study_one.servlet;

import case_study_one.model.Admin;
import case_study_one.model.Student;
import case_study_one.controller.AdminController;
import case_study_one.controller.StudentController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminController adminController;
    private StudentController studentController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
        adminController = new AdminController();
        studentController = new StudentController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String new_password = request.getParameter("new_password");
        String current_password = request.getParameter("current_password");

        String role = request.getParameter("role"); // admin or student

        HttpSession session = request.getSession();
        if ("admin".equals(role)) {
            if(adminController.doLogin(email, new_password, current_password)) {
            	session.setAttribute("email", email);
                session.setAttribute("role", role);
                response.sendRedirect("admin-dashboard.jsp");
            }
        } else if ("student".equals(role)) {
            if(studentController.doLogin(email, new_password, current_password)) {
            	session.setAttribute("email", email);
                session.setAttribute("role", role);
            	response.sendRedirect("student-dashboard.jsp");
            }
        } else {
            // If login fails, redirect to login page with error message
            response.sendRedirect("pages/login.jsp?error=invalid_credentials");
        }
	}

}
