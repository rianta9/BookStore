<%@page import="bean.Sach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Sách - SB Admin</title>
        <link href="${url}/css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
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
                        <h1 class="mt-4">Tables</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                            <li class="breadcrumb-item active">Tables</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the
                                <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                                .
                            </div>
                        </div>
                        <div class="card mb-4">
                        <% 
                        	ArrayList<Sach> list = (ArrayList<Sach>)request.getAttribute("listsach");
                        	
                        %>
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                DataTable Example
                            <h2>Có <%=list.size()%> sách!</h2>
                                <a href="add-sach" class="btn btn-success">Thêm Sách</a>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Tên Sách</th>
                                                <th>Giá Bán</th>
                                                <th>Tác Giả</th>
                                                <th>Mã Loại</th>
                                                <th>Tác Vụ</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>ID</th>
                                                <th>Tên Sách</th>
                                                <th>Giá Bán</th>
                                                <th>Tác Giả</th>
                                                <th>Mã Loại</th>
                                                <th>Tác Vụ</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                        <%
                                        	for(Sach sach:list){    
                                        %>
                                            <tr>
                                                <td><%=sach.getMasach()%></td>
                                                <td><%=sach.getTensach()%></td>
                                                <td><%=sach.getGia()%></td>
                                                <td><%=sach.getTacGia().getTenTacGia()%></td>
                                                <td><%=sach.getLoaiSach().getTenLoai()%></td>
                                                <td>
	                                                <a href="UpdateSachController?id=<%=sach.getMasach()%>" class="btn btn-success">Sửa</a>
	                                                <a href="QuanLySach?id=<%=sach.getMasach()%>&action=delete" class="btn btn-danger">Xoá</a>
                                                </td>
                                            </tr>
                                        <%} %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <!-- FOOTER -->
                
                <jsp:include page="/admin/dist/footer.jsp"></jsp:include>
                
                <!-- END FOOTER -->
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${url}/js/scripts.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="${url}/assets/demo/datatables-demo.js"></script>
    </body>
</html>
