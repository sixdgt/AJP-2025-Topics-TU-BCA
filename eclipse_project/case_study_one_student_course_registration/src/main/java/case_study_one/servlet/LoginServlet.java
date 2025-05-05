package case_study_one.servlet;

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

        HttpSession session = request.getSession();
        if ("admin".equals(role)) {
            if(adminController.doLogin(email, password)) {
            	session.setAttribute("email", email);
                session.setAttribute("role", role);
//                request.getRequestDispatcher("pages/admin/dashboard.jsp").forward(request, response);
                response.sendRedirect(request.getContextPath() + "/admin?action=null");
            } else {
            	response.sendRedirect(request.getContextPath() + "/login?error=invalid_credentials");
            }
        } else if ("student".equals(role)) {
            if(studentController.doLogin(email, password)) {
            	session.setAttribute("email", email);
                session.setAttribute("role", role);
            	response.sendRedirect(request.getContextPath() + "/student?action=");
            }else {
            	response.sendRedirect(request.getContextPath() + "/login?error=invalid_credentials");
            }
        } else {
            // If login fails, redirect to login page with error message
            response.sendRedirect(request.getContextPath() + "/login?error=invalid_credentials");
        }
	}

}
