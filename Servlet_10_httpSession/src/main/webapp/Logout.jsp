<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>

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
	background: linear-gradient(135deg, #ff758c, #ff7eb3);
}

.card {
	background: white;
	padding: 40px;
	border-radius: 15px;
	text-align: center;
	box-shadow: 0 10px 30px rgba(0,0,0,0.3);
	width: 350px;
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
	color: #333;
	margin-bottom: 15px;
}

p {
	color: #666;
	margin-bottom: 20px;
}

.loader {
	width: 40px;
	height: 40px;
	border: 4px solid #ddd;
	border-top: 4px solid #ff4b5c;
	border-radius: 50%;
	margin: 0 auto;
	animation: spin 1s linear infinite;
}

@keyframes spin {
	100% {
		transform: rotate(360deg);
	}
}
</style>

</head>
<body>

<%
	HttpSession hs = request.getSession(false);
	if (hs != null) {
		hs.invalidate();
	}
%>

<div class="card">
	<h2> Logout Successful</h2>
	<p>You are being redirected to Login Page...</p>

	<div class="loader"></div>
</div>

<script>
	setTimeout(() => {
		window.location = "UserLogin.jsp";
	}, 2000);
</script>

</body>
</html>