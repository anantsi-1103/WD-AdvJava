<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Register</title>

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
	background: linear-gradient(135deg, #ff9966, #ff5e62);
}

.container {
	width: 550px;
	background: white;
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
	animation: fade 0.8s ease;
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
h2 {
	text-align: center;
	margin-bottom: 25px;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 12px;
	border-radius: 6px;
	border: 1px solid #ccc;
}

.pass-box {
	position: relative;
}

.eye {
	position: absolute;
	right: 10px;
	top: 10px;
	cursor: pointer;
}

button {
	width: 100%;
	padding: 12px;
	border: none;
	background: #ff5e62;
	color: white;
	font-size: 16px;
	border-radius: 8px;
	cursor: pointer;
	transition: .3s;
}

button:hover {
	background: #ff2e36;
	transform: scale(1.05);
}

#msg {
	font-weight: bold;
	text-align: center;
	margin-bottom: 10px;
}
</style>

<script>
	function togglePass1() {
		let p = document.getElementById("pass1");

		if (p.type === "password")
			p.type = "text";
		else
			p.type = "password";
	}

	function togglePass2() {
		let p = document.getElementById("pass2");

		if (p.type === "password")
			p.type = "text";
		else
			p.type = "password";
	}

	function verifyPassword() {

		let p1 = document.getElementById("pass1").value;
		let p2 = document.getElementById("pass2").value;
		let msg = document.getElementById("msg");

		if (p1 === p2) {
			msg.innerHTML = "Password Matched";
			msg.style.color = "green";
		} else {
			msg.innerHTML = "Password Not Matched";
			msg.style.color = "red";
		}

	}
</script>

</head>
<body>

	<div class="container">

		<h2>User Registration</h2>

		<p id="msg"></p>

		<form action="uReg" method="post">

			<input type="number" name="uId" placeholder="User ID" required>

			<input type="text" name="fname" placeholder="First Name" required>

			<input type="text" name="lname" placeholder="Last Name" required>

			<input type="email" name="email" placeholder="Email" required>

			<input type="tel" name="phone" placeholder="Phone" required>

			<input type="text" name="address" placeholder="Address" required>

			<input type="text" name="uname" placeholder="Username" required>

			<div class="pass-box">
				<input type="password" name="pass" id="pass1" placeholder="Password"
					required> <span class="eye" onclick="togglePass1()">👁</span>
			</div>

			<div class="pass-box">
				<input type="password" id="pass2" placeholder="Confirm Password"
					onkeyup="verifyPassword()" required> <span class="eye"
					onclick="togglePass2()">👁</span>
			</div>

			<button type="submit">Register</button>

		</form>

	</div>

</body>
</html>