
<%@page import="bean.GioHang"%>
<%@page import="bean.User"%>
<%@page import="bean.LoaiSach"%>
<%@page import="bean.Sach"%>
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
		<div class="container-fluid">

			<%
				ArrayList<Sach> listSach;
			listSach = (ArrayList<Sach>) request.getAttribute("listsach");
			int n = listSach.size();

			ArrayList<LoaiSach> listLoaiSach = (ArrayList<LoaiSach>) request.getAttribute("listloaisach");
			int m = listLoaiSach.size();
			%>

			<div class="row">

				<!-- Categories -->
				<div class="col-md-3">
					<form action="SachController">
						<ul class="list-group">
							<li class="list-group-item">Nhóm Sản Phẩm</li>

							<%
								for (int i = 0; i < m; i++) {
							%>
							<li class="list-group-item" name="tag"
								value="<%=listLoaiSach.get(i).getMaLoai()%>"><a
								href="SachController?tag=<%=listLoaiSach.get(i).getMaLoai()%>">
									<%=listLoaiSach.get(i).getTenLoai()%>
							</a></li>
							<%
								}
							%>
						</ul>
					</form>
				</div>


				<!-- Product List -->
				<div class="col-md-9">
					<div class="list-product">
						<%
							for (int i = 0; i < n; i++) {
							Sach sach = listSach.get(i);
						%>
						<div class="product-block">
							<div class="product-img">
								<a href="#"> <img class="product-image"
									src="<%=sach.getAnh()%>">
								</a>
							</div>
							<div class="product-detail">
								<div class="box-pro-detail">
									<h3 class="pro-name">
										<a href="ProductController?id=<%=sach.getMasach()%>"><%=sach.getTensach()%></a>
									</h3>
									<h5 class="pro-author"><%=sach.getTacgia()%></h5>
									<div class="box-pro-prices">
										<p class="pro-price ">
											<span><%=sach.getGia()%> đ</span>
										</p>
									</div>

								</div>
							</div>
							<div class="pro-clickbuy">
								<a href="DatHangController?mahang=<%=sach.getMasach()%>"
									class="button dark" name="datmua">Đặt mua</a>
							</div>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
		</div>
	</section>


	<section id="footer">
		<div class="container-fluid">
			<div class="footer-content br-3">
				<div class="email-form pd-10">
					<div>
						<span class="glyphicon glyphicon-envelope	
					"></span> Đăng Ký
						Nhận Bản Tin
					</div>
					<div>
						<form action="#">
							<input type="email" placeholder="Nhập địa chỉ email của bạn"
								name="email" size="50" class="pd-8 br-2"> <input
								type="submit" value="Đăng Ký" class="light pd-8 br-2">
						</form>
					</div>
				</div>
				<div class="policy">
					<div class="web-info">
						<h3>Dịch Vụ</h3>
						<ul>
							<li><a href="#">Điều khoản sử dụng</a></li>
							<li><a href="#">Chính sách bảo mật</a></li>
							<li><a href="#">Giới thiệu</a></li>
						</ul>
					</div>
					<div class="web-info">
						<h3>Hỗ Trợ</h3>
						<ul>
							<li><a href="#">Chính sách đổi - trả - hoàn tiền</a></li>
							<li><a href="#">Phương thức vận chuyển</a></li>
							<li><a href="#">Phương thức thanh toán và xuất HĐ</a></li>
						</ul>
					</div>
					<div class="web-info">
						<h3>Tài Khoản Của Tôi</h3>
						<ul>
							<li><a href="#">Đăng nhập/Tạo mới tài khoản</a></li>
							<li><a href="#">Thay đổi địa chỉ khách hàng</a></li>
							<li><a href="#">Lịch sử mua hàng</a></li>
						</ul>
					</div>

				</div>
				<div class="communication">
					<p><span class="glyphicon glyphicon-map-marker">	
					</span> Nguyễn Huệ, Huế, Việt Nam</p>
					<p><span class="glyphicon glyphicon-envelope">	
					</span> rianta9@gmail.com</p>
					<p><span class="glyphicon glyphicon-earphone">		
					</span> 03898xxxxx</p>
				</div>
			</div>
		</div>
	</section>

	<script>
		// Get the modal
		var modal = document.getElementById('formlogin');

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>