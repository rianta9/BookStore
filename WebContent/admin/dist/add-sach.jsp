<%@page import="bean.LoaiSach"%>
<%@page import="bean.Sach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Sách - SB Admin</title>
<link href="${url}/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<!-- NAVBAR -->
	<jsp:include page="/admin/dist/navbar.jsp"></jsp:include>
	<!-- END NAVBAR -->


	<div id="layoutSidenav">

		<!-- SIDE BAR -->

		<jsp:include page="/admin/dist/sidebar.jsp"></jsp:include>

		<!-- END SIDE BAR -->

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<!------------------------------------ CONTENT ------------------------------------>
					<br>
					<div class="card mb-4">
						<div class="card-header">
							<h2>Thêm Sách</h2>
						</div>
						<div class="card-body">
							<%
								ArrayList<LoaiSach> listLoaiSach = (ArrayList<LoaiSach>) request.getAttribute("listloaisach");
							%>
							<form action="add-sach" method="post">
								<label for="tensach">Tên Sách</label> <br> <input
									type="text" name="tensach" id="tensach" style="width: 100%"> <br><br> <label
									for="giaban">Giá Bán</label> <br> <input type="number"
									name="giaban" id="giaban" style="width: 100%"> <br><br> <label
									for="loaisach">Loại Sách</label> <br> <select
									id="loaisach" name="maloaisach">
									<%
										for (LoaiSach i : listLoaiSach) {
									%>
									<option value="<%=i.getMaLoai()%>"><%=i.getTenLoai()%></option>
									<%
										}
									%>
								</select> <br><br> <label for="tacgia">Tác Giả</label> <br> <input
									type="text" name="tacgia" id="tacgia" style="width: 100%"> <br><br> <label
									for="biasach">Bìa Sách</label> <br> <input type="file"
									name="biasach" id="biasach"> <br><br> <label
									for="description">Mô Tả</label> <br>
								<textarea name="description" id="description" style="width: 100%; min-height: 500px"></textarea>

								<br> <br> <input type="submit" value="Thêm" class="btn btn-success">
							</form>

						</div>
					</div>






					<!---------------------------------- END CONTENT ---------------------------------->
				</div>
			</main>
			<!-- FOOTER -->

			<jsp:include page="/admin/dist/footer.jsp"></jsp:include>

			<!-- END FOOTER -->
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="${url}/js/scripts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="${url}/assets/demo/datatables-demo.js"></script>
</body>
</html>
