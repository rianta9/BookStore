package bo;

import java.util.ArrayList;

import bean.Order;
import dao.OrderDAO;

public class OrderBO {
	private OrderDAO dao;
	
	public OrderBO() {
		dao = new OrderDAO();
	}
	
	public Order timKiemTheoOrderID(String orderID){
		return dao.timKiemTheoOrderID(orderID);
	}
	
	public ArrayList<Order> timKiemTheoUserID(long userID){
		return dao.timKiemTheoUserID(userID);
	}
	
	public boolean them(Order order) {
		return dao.them(order);
	}
	
	public boolean xoa(String orderID) {
		return dao.xoa(orderID);
	}
	
	public boolean sua(Order order) {
		return dao.sua(order);
	}
	
	public boolean match(long userID, String orderID) {
		return dao.match(userID, orderID);
	}
}
