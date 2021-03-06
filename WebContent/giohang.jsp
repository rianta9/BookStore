<%@page import="bean.User"%>
<%@page import="bean.GioHang"%>
<%@page import="bean.Sach"%>
<%@page import="bo.SachBO"%>
<%@page import="bean.MonHang"%>
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

	<!-- List giỏ hàng -->
	<section id="view">
		<%
		GioHang gioHang = (GioHang)session.getAttribute("Gio");
		if (gioHang != null && !gioHang.getList().isEmpty()) {
			ArrayList<MonHang> list = gioHang.getList(); // lấy danh sách trong giỏ hàng

			SachBO sbo = (SachBO) request.getAttribute("sbo");
		%>
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="payment-cart rounder-4">
					<h3 align="center">Giỏ Hàng</h3>
						<ul class="list-group">
							<%
								for (MonHang monHang : list) {
								Sach sach = sbo.find(monHang.getMaHang());
							%>
							<li class="list-group-item rounder-4">
								<div class="cart-item">
								<div class="item-remove">
									<a href="RemoveItemCart?id=<%=monHang.getMaHang()%>" name="xoa" title="Xoá Sản Phẩm"><span class="glyphicon glyphicon-remove-circle	
									"></span></a>
								</div>
									<div class = "item-content">
										<h4><%=sach.getTensach()%></h4>
										<p>
											Tác giả:
											<%=sach.getTacGia().getTenTacGia()%></p>
										<p>
										<form method="post"
											action="UpdateItemCart?id=<%=monHang.getMaHang()%>">
											Số lượng: 
											<input type="number" id="quantity" value="<%=monHang.getSoLuong()%>" name="quantity" min="1" max="1000">
  											<input type="submit" name = "update" value = "Lưu" class = "dark-btn br-2">
										</form>

										</p>
										<p>
											Đơn giá:
											<%=monHang.getDonGia()%> đ</p>
										
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
				<div class="col-md-4">
					<div class="payment rounder-4">
						<h3 align="center"
							style="padding: 8px; margin: 0; border-bottom: 1px solid #DCDCDC;">Thanh
							Toán</h3>
						<h4 style="padding: 20px 40px">
							Tổng Tiền: <span style="float: right"><%=gioHang.tongTien()%>
								đ</span>
						</h4>
						<form action="ThanhToanController" method="post">
							<input type="submit" name="thanhtoan" value="Thanh Toán"
								class="button dark br-10"
								style="display: block; margin: 0 auto; padding: 10px 100px; border-radius: 25px">
						</form>
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
	
	
	<!-- SECTION FOOTER -->

	<jsp:include page="footer.jsp"></jsp:include>
	<!--END SECTION FOOTER -->
	
	<script type="text/javascript">
		$("input.product-quantity").on("keypress keyup blur",function (e) {    
		    $(this).val($(this).val().replace(/^[a-zA-Z]+$/, ""));
		        if ((e.which < 48 || e.which > 57)) {
		            e.preventDefault();
		    }
		});
	</script>
</body>
</html>