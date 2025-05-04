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
        String password = request.getParameter("password");

        String role = request.getParameter("role"); // admin or student

        boolean loginSuccess = false;

        if ("admin".equals(role)) {
            Admin admin = new Admin();
            admin.setAdminEmail(email);
            admin.setAdminPassword(password);
            loginSuccess = adminController.doLogin(email, password);
        } else if ("student".equals(role)) {
            Student student = new Student();
            student.setStudentEmail(email);
            student.setStudentPassword(password);
            loginSuccess = studentController.doLogin(email, password);
        }

        if (loginSuccess) {
            // Create session for the logged-in user
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("role", role);

            if ("admin".equals(role)) {
                response.sendRedirect("admin-dashboard.jsp");
            } else if ("student".equals(role)) {
                response.sendRedirect("student-dashboard.jsp");
            }
        } else {
            // If login fails, redirect to login page with error message
            response.sendRedirect("pages/login.jsp?error=invalid_credentials");
        }
	}

}
