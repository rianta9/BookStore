<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<title>Insert title here</title>
</head>
<body>
	<div class="signupform">
		<div class="modal-signup">
			<div class="modal-content">
				<p class="welcome">Sign Up</p>
				<form action="SignUpController" method="post">
					<label for="username">Username</label>
					<input type="text" id="username" name="username" value="${after.username}"
					placeholder="Enter username" required> 
					<span class="error" name="error-username">${errors.illegal_username}</span>
					<br>

					<label for="fullname">Full Name</label>
					<input type="text" id="fullname" name="fullname" value="${after.fullname}"
					placeholder="Enter full name" required> 
					<span class="error" name="error-fullname">${errors.illegal_fullname}</span>
					<br>

					<label for="phone">Phone</label>
					<input type="tel" id="phone" name="phone" value="${after.phone}"
					placeholder="Enter phone" required> 
					<span class="error" name="error-phone">${errors.illegal_phone}</span>
					<br>

					<label for="password">Password</label>
					<input type="password" id="password" name="password" value="${after.password}"
					placeholder="Enter password" required> 
					<span class="error" name="error-password">${errors.illegal_password}</span>
					<br>

					<label for="confirm-password">Confirm Password</label>
					<input type="password" id="confirm-password" name="confirm-password" placeholder="Confirm password" value="${after.password}" required> 
					<span class="error" name="error-confirm-password">${errors.confirm_password}</span>
					<br>
					
					<input type="checkbox" name="checkbox">
					<span class="checkbox">I accept the <a href="#">Terms of Use</a> and <a href="#">Private Policy</a>.</span>
					
					<br>
					<br>
					<input type="submit" value="Sign Up" name="signupbtn" class="button br-20"> 
					<br> 
				</form>
				<p class="text-center"> <span class="txt1">Have an account?</span> <span class="txt2"><a href="LoginController">Log In</a></span></p>
			</div>
		</div>
	</div>
</body>
</html>