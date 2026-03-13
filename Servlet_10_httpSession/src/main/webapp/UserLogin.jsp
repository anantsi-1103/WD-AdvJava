<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Segoe UI;
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
.login-box {
	width: 350px;
	padding: 40px;
	border-radius: 15px;
	background: rgba(255, 255, 255, 0.15);
	backdrop-filter: blur(15px);
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
	color: white;
}

.login-box h2 {
	text-align: center;
	margin-bottom: 30px;
}

.input-group {
	position: relative;
	margin-bottom: 20px;
}

.input-group input {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 8px;
	outline: none;
}

.eye {
	position: absolute;
	right: 10px;
	top: 12px;
	cursor: pointer;
	font-size: 18px;
	color: #333;
}

button {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 8px;
	background: #00c6ff;
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: .3s;
}

button:hover {
	background: #0072ff;
	transform: scale(1.05);
}

.error {
	color: yellow;
	margin-top: 10px;
	text-align: center;
}
</style>

<script>
	function togglePassword() {

		let pass = document.getElementById("password");
		let eye = document.getElementById("eye");

		if (pass.type === "password") {
			pass.type = "text";
			eye.innerHTML = "🙈";
		} else {
			pass.type = "password";
			eye.innerHTML = "👁";
		}

	}
</script>

</head>
<body>

	<div class="login-box">

		<h2>User Login</h2>

		<form action="uLogin" method="post">

			<div class="input-group">
				<input type="text" name="uname" placeholder="Username" required>
			</div>

			<div class="input-group">
				<input type="password" name="pword" id="password"
					placeholder="Password" required> <span class="eye" id="eye"
					onclick="togglePassword()">👁</span>
			</div>

			<button type="submit">Login</button>

		</form>

		<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>

		<p class="error"><%=msg%></p>

		<%}%>

	</div>

</body>
</html>