<%@page import="bean.User"%>
<%@page import="bean.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/product.css">
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
					<li><a href="ThanhToanController">Thanh Toán</a></li>
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
							class="glyphicon glyphicon-user"></span> Xin chào, <%=userLog.getName() %>
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


	<!-- Lịch sử mua hàng -->
	<section class="view">
		<%
		ArrayList<Order> list = (ArrayList<Order>)request.getAttribute("list-order");
		if(!list.isEmpty()){
		%>
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="payment-cart rounder-4">
						<ul class="list-group">
							<%
								for (Order order : list) {
							%>
							<li class="list-group-item rounder-4">
								<div>
									<p>
										Mã đơn hàng:
										<%=order.getOrderID()%></p>
									<p>
										Ngày Tạo:
										<%=order.getDateCreated()%></p>
									
									
									<p><a href="chitietorder.jsp?id=<%=order.getOrderID()%>"
										class="btn btn-danger buy" name="xoa">Chi tiết</a></p>
								</div>
							</li>


							<%
								}
							%>
						</ul>
					</div>
				</div>
				<div class="col-md-4">
					
				</div>
				<%
					} else {
				%>
				<p align="center">Bạn không có hoá đơn nào!</p>
				<%
					}
				%>
			</div>
		</div>
		</div>
	</section>
</body>
</html>