<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.SuppressWarnings" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JspServlet Example | BCA</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
  </head>
  <body>
  	<header>
  		<nav class="navbar navbar-expand-lg bg-body-tertiary">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">JSP & Servlet</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		      <div class="navbar-nav">
		        <a class="nav-link active" aria-current="page" href="#">Home</a>
		      </div>
		    </div>
		  </div>
		</nav>
  	</header>
  	<main class="container-fluid">
  		<a href="<%= request.getContextPath() %>/StudentServlet">Load Servlet Data</a>
  		<section class="card">
  			<div class="card-title p-5"><% 
  			String title = (String)request.getAttribute("title") != null?
  					(String)request.getAttribute("title") : "Servlet & Jsp Session | AJP";
  			out.print(title);
  			
  			%></div>
  		</section>
  		<section class="row d-flex justify-content-around">
	  		<%
			@SuppressWarnings("unchecked")
			List<String> data = (List<String>) request.getAttribute("card_data");
	  		if (data != null) {
	  		    for(String c_title : data) {
	  		%>
	  		    <div class="col-md-4 mb-3">
	  		        <div class="card p-3">
	  		            <div class="card-body">
	  		                <h5 class="card-title"><%= c_title %></h5>
	  		            </div>
	  		        </div>
	  		    </div>
	  		<%
	  		    }
	  		} else {
	  		%>
	  		    <div class="text-center p-5">
	  		        <h5>No data available.</h5>
	  		    </div>
	  		<%
	  		}
  			%>
  		</section>
  		<section class="container">
  			<div class="card p-5">
  				<form method="post" action="StudentServlet">
  					<div class="form-group mb-3">
  						<label for="student_name">Student Name:</label>
	  					<input 
	  					type="text" 
	  					name="student_name" 
	  					placeholder="Enter Name"
	  					class="form-control">
  					</div>
  					<div class="form-group mb-3">
  						<label for="student_name">Student Address:</label>
	  					<input 
	  					type="text" 
	  					name="student_address" 
	  					placeholder="Enter Address"
	  					class="form-control">
  					</div>
  					<input type="submit" class="btn btn-primary btn-block" value="Submit">
  				</form>
  				<div class="card-body mt-3 mb-2">
  					<% 
  					String student_name = (String)request.getAttribute("student_name") != null?
  							(String)request.getAttribute("student_name"):"";%>
  						<%= student_name %>	
  						
  						<% 
  					String student_address = (String)request.getAttribute("student_address") != null?
  							(String)request.getAttribute("student_address"):"";%>
  						<%= student_address %>	
  				</div>
 			</div>
 		</section>
  	</main>
    <footer class="container text-center">
    	<h1 class="text-center">Copyright @2025</h1>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
  </body>
</html>