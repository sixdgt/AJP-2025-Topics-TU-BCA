package case_study_one.servlet;

import case_study_one.controller.AdminController;
import case_study_one.controller.CourseController;
import case_study_one.controller.EnrollController;
import case_study_one.controller.StudentController;
import case_study_one.model.Course;
import case_study_one.model.Enroll;
import case_study_one.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class AdminServlet
 */

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminController adminController;
    private StudentController studentController;
    private CourseController courseController;
    private EnrollController enrollController;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
        // Initialize controllers
        adminController = new AdminController();
        studentController = new StudentController();
        courseController = new CourseController();
        enrollController = new EnrollController();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action == null) {
            // Default view: Show dashboard
            request.getRequestDispatcher("admin-dashboard.jsp").forward(request, response);
        } else {
            switch (action) {
                case "viewStudents":
                    // View all students
                    request.setAttribute("students", studentController.getAllStudent());
                    request.getRequestDispatcher("view-students.jsp").forward(request, response);
                    break;
                case "viewCourses":
                    // View all courses
                    request.setAttribute("courses", courseController.getAllCourse());
                    request.getRequestDispatcher("view-courses.jsp").forward(request, response);
                    break;
                case "addStudent":
                    // Show add student page
                    request.getRequestDispatcher("add-student.jsp").forward(request, response);
                    break;
                case "addCourse":
                    // Show add course page
                    request.getRequestDispatcher("add-course.jsp").forward(request, response);
                    break;
                case "enrollStudent":
                    // Show enroll student in course page
                    request.setAttribute("students", studentController.getAllStudent());
                    request.setAttribute("courses", courseController.getAllCourse());
                    request.getRequestDispatcher("enroll-student.jsp").forward(request, response);
                    break;
                default:
                    // Default action, show admin dashboard
                    request.getRequestDispatcher("admin-dashboard.jsp").forward(request, response);
                    break;
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        if (action == null) {
            response.sendRedirect("admin");
        } else {
            switch (action) {
	            case "add-admin":
	            	addAdmin(request, response);
	                break;
                
                case "add-student":
                	addStudent(request, response);
                    break;

                case "add-course":
                	addCourse(request, response);
                    break;

                case "enroll-student":
                	enrollStudent(request, response);
                    break;

                default:
                    response.sendRedirect("admin");
                    break;
            }
        }
	}
	
	public void addAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> admin = new HashMap<>();
		admin.put("full_name", request.getParameter("first_name"));
		admin.put("email", request.getParameter("middle_name"));
		admin.put("password", request.getParameter("last_name"));        
        if (adminController.addAdmin(admin)) {
            response.sendRedirect("admin?action=viewStudents");
        } else {
            response.sendRedirect("admin?action=addStudent&error=failed");
        }
	}
	
	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> student = new HashMap<>();
         student.put("student_first_name", request.getParameter("first_name"));
         student.put("student_middle_name", request.getParameter("middle_name"));
         student.put("student_last_name", request.getParameter("last_name"));
         student.put("student_email", request.getParameter("email"));
         student.put("address", request.getParameter("address"));
         student.put("gender", request.getParameter("gender"));
         student.put("dob", request.getParameter("dob"));
         
      // Handle file upload
         Part filePart = request.getPart("profile_img");
         
         String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

         // Optional: Add logic to sanitize/rename file
         String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
         File uploadDir = new File(uploadPath);
         if (!uploadDir.exists()) uploadDir.mkdir();

         String filePath = uploadPath + File.separator + fileName;
         filePart.write(filePath); // Save file

         // Set relative path to store in DB
         String relativePath = "uploads/" + fileName;
         student.put("profile_img", relativePath);

         if (studentController.addStudent(student)) {
             response.sendRedirect("admin?action=viewStudents");
         } else {
             response.sendRedirect("admin?action=addStudent&error=failed");
         }
	}
	
	public void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> course = new HashMap<>();
    	course.put("code", request.getParameter("code"));
    	course.put("title", request.getParameter("title"));
    	course.put("description", request.getParameter("description"));
    	course.put("start_date", request.getParameter("start_date"));
    	course.put("end_date", request.getParameter("end_date"));
    	course.put("status", request.getParameter("status") + "");
    	course.put("category", request.getParameter("category"));
    	course.put("admin", request.getParameter("admin_id"));
        if (courseController.addCourse(course)) {
            response.sendRedirect("admin?action=viewCourses");
        } else {
            response.sendRedirect("admin?action=addCourse&error=failed");
        }
	}
	
	public void enrollStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> enroll = new HashMap<>();
        enroll.put("student_id", request.getParameter("student_id"));
        enroll.put("course_id", request.getParameter("course_id"));
        enroll.put("enroll_date", request.getParameter("enroll_date"));
        if (enrollController.addEnroll(enroll)) {
            response.sendRedirect("admin?action=viewCourses");
        } else {
            response.sendRedirect("admin?action=enrollStudent&error=failed");
        }
	}
}
