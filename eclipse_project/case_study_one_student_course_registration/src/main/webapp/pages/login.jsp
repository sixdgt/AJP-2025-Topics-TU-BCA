<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Course Registration | Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
  </head>
  <body>
    <header>
    	<nav class="navbar navbar-expand-lg bg-dark text-white">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">SCR</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0 text-white">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="<% request.getContextPath(); %>">Home</a>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
    </header>
    <main class="container">
	    <div class="container mt-5" style="max-width: 400px;">
		    <h2 class="text-center mb-4">Login</h2>
		
		    <% 
			    String error = request.getParameter("error");
			    if ("invalid_credentials".equals(error)) {
			%>
			        <p style="color: red;">Invalid credentials. Please try again.</p>
			<% 
			    }
			%>
		
		    <form action="login" method="POST">
			    <label for="email">Email:</label>
			    <input type="text" name="email" required><br><br>
			
			    <label for="password">Password:</label>
			    <input type="password" name="password" required><br><br>
			
			    <label for="role">Role:</label>
			    <select name="role" required>
			        <option value="admin">Admin</option>
			        <option value="student">Student</option>
			    </select><br><br>
			
			    <button type="submit">Login</button>
			</form>
		</div>
    </main>
    <!-- Bootstrap 5 Footer -->
	<footer class="bg-dark text-white pt-4 pb-2 mt-5">
	  <div class="container">
	    <div class="row">
	
	      <!-- System Info -->
	      <div class="col-md-4">
	        <h5>Student Course Registration</h5>
	        <p>Manage your academic journey — from course enrollments to schedules, all in one place.</p>
	      </div>
	
	      <!-- Quick Links -->
	      <div class="col-md-4">
	        <h5>Quick Links</h5>
	        <ul class="list-unstyled">
	          <li><a href="/dashboard" class="text-white text-decoration-none">Dashboard</a></li>
	          <li><a href="/courses" class="text-white text-decoration-none">Available Courses</a></li>
	          <li><a href="/register" class="text-white text-decoration-none">Register</a></li>
	          <li><a href="/results" class="text-white text-decoration-none">Results</a></li>
	        </ul>
	      </div>
	
	      <!-- Contact Info -->
	      <div class="col-md-4">
	        <h5>Contact Us</h5>
	        <p>Email: support@university.edu<br>Phone: +1 (234) 567-890</p>
	        <p>Address: 123 Campus Road, Education City</p>
	      </div>
	
	    </div>
	    <hr class="bg-white">
	    <p class="text-center mb-0">&copy; 2025 Student Course Registration System. All rights reserved.</p>
	  </div>
	</footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
  </body>
</html>