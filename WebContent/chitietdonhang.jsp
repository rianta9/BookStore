<%@page import="bean.Order"%>
<%@page import="bean.GioHang"%>
<%@page import="bean.User"%>
<%@page import="bean.Sach"%>
<%@page import="bo.SachBO"%>
<%@page import="bean.MonHang"%>
<%@page import="bean.OrderDetail"%>
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


	<!-- SECTION VIEW -->
	<section id="view">


		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="payment-cart rounder-4">
						<%
						Order order = (Order)request.getAttribute("order");
						ArrayList<OrderDetail> list = (ArrayList<OrderDetail>) request.getAttribute("listOrderDetail");
						if (list != null) {
						%>
						<h3 align="center">Thông Tin Chi Tiết</h3>
						<div>
							<h4>Mã order: <%=order.getOrderID()%></h4>
							<h4>Địa chỉ giao hàng: <%=order.getShipInfo()%></h4>
							<h4>Mã giảm giá: <% if(order.getDiscountCode() != null){%> <%=order.getDiscountCode() %> <%}else {%> Không có <%}%></h4>
							<h4>Thành tiền: </h4> //TODO: tính tổng tiền order
						</div>
						<ul class="list-group">
							<%
								for (OrderDetail orderDetail : list) {
							%>
							<li class="list-group-item rounder-4">
								<div class="cart-item">
									<div class="item-remove">
										<p></p>
									</div>
									<%
									MonHang monHang = orderDetail.getMonHang();
									SachBO sbo = new SachBO();
									sbo.getSach();
									sbo.find(monHang.getMaHang());
									Sach sach = sbo.find(monHang.getMaHang());
									%>
									<div class="item-content">
										<h4><%=sach.getTensach()%></h4>
										<p>
											Số lượng:
											<%=monHang.getMaHang()%></p>


										<p>
											Đơn giá:<%=monHang.getDonGia()%>
											đ
										</p>

									</div>

									<div class="item-image">
										<img class="cart-item-img" alt="<%=sach.getTensach()%>"
											src="<%=sach.getAnh()%>">

									</div>
								</div>
							</li>


							<%
								}
							%>
						</ul>
					</div>
				</div>

				<%
					} else {
				%>
				<p align="center">Bạn không có sản phẩm nào trong giỏ!</p>
				<p align="center">
					Hãy tiếp tục <a class="button dark br-5" href="SachController">Mua
						Hàng</a>
				</p>
				<%
					}
				%>
			</div>
		</div>
	</section>
</body>
</html>