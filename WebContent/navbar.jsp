<%@page import="bean.User"%>
<%@page import="bean.GioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="css/login.css">

<!-- SECTION NAVBAR -->
<section id="navbar">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="SachController"><img
					src="https://cdn0.fahasa.com/skin/frontend/ma_vanese/fahasa/images/fahasa-logo.png"
					width="120px" height="20px"></a>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<%
				GioHang gioHang = (GioHang) session.getAttribute("Gio");
			int soLuong = 0;
			if (gioHang != null)
				soLuong = gioHang.getList().size();
			%>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="GioHangController">Giỏ Hàng<%
						if (soLuong != 0) {
					%> (<%=soLuong%>) <%
						}
					%></a></li>
					<li><a href="#">Thanh Toán</a></li>
					<li><a href="LichSuMuaHangController">Lịch Sử Mua Hàng</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<%
						User userLog = (User) session.getAttribute("user");
					if (userLog == null) {
					%>

					<li><a href="SignUpController"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="#"
						onclick="document.getElementById('login-form').style.display='block'">
							<span class="glyphicon glyphicon-log-in"></span> Login
					</a></li>
					<%
						} else {
					%>
					<li><a href="ProfileController"> <span
							class="glyphicon glyphicon-user"></span> Xin chào, <%=userLog.getName()%>
					</a></li>
					<li><a href="LogoutController"> <span
							class="glyphicon glyphicon-log-out"></span> Logout
					</a></li>
					<%
						}
					%>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li>
						<form action="SachController">
							<div class="search-form1">
								<input type="text" class="search-input" placeholder="Search"
									name="search">
								<button class="search-button" type="submit">Search</button>
							</div>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</section>

<div id="login-form" class="modal-login">
	<div class="modal-content">
		<span
			onclick="document.getElementById('login-form').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<p class="welcome">Welcome</p>
		<form action="LoginController" method="post">

			<label for="indentity">Indentity</label> <input type="text"
				id="indentity" name="indentity" value="${after.indentity}"
				placeholder="Enter email or phone" required> <span
				class="error" name="error-indentity">${errors.illegal_indentity}</span>
			<br> <br> <label for="password">Password</label> <input
				type="password" id="password" name="password"
				placeholder="Enter password" required> <span class="error"
				name="error-login">${errors.loginfail}</span> <br> <br> <input
				type="submit" value="Đăng Nhập" name="loginbtn"
				class="button-lg br-20"> <br> <br>
		</form>
		<p class="text-center">
			<span class="txt1">Don't have an account?</span> <span class="txt2"><a
				href="SignUpController">Sign Up</a></span>
		</p>
	</div>
</div>

<script>
	// Get the modal
	var modal = document.getElementById('login-form');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>