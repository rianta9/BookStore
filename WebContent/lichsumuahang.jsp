<%@page import="bean.GioHang"%>
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

	<jsp:include page="navbar.jsp"></jsp:include>
	<!--END SECTION NAVBAR -->


	<!-- Lịch sử mua hàng -->
	<section id="view">
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
										<%=order.getDateCreatedUtil()%></p>
									
									
									<p><a href="ChiTietDonHang?id=<%=order.getOrderID()%>"
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
	
	<!-- SECTION FOOTER -->

	<jsp:include page="footer.jsp"></jsp:include>
	<!--END SECTION FOOTER -->
</body>
</html>