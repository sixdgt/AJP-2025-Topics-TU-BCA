<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	* {
		margin: 0;
		padding: 0;
		border-box: box-shadow;
	}
	
	main {
		background: #f1f2f2;
		height: 100vh;
		width: 100%;
	}
	
	.form-content {
		width: 100%;
		padding: 5rem;
		border: 1px solid #000;
		marding: 5rem;
		display: flex;
		flex-direction: column;
		justify-content: around;
	}
	
	.form-content form {
		display:flex;
		flex-direction: row;
		justify-content: around;
	}
	input[type="number"] {
		width: 350px;
		height: 50px;
	}
	
	input[type="submit"] {
		width: 350px;
		height: 20px;
	}
</style>
<body>
<main>
	<section class="form-content">
		<h1>Guess The Number</h1>
		<form method="post" action="GuessTheNumber">
		
			<input
			type="number"
			name="guessed_number"
			placeholder="Enter the number"
			>
			
			<input
			type="submit"
			value="Guess">
		</form>
	</section>
	<section class="result">
		<% String user_guessed = (String) request.getAttribute("user_guessed"); %>
		<h1><%= user_guessed != null? "Your current guess is: " + user_guessed: "Please enter number first." %></h1>
	</section>
</main>
</body>
</html>