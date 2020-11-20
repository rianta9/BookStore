package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bean.GioHang;
import bean.MonHang;
import bean.Sach;
import bo.SachBO;

@WebServlet(urlPatterns = {"/DatHangController"})
public class DatHangController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		GioHang gioHang = (GioHang)session.getAttribute("Gio"); 
		String maHang = req.getParameter("mahang");
		int soLuong = 1;
		if(gioHang == null){
			gioHang = new GioHang();
		}
		
		SachBO sbo = new SachBO();
		sbo.getSach();
		Sach sach = sbo.find(maHang);
		PrintWriter printWriter = resp.getWriter();
		if(sach!=null){
			MonHang mh = new MonHang(sach.getMasach(), soLuong, sach.getGia());
			
			//thêm vào giỏ
			gioHang.add(mh);
			session.setAttribute("Gio", gioHang);
			printWriter.print(mh.getSoLuong());
		}
		else printWriter.print("Khong tim thay thong tin sach da dat!");
		resp.sendRedirect("SachController");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
