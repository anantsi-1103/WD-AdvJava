
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.logic.bean.BookBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details</title>

<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background: linear-gradient(135deg, #ff9966, #ff5e62);
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	background: white;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
	width: 500px;
	text-align: center;
}

h2 {
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: #ff5e62;
	color: white;
	padding: 12px;
}

td {
	padding: 10px;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background: #f5f5f5;
}

.btn {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 6px;
	color: white;
	font-weight: bold;
}

.home {
	background: #4CAF50;
}

.retry {
	background: #ff5e62;
}

.btn:hover {
	opacity: 0.85;
}

.error {
	color: red;
	font-weight: bold;
}
</style>

</head>

<body>

	<div class="container">

		<h2>📚 Book Details</h2>

		<%
		BookBean bb = (BookBean) request.getAttribute("bean");

		if (bb == null) {
		%>

		<p class="error">No Records Found</p>
		<a href="ViewByID.jsp" class="btn retry">Try Again</a>

		<%
} else {
%>

		<table>

			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book Price</th>
				<th>Book Author</th>
			</tr>

			<tr>
				<td><%=bb.getId()%></td>
				<td><%=bb.getName()%></td>
				<td>₹ <%=bb.getPrice()%></td>
				<td><%=bb.getAuthor()%></td>
			</tr>

		</table>

		<a href="index.html" class="btn home">🏠 Back to Home</a>

		<%
}
%>

	</div>

</body>
</html>

