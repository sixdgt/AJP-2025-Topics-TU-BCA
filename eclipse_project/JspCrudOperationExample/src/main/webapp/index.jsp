<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
		<head>
		<meta charset="UTF-8">
		<title>JSP Crud Operation</title>
	
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
	</head>
	<body>
		<main class="container">
			<h3><a href="todo?action=list">Clear Action</a></h3>
			<% if(request.getAttribute("success") != null){  %>
			<div class="alert alert-success" role="alert">
			  <%= request.getAttribute("success") %>
			</div>
			<% } %>
			<% if(request.getAttribute("failure") != null){  %>
			<div class="alert alert-danger" role="alert">
			  <%= request.getAttribute("failure") %>
			</div>
			<% } %>
			<section class="card p-5 m-5">
			<% if(request.getParameter("action").equals("edit")){ %>
				<h2 class="card-title">Update Task</h2>
				<form method="post" action="todo?action=update">
					<input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
					<div class="form-group">
						<label for="title">Task Title:</label>
						<input type="text" class="form-control" name="title" required value="<%= request.getAttribute("title") %>">
					</div>
					<div class="form-group">
						<label for="title">Task Description:</label>
						<input type="text" class="form-control" name="description" required value="<%= request.getAttribute("description") %>">
					</div>
					<div class="form-group">
						<label for="title">Start Date: <%= request.getAttribute("start_date") %></label>
						<input type="date" class="form-control" name="start_date" required>
					</div>
					<div class="form-group mb-2">
						<label for="title">Due Date: <%= request.getAttribute("due_date") %></label>
						<input type="date" class="form-control" name="due_date" required>
					</div>
					<div class="form-group">
						<label>Task Status: <%= request.getAttribute("status") %></label>
						
						<select class="form-control" name="status">
							<option value="in_progress">In Progress</option>
							<option value="partial_complete">Partial Complete</option>
							<option value="complete">Complete</option>
						</select>
					</div>
					<input type="submit" class="btn btn-primary btn-sm mt-3" value="Update Task">
				</form>
			<% } else {%>
				<h2 class="card-title">Add Task</h2>
				<form method="post" action="todo?action=create">
					<div class="form-group">
						<label for="title">Task Title:</label>
						<input type="text" class="form-control" name="title" required>
					</div>
					<div class="form-group">
						<label for="title">Task Description:</label>
						<input type="text" class="form-control" name="description" required>
					</div>
					<div class="form-group">
						<label for="title">Start Date:</label>
						<input type="date" class="form-control" name="start_date" required>
					</div>
					<div class="form-group mb-2">
						<label for="title">Due Date:</label>
						<input type="date" class="form-control" name="due_date" required>
					</div>
					<input type="submit" class="btn btn-primary btn-sm mt-3" value="Add Task">
				</form>
			<% } %>
			</section>
			<section class="card">
				<table class="table table-hover p-5">
					<thead>
						<tr>
							<th>S.No</th>
							<th>ID</th>
							<th>Title</th>
							<th>Description</th>
							<th>Start Date</th>
							<th>Due Date</th>
							<th>Status</th>
							<th>Add Date</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
							@SuppressWarnings("unchecked")
							ArrayList<Object[]> tasks = (ArrayList<Object[]>)request.getAttribute("tasks");
							if(tasks != null){
								int counter = 1;
								for(Object[] task: tasks){
									%>
									<tr>
										<td><%= counter %></td>
										<td><%= task[0] %></td>
										<td><%= task[1] %></td>
										<td><%= task[2] %></td>
										<td><%= task[3] %></td>
										<td><%= task[4] %></td>
										<td><%= task[5] %></td>
										<td><%= task[6] %></td>
										<td><a href="todo?action=edit&id=<%= task[0] %>" class="btn btn-primary btn-sm">Edit</a></td>
										<td><a href="todo?action=delete&id=<%= task[0] %>" class="btn btn-danger btn-sm">Delete</a></td>
									</tr>
									<%
									counter++;
								}
							}
						%>
					</tbody>
				</table>
			</section>
		</main>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.min.js" integrity="sha384-VQqxDN0EQCkWoxt/0vsQvZswzTHUVOImccYmSyhJTp7kGtPed0Qcx8rK9h9YEgx+" crossorigin="anonymous"></script>
	</body>
</html>