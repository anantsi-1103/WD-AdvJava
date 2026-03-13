<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.logic.bean.UserBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>

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
	background: linear-gradient(135deg, #6dd5ed, #2193b0);
}

.dashboard {
	background: white;
	padding: 50px;
	border-radius: 15px;
	width: 420px;
	text-align: center;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
	animation: slide 0.7s ease;
}

@
keyframes slide {from { opacity:0;
	transform: translateY(40px);
}

to {
	opacity: 1;
}

}
.dashboard h1 {
	margin-bottom: 30px;
	color: #333;
}

.btn {
	display: block;
	width: 100%;
	padding: 12px;
	margin: 12px 0;
	border: none;
	border-radius: 8px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	transition: .3s;
}

.view {
	background: #3498db;
	color: white;
}

.edit {
	background: #f1c40f;
}

.logout {
	background: #e74c3c;
	color: white;
}

.btn:hover {
	transform: scale(1.05);
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
	%>

	<div class="dashboard">

		<h1>
			Welcome,
			<%=ub.getFname()%>
			👋
		</h1>

		<a href="UserDetail.jsp">
			<button class="btn view">View Details</button>
		</a> <a href="EditProfile.jsp">
			<button class="btn edit">Edit Profile</button>
		</a> <a href="Logout.jsp">
			<button class="btn logout">Logout</button>
		</a>

	</div>

	<%
	}
	%>

</body>
</html>