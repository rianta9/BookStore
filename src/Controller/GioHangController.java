package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHang;
import bo.SachBO;

@WebServlet(urlPatterns = {"/GioHangController"})
public class GioHangController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		GioHang gioHang = (GioHang)session.getAttribute("Gio"); 
		if(gioHang == null){
			gioHang = new GioHang();
		}
		
		
		SachBO sbo = new SachBO();
		sbo.getSach();
		session.setAttribute("Gio", gioHang);
		req.setAttribute("GioHang", gioHang);
		req.setAttribute("sbo", sbo);
		
		RequestDispatcher rd = req.getRequestDispatcher("giohang.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
