package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHang;
import bean.MonHang;

/**
 * Servlet implementation class UpdateItemCart
 */
@WebServlet("/UpdateItemCart")
public class UpdateItemCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItemCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String maHang = request.getParameter("id");
		try {
			int soLuong = Integer.parseInt(request.getParameter("quantity"));
			
			HttpSession session = request.getSession();
			GioHang gioHang = (GioHang)session.getAttribute("Gio"); 
			
			if(gioHang != null && maHang != null) {
				MonHang monHang = gioHang.find(maHang);
				if(monHang != null && soLuong >= 1) monHang.setSoLuong(soLuong);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("GioHangController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
