package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.MonHang;
import bean.Order;
import bean.OrderDetail;
import bo.Tool;
import jdbc.ThietLap;

public class OrderDetailDAO {
	
	private ThietLap thietLap;
	
	public OrderDetailDAO() {
		thietLap = new ThietLap();
		thietLap.connect();
	}
	/**
	 * Tìm kiếm một order theo mã
	 * @param orderID
	 * @return
	 */
	public ArrayList<OrderDetail> timkiemTheoOrderID(long orderID){
		ArrayList<OrderDetail> result = new ArrayList<OrderDetail>();
		String sql = "select * from OrderDetail where OrderID = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setLong(1, orderID);
			ResultSet rs = c.executeQuery();
			if(rs.next()) {
				long orderDetailID = rs.getLong("OrderDetailID");
				Date ngayNhan = rs.getDate("NgayNhan");
				String maHang = rs.getString("MaSach").trim();
				int soLuong = rs.getInt("SoLuong");
				double donGia = Tool.toDouble(rs.getBigDecimal("donGia"));
				result.add(new OrderDetail(orderDetailID, orderID, ngayNhan, new MonHang(maHang, soLuong, donGia)));
			}
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
		}
		return result;
	}
	
//	public ArrayList<Order> timKiemTheoUserID(int userID){
//		ArrayList<Order> result = null;
//		String sql = "select * from Order where NickName = ?";
//		PreparedStatement c;
//		try {
//			c = thietLap.cn.prepareStatement(sql);
//			c.setInt(1, userID);
//			ResultSet rs = c.executeQuery();
//			while(rs.next()) {
//				int orderID = rs.getInt("OrderID");
//				Date dateCreated = rs.getDate("DateCreated");
//				String nickname = rs.getString("Nickname").trim();
//				Date deliveryDate = rs.getDate("DeliveryDate");
//				String shipInfo = rs.getNString("ShipInfo").trim();
//				String discountCode = rs.getString("DiscountCode").trim();
//				result.add(new Order(orderID, dateCreated, nickname, ngayNhan, shipInfo, discountCode));
//			}
//		} catch (Exception e) {
//			System.out.println("Loi tim ma!");
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	public boolean them(Order order) {
//		boolean result = false;
//		try {
//			String sql = "insert into Order(DateCreated, Nickname, DeliveryDate, ShipInfo, DiscountCode) values (?, ?, ?, ?, ?)";
//			PreparedStatement c = thietLap.cn.prepareStatement(sql);
//			c.setDate(1, order.getDateCreated());//manv
//			c.setString(2, order.getNickname()); // hoten
//			c.setDate(3, order.getDeliveryDate()); // ngaysinh
//			c.setNString(4, order.getShipInfo()); //true = nam , false = nu
//			c.setString(5, order.getDiscountCode()); // madv
//			if(c.executeUpdate() == 1) result = true;
//		} catch (Exception e) {
//			System.out.println("Loi khi them");
//			e.printStackTrace();
//		} 
//		return result;
//	}
//	
//	/**
//	 * Tìm kiếm liên kết giữa table order với một hoặc nhiều table khác. Nếu có return true.
//	 * @param orderID
//	 * @return
//	 */
//	public boolean daLienKet(int orderID) {
//		// Tìm kiếm liên kết với table OrderDetail
//		String sql = "select * from OrderDetail where OrderID = ?";
//		PreparedStatement c;
//		try {
//			c = thietLap.cn.prepareStatement(sql);
//			c.setInt(1, orderID);
//			ResultSet rs = c.executeQuery();
//			return rs.next();
//		} catch (Exception e) {
//			System.out.println("Loi tim ma!");
//			e.printStackTrace();
//			return true; // return true để ko cho xoá
//		}
//		// Tìm kiếm liên kết với table ...
//	}
//	
//	/**
//	 * Xoá một dòng dữ liệu trong table Order
//	 * @param orderID
//	 * @return
//	 */
//	public boolean xoa(int orderID) {
//		if(daLienKet(orderID)) return false; // kiểm tra mới liên kết
//		boolean result = false;
//		try {
//			// Sai cho nay, dung ? ko dung
//			String sql = "delete from Order where OrderID = ?";
//			PreparedStatement c = thietLap.cn.prepareStatement(sql);
//			c.setInt(1, orderID);
//			if(c.executeUpdate() == 1) result = true;
//		} catch (Exception e) {
//			System.out.println("Loi khi xoa");
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	public boolean sua(Order order) {
//		boolean result = false;
//		try {
//			String sql = "UPDATE Order SET DateCreated = ? , Nickname = ? , DeliveryDate = ? , ShipInfo = ? , DiscountCode = ? WHERE OrderID = ?";
//			PreparedStatement c = thietLap.cn.prepareStatement(sql);
//			c.setDate(1, order.getDateCreated()); // hoten
//			c.setString(2, order.getNickname()); // ngaysinh
//			c.setDate(3, order.getDeliveryDate()); //true = nam , false = nu
//			c.setNString(4, order.getShipInfo()); //hsl
//			c.setString(5, order.getDiscountCode()); // madv
//			if(c.executeUpdate() == 1) result = true;
//		} catch (Exception e) {
//			System.out.println("Loi khi sua!");
//			e.printStackTrace();
//		}
//		return result;
//	}
}
