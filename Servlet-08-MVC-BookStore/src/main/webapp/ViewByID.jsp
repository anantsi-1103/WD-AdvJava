
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Book</title>

<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background: linear-gradient(135deg, #36d1dc, #5b86e5);
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	background: white;
	padding: 35px;
	border-radius: 12px;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
	width: 350px;
	text-align: center;
}

h2 {
	margin-bottom: 20px;
}

input[type="number"] {
	width: 100%;
	padding: 10px;
	border-radius: 6px;
	border: 1px solid #ccc;
	margin-bottom: 20px;
	font-size: 14px;
}

input[type="number"]:focus {
	outline: none;
	border-color: #5b86e5;
}

button {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 6px;
	background: #5b86e5;
	color: white;
	font-weight: bold;
	cursor: pointer;
	transition: 0.3s;
}

button:hover {
	background: #3f66d1;
}

.home-btn {
	display: inline-block;
	margin-top: 20px;
	text-decoration: none;
	padding: 10px 18px;
	background: #36d1dc;
	color: white;
	border-radius: 6px;
	font-weight: bold;
}

.home-btn:hover {
	opacity: 0.85;
}
</style>

</head>

<body>

	<div class="container">

		<h2>🔍 Search Book by ID</h2>

		<form action="viewBy" method="post">

			<input type="number" name="id" placeholder="Enter Book ID" required>

			<button type="submit">Search Book</button>

		</form>

		<a href="index.html" class="home-btn">🏠 Back to Home</a>

	</div>

</body>
</html>

