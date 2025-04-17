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
		String action = request.getParameter("action");
		switch(action) {
			case "list":
				loadTask(request, response);
				break;
			case "create":
				createTask(request, response);
				break;
			case "edit":
				loadTaskById(request, response);
				break;
			case "update":
				updateTask(request, response);
				break;
			case "delete":
				deleteTask(request, response);
				break;
			default:
				loadTask(request, response);
					
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void loadTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	protected void loadTaskById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "1234");
			Statement stmt = con.createStatement();
			// for table to list all tasks
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
			// to load single task by id
			int id = Integer.parseInt(request.getParameter("id"));
			String query_by_id = "SELECT * FROM task WHERE id=" + id;
			ResultSet rs_single = stmt.executeQuery(query_by_id);
			while(rs_single.next()) {
				request.setAttribute("id", rs_single.getInt("id"));
				request.setAttribute("title", rs_single.getString("title"));
				request.setAttribute("description", rs_single.getString("description"));
				request.setAttribute("start_date", rs_single.getString("start_date"));
				request.setAttribute("due_date", rs_single.getString("due_date"));
				request.setAttribute("status", rs_single.getString("status"));
			}
			RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
			dispatch.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	protected void createTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			loadTask(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
	
	protected void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String start_date = request.getParameter("start_date");
		String due_date = request.getParameter("due_date");
		String status = request.getParameter("status");
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "1234");
			Statement stmt = con.createStatement();
			String query = "update task set title='"+title+"', description='"+description+"', "
					+ "start_date='"+start_date+"', due_date='"+due_date+"', status='"+status+"' "
							+ "where id=" + id;
			int result = stmt.executeUpdate(query);
			if(result > 0) {
				request.setAttribute("success", "Task updated successfully");
			} else {
				request.setAttribute("failure", "Something went wrong!");
			}
			loadTask(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
	
	protected void deleteTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspcrud", "root", "1234");
			Statement stmt = con.createStatement();
			int id = Integer.parseInt(request.getParameter("id"));
			String query = "DELETE FROM task WHERE id=" + id;
			int result = stmt.executeUpdate(query);
			if(result > 0) {
				request.setAttribute("success", "Task deleted successfully");
			} else {
				request.setAttribute("failure", "Something went wrong!");
			}
			loadTask(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		}
	}

}
