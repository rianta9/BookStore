package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Order;
import bean.OrderDetail;
import bean.User;
import bo.OrderBO;
import bo.OrderDetailBO;

/**
 * Servlet implementation class ChiTietDonHang
 */
@WebServlet("/ChiTietDonHang")
public class ChiTietDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String orderID = request.getParameter("id");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
 		if(user == null) {
 			response.sendRedirect("LoginController");
 			return;
 		}
 		else {
			ArrayList<OrderDetail> list = null;
 			try {
 	 			OrderBO bo = new OrderBO();
 	 			if(bo.match(user.getUserID(), orderID)) { // kiểm tra order có phải là của user hiện tại không
 	 				OrderDetailBO dtBo = new OrderDetailBO();
 	 				list = dtBo.timkiemTheoOrderID(orderID);
 	 	 			request.setAttribute("order", bo.timKiemTheoOrderID(orderID));
 	 			}
 	 			request.setAttribute("listOrderDetail", list);

 	 			//TODO: Show thông báo order không khớp với user
			} catch (Exception e) {
				e.printStackTrace();
			}
 		}
		request.getRequestDispatcher("chitietdonhang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
