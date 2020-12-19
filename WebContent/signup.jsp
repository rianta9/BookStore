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
	<div class="signupform">
		
		<div class="modal-signup">
			<div class="modal-content">
			<div class = "back_form"><a href="SachController">back</a></div>
				<p class="welcome">Sign Up</p>
				<form action="AddUserController" method="post">
					
					<label for="fullname">Full Name</label>
					<input type="text" id="fullname" name="fullname" value="${after.fullname}"
					placeholder="Enter full name" minlength="4" required> 
					<span class="error" name="error-fullname">${errors.illegal_fullname}</span>
					<br>

					<label for="phone">Phone</label>
					<input type="text" id="phone" name="phone" value="${after.phone}"
					placeholder="Enter phone" maxlength="11" minlenght="7" required> 
					<span class="error" name="error-phone">${errors.illegal_phone}</span>
					<br>
					
					<label for="email">Email</label>
					<input type="email" id="email" name="email" value="${after.email}"
					placeholder="Enter email" required> 
					<span class="error" name="error-email">${errors.illegal_email}</span>
					<br>

					<label for="password">Password</label>
					<input type="password" id="password" name="password" value="${after.password}"
					placeholder="Enter password" minlength="6" required> 
					<span class="error" name="error-password">${errors.illegal_password}</span>
					<br>

					<label for="confirm-password">Confirm Password</label>
					<input type="password" id="confirm-password" name="confirm-password" placeholder="Confirm password" minlength="6" required> 
					<span class="error" name="error-confirm-password">${errors.illegal_confirm_password}</span>
					<br>
					
					<input type="checkbox" name="checkbox" checked="true">
					<span class="checkbox">I accept the <a href="#">Terms of Use</a> and <a href="#">Private Policy</a>.</span>
					
					<br>
					<br>
					<input type="submit" value="Sign Up" name="signupbtn" class="button br-20"> 
					<br> 
					<span class="error" name="error-confirm-password">${errors.signup_fail}</span>
				</form>
				<p class="text-center"> <span class="txt1">Already have an account?</span> <span class="txt2"><a href="LoginController">Log In</a></span></p>
			</div>
		</div>
	</div>
</body>
</html>