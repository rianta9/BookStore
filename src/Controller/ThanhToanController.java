package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.GioHang;
import bean.MaGiamGia;
import bean.MonHang;
import bean.Order;
import bean.OrderDetail;
import bean.User;
import bo.OrderBO;
import bo.OrderDetailBO;
import bo.SachBO;
import util.RandomUUID;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet("/ThanhToanController")
public class ThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		GioHang gioHang = (GioHang)session.getAttribute("Gio"); 
		
		// Nếu giỏ hàng = null || giỏ hàng rỗng thì ko thanh toán
		if(gioHang == null || gioHang.getList().isEmpty()){ 
			response.sendRedirect("SachController");
		}
		else {
			User user = (User)session.getAttribute("user");
			if(user == null) {
				response.sendRedirect("LoginController");
				return;
			}
			
			else {
				String orderID = RandomUUID.getRandomID();
				Order order = new Order(orderID, null, user, "Theo địa chỉ khách hàng", new MaGiamGia());
				//TODO: code phần mã giảm giá
				OrderBO orderBo = new OrderBO();
				orderBo.them(order); // thêm vào database
				
				
				OrderDetailBO orderDetailBo = new OrderDetailBO();
				ArrayList<MonHang> list = gioHang.getList();
				for (MonHang monHang : list) {
					orderDetailBo.them(new OrderDetail(RandomUUID.getRandomID(), orderID, null, monHang));
				}
				session.removeAttribute("Gio"); // Mua Hàng thành công thì xoá giỏ
				response.sendRedirect("LichSuMuaHangController");
			}
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
