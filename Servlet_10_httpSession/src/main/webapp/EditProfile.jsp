<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.logic.bean.CustomerBean"%>
<%@page import="com.logic.bean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Segoe UI', sans-serif;
}

body {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(135deg, #667eea, #764ba2);
}

.container {
	background: rgba(255, 255, 255, 0.15);
	backdrop-filter: blur(12px);
	padding: 40px;
	border-radius: 15px;
	width: 400px;
	box-shadow: 0 10px 30px rgba(0,0,0,0.3);
	color: white;
	animation: fadeIn 0.6s ease;
}

@keyframes fadeIn {
	from {
		opacity: 0;
		transform: translateY(30px);
	}
	to {
		opacity: 1;
	}
}

h2 {
	text-align: center;
	margin-bottom: 25px;
}

table {
	width: 100%;
}

th {
	text-align: left;
	padding: 10px 0;
	font-size: 14px;
}

td {
	padding-bottom: 10px;
}

input {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 8px;
	outline: none;
	font-size: 14px;
}

input:focus {
	box-shadow: 0 0 5px #fff;
}

button {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 8px;
	background: #00c6ff;
	background: linear-gradient(to right, #00c6ff, #0072ff);
	color: white;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	transition: 0.3s;
	margin-top: 10px;
}

button:hover {
	transform: scale(1.05);
}

.readonly {
	background: #ddd;
	color: #555;
}

</style>

</head>

<body>

<%
HttpSession hs = request.getSession(false);

if (hs == null || hs.getAttribute("ubean") == null) {

	request.setAttribute("msg", "Session Expired");
	RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
	rd.include(request, response);

} else {

	UserBean ub = (UserBean) hs.getAttribute("ubean");
	CustomerBean cb = (CustomerBean) hs.getAttribute("cbean");

	String uname = (cb != null) ? cb.getUname() : "";
%>

<div class="container">

	<h2>✏️ Edit Profile</h2>

	<form action="edit" method="post">
		<table>
			<tr>
				<th>User ID</th>
				<td>
					<input type="text" name="uId" readonly class="readonly"
						value="<%=ub.getId()%>">
				</td>
			</tr>

			<tr>
				<th>First Name</th>
				<td>
					<input type="text" name="fname"
						value="<%=ub.getFname()%>">
				</td>
			</tr>

			<tr>
				<th>Last Name</th>
				<td>
					<input type="text" name="lname"
						value="<%=ub.getLname()%>">
				</td>
			</tr>

			<tr>
				<th>Email</th>
				<td>
					<input type="email" name="email"
						value="<%=ub.getMid()%>">
				</td>
			</tr>

			<tr>
				<th>Phone</th>
				<td>
					<input type="text" name="phone"
						value="<%=ub.getPhone()%>">
				</td>
			</tr>

			<tr>
				<th>Address</th>
				<td>
					<input type="text" name="addr"
						value="<%=ub.getAddr()%>">
				</td>
			</tr>

			<tr>
				<th>Username</th>
				<td>
					<input type="text" name="uname"
						value="<%=uname%>">
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<button type="submit">Update Profile</button>
				</td>
			</tr>
		</table>
	</form>

</div>

<% } %>

</body>
</html>  