<%@page import="bean.User"%>
<%@page import="bean.GioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- SECTION NAVBAR -->
	<section id="navbar">
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="SachController"><img
						src="https://cdn0.fahasa.com/skin/frontend/ma_vanese/fahasa/images/fahasa-logo.png"
						width="120px" height="20px"></a>
				</div>
				<%
					GioHang gioHang = (GioHang) session.getAttribute("Gio");
				int soLuong = 0;
				if (gioHang != null)
					soLuong = gioHang.getList().size();
				%>
				<ul class="nav navbar-nav">
					<li><a href="GioHangController">Giỏ Hàng<%
						if (soLuong != 0) {
					%> (<%=soLuong%>) <%
						}
					%></a></li>
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
						User userLog = (User) session.getAttribute("user");
					if (userLog == null) {
					%>

					<li><a href="SignUpController"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="LoginController"> <span
							class="glyphicon glyphicon-log-in"></span> Login
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
			</div>
		</nav>
	</section>