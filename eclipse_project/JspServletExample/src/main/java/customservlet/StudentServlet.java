package customservlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = "Jsp & Servlet Session Day 1";
		ArrayList<String> data = new ArrayList<>();
		data.add("Card One");
		data.add("Card Two");
		data.add("Card Three");
		data.add("Card Four");
		
		request.setAttribute("title", title);
		request.setAttribute("card_data", data);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String full_name = request.getParameter("student_name");
		String address = request.getParameter("student_address");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("student_name", full_name);
		request.setAttribute("student_address", address);
		dispatcher.forward(request, response);
	}

}
