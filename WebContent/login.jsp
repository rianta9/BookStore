<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/login-logout-controller.css">
	<title>Insert title here</title>
</head>
<body>
	<div class="loginform">
		<div class="modal">
			<div class="modal-content">
				<p class="welcome">Welcome</p>
				<form action="LoginController" method="post">
				
					<label for="indentity">Indentity</label>
					<input type="text" id="indentity" name="indentity" value="${after.indentity}"
					placeholder="Enter email or phone" required> 
					<span class="error" name="error-indentity">${errors.illegal_indentity}</span>
					<br>
					<br>
					
					<label for="password">Password</label>
					<input type="password" id="password" name="password" placeholder="Enter password" required> 
					<span class="error" name="error-login">${errors.loginfail}</span>
					<br>
					<br>
					<input type="submit" value="Đăng Nhập" name="loginbtn" class="button br-20"> 
					<br> <br>
				</form>
				<p class="text-center"> <span class="txt1">Don't have an account?</span> <span class="txt2"><a href="SignUpController">Sign Up</a></span></p>
			</div>
		</div>
	</div>
</body>
</html>