package jspcrud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class ToDoListServlet
 */
@WebServlet("/todo")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "1234");
			Statement stmt = con.createStatement();
			
			String query = "SELECT * FROM task";
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<Object> tasks = new ArrayList<>();
			while(rs.next()) {
				Object[] task = {
						rs.getInt("id"), 
						rs.getString("title"), 
						rs.getString("description"),
						rs.getString("start_date"),
						rs.getString("due_date"),
						rs.getString("status"),
						rs.getString("created_at")
				};
				tasks.add(task);
			}
			request.setAttribute("tasks", tasks);
			RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
			dispatch.forward(request, response);
			
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String start_date = request.getParameter("start_date");
		String due_date = request.getParameter("due_date");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "1234");
			Statement stmt = con.createStatement();
			String query = "insert into task(title, description, start_date, due_date) values"
					+ "('"+title+"', '"+description+"', '"+start_date+"', '"+due_date+"')";
			int result = stmt.executeUpdate(query);
			if(result > 0) {
				request.setAttribute("success", "Task added successfully");
			} else {
				request.setAttribute("failure", "Something went wrong!");
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		}
	}

}
