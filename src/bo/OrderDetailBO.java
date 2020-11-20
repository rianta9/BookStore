package bo;

import java.util.ArrayList;

import bean.OrderDetail;
import dao.OrderDetailDAO;

public class OrderDetailBO {
	OrderDetailDAO dao;
	
	public OrderDetailBO() {
		dao = new OrderDetailDAO();
	}
	
	public ArrayList<OrderDetail> timkiemTheoOrderID(String orderID){
		return dao.timkiemTheoOrderID(orderID);
	}
	
	public boolean them(OrderDetail order) {
		return dao.them(order);
	}
}
