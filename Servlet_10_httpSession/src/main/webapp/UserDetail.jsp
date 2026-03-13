<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.logic.bean.CustomerBean"%>
<%@page import="com.logic.bean.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>

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
	background: linear-gradient(120deg, #89f7fe, #66a6ff);
}

.table-container {
	background: white;
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
	width: 500px;
	animation: fade 0.8s ease;
}

@
keyframes fade {from { opacity:0;
	transform: translateY(20px);
}

to {
	opacity: 1;
}

}
caption {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 20px;
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background: #3498db;
	color: white;
	padding: 12px;
	text-align: left;
}

td {
	padding: 12px;
	background: #f8f9fa;
	border-bottom: 1px solid #ddd;
}

tr:hover td {
	background: #eaf4ff;
}
</style>

</head>

<body>

	<%
	HttpSession hs = request.getSession(false);

	UserBean ub = (UserBean) hs.getAttribute("ubean");

	CustomerBean cb = (CustomerBean) hs.getAttribute("cbean");

	if (hs == null || ub == null) {

		request.setAttribute("msg", "Session Expired");

		RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");

		rd.include(request, response);

	} else {
	%>

	<div class="table-container">

		<table>

			<caption>User Details</caption>

			<tr>
				<th>User ID</th>
				<td><%=ub.getId()%></td>
			</tr>

			<tr>
				<th>Username</th>
				<td><%=cb.getUname()%></td>
			</tr>

			<tr>
				<th>First Name</th>
				<td><%=ub.getFname()%></td>
			</tr>

			<tr>
				<th>Last Name</th>
				<td><%=ub.getLname()%></td>
			</tr>

			<tr>
				<th>Email</th>
				<td><%=ub.getMid()%></td>
			</tr>

			<tr>
				<th>Phone</th>
				<td><%=ub.getPhone()%></td>
			</tr>

			<tr>
				<th>Address</th>
				<td><%=ub.getAddr()%></td>
			</tr>

		</table>

	</div>

	<%
	}
	%>

</body>
</html>