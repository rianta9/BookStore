<%@page import="bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- SECTION NAVBAR -->
	<section id="navbar">
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="SachController"><img
						src="https://cdn0.fahasa.com/skin/frontend/ma_vanese/fahasa/images/fahasa-logo.png"
						width="120px" height="20px"></a>
				</div>

				<ul class="nav navbar-nav">
					<li><a href="GioHangController">Giỏ Hàng</a></li>
					<li><a href="#">Thanh Toán</a></li>
					<li><a href="LichSuMuaHangController">Lịch Sử Mua Hàng</a></li>
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
				<ul class="nav navbar-nav navbar-right">
					<%
					User userLog = (User)session.getAttribute("user");
					if(userLog == null){%>
					
					<li><a
						href="SignUpController"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a
						href="LoginController"> <span
							class="glyphicon glyphicon-log-in"></span> Login
					</a></li>
					<%} else{%>
					<li><a href="ProfileController"> <span
							class="glyphicon glyphicon-user"></span> Xin chào, <%=userLog.getFullName() %>
					</a></li>
					<li><a
						href="LogoutController"> <span
							class="glyphicon glyphicon-log-out"></span> Logout
					</a></li>
					<%} %>
				</ul>
			</div>
		</nav>
	</section>

</body>
</html>