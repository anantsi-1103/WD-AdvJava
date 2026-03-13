<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>

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
	background: linear-gradient(-45deg, #667eea, #764ba2, #6dd5ed, #2193b0);
	background-size: 400% 400%;
	animation: gradient 10s ease infinite;
}

@
keyframes gradient { 0%{
	background-position: 0% 50%;
}

50
%
{
background-position
:
100%
50%;
}
100
%
{
background-position
:
0%
50%;
}
}
.container {
	background: rgba(255, 255, 255, 0.15);
	backdrop-filter: blur(12px);
	padding: 50px 70px;
	border-radius: 15px;
	text-align: center;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
	color: white;
	animation: fade 1s ease;
}

@
keyframes fade {
	from {opacity: 0;
	transform: translateY(20px);
}

to {
	opacity: 1;
}

}
.container h1 {
	margin-bottom: 30px;
	font-size: 32px;
}

.btn {
	display: inline-block;
	padding: 12px 28px;
	margin: 10px;
	background: #00c6ff;
	color: white;
	text-decoration: none;
	border-radius: 8px;
	font-size: 16px;
	font-weight: bold;
	transition: .3s;
}

.btn:hover {
	background: #0072ff;
	transform: scale(1.08);
}

.msg {
	margin-bottom: 15px;
	color: yellow;
	font-weight: bold;
}
</style>
</head>

<body>

	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
	%>

	<p class="msg"><%=msg%></p>

	<%
	}
	%>

	<div class="container">

		<h1>Welcome to the Portal</h1>

		<a href="UserLogin.jsp" class="btn">Login</a> <a
			href="UserRegister.jsp" class="btn">Register</a>

	</div>

</body>
</html>