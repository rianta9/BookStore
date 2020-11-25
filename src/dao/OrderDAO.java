package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.MaGiamGia;
import bean.Order;
import bean.User;
import jdbc.ThietLap;

public class OrderDAO {	
	
	private ThietLap thietLap;
	
	public OrderDAO() {
		thietLap = new ThietLap();
		thietLap.connect();
	}
	
	/**
	 * Tìm kiếm một order theo mã
	 * @param orderID
	 * @return
	 */
	public Order timKiemTheoOrderID(String orderID){
		Order result = null;
		String sql = "select * from [View_Order] where OrderID = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setString(1, orderID);
			ResultSet rs = c.executeQuery();
			if(rs.next()) {
				Date dateCreated = rs.getDate("DateCreated");
				long userID = rs.getLong("UserID");
				String fullName = rs.getNString("FullName");
				String shipInfo = rs.getNString("ShipInfo");
				if(shipInfo != null) shipInfo = shipInfo.trim();
				String discountCode = rs.getString("DiscountCode");
				if(discountCode != null) discountCode = discountCode.trim();
				result = new Order(orderID, dateCreated, new User(userID, fullName), shipInfo, new MaGiamGia(discountCode));
			}
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Order> timKiemTheoUserID(long userID){
		ArrayList<Order> result = new ArrayList<Order>();
		String sql = "select * from [View_Order] where userID = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setLong(1, userID);
			ResultSet rs = c.executeQuery();
			while(rs.next()) {
				String orderID = rs.getString("OrderID");
				Date dateCreated = rs.getDate("DateCreated");
				String fullName = rs.getNString("FullName");
				String shipInfo = rs.getNString("ShipInfo").trim();
				String discountCode = rs.getString("DiscountCode");
				result.add(new Order(orderID, dateCreated, new User(userID, fullName), shipInfo, new MaGiamGia(discountCode)));
			}
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean them(Order order) {
		boolean result = false;
		try {
			String sql = "insert into [Order](UserID, ShipInfo, DiscountCode, OrderID) values (?, ?, ?, ?)";
			PreparedStatement c = thietLap.cn.prepareStatement(sql);
			c.setLong(1, order.getUser().getUserID()); 
			c.setNString(2, order.getShipInfo()); 
			c.setString(3, order.getDiscountCode().getCode()); 
			c.setString(4, order.getOrderID());
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			System.out.println("Loi khi them");
			e.printStackTrace();
		} 
		return result;
	}
	
	/**
	 * Tìm kiếm liên kết giữa table order với một hoặc nhiều table khác. Nếu có return true.
	 * @param orderID
	 * @return
	 */
	private boolean daLienKet(String orderID) {
		// Tìm kiếm liên kết với table OrderDetail
		String sql = "select * from [OrderDetails] where OrderID = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setString(1, orderID);
			ResultSet rs = c.executeQuery();
			return rs.next();
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
			return true; // return true để ko cho xoá
		}
		// Tìm kiếm liên kết với table ...
	}
	
	/**
	 * Xoá một dòng dữ liệu trong table Order
	 * @param orderID
	 * @return
	 */
	public boolean xoa(String orderID) {
		if(daLienKet(orderID)) return false; // kiểm tra mới liên kết
		boolean result = false;
		try {
			// Sai cho nay, dung ? ko dung
			String sql = "delete from [Order] where OrderID = ?";
			PreparedStatement c = thietLap.cn.prepareStatement(sql);
			c.setString(1, orderID);
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			System.out.println("Loi khi xoa");
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean sua(Order order) {
		boolean result = false;
		try {
			String sql = "UPDATE [Order] SET DateCreated = ? , UserID = ? , ShipInfo = ? , DiscountCode = ? WHERE OrderID = ?";
			PreparedStatement c = thietLap.cn.prepareStatement(sql);
			c.setDate(1, order.getDateCreated()); // hoten
			c.setLong(2, order.getUser().getUserID()); // ngaysinh
			c.setNString(3, order.getShipInfo()); //hsl
			c.setString(4, order.getDiscountCode().getCode()); // madv
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			System.out.println("Loi khi sua!");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Kiểm tra trùng khớp giữa orderID và userID
	 * @param userID
	 * @param orderID
	 * @return
	 */
	public boolean match(long userID, String orderID) {
		String sql = "select * from [Order] where OrderID = ? and userID = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setString(1, orderID);
			c.setLong(2, userID);
			ResultSet rs = c.executeQuery();
			return rs.next();
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
			return false; 
		}
	}
}
