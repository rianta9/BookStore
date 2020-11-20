package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Order;
import bean.User;
import bo.Tool;
import jdbc.ThietLap;

public class UserDAO {
	private ThietLap thietLap;
	
	public UserDAO() {
		thietLap = new ThietLap();
		thietLap.connect();
	}
	
	/**
	 * Tìm kiếm 1 user bằng nickname
	 * @param username
	 * @return
	 */
	public User timKiem(long id){
		User result = null;
		String sql = "select * from User where userID = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setLong(1, id);
			ResultSet rs = c.executeQuery();
			if(rs.next()) {
				long userID = rs.getLong("userID");
				String password = rs.getString("password").trim();
				String fullName = rs.getNString("FullName").trim();
				Date birthdate = rs.getDate("Birthday");
				Date dateCreated = rs.getDate("DateCreated");
				String maPhanQuyen = rs.getString("MaPhanQuyen").trim();
				String phone = rs.getString("Phone").trim();
				String email = rs.getString("Email").trim();
				String address = rs.getNString("Address").trim();
				int status = rs.getInt("Status");
				result = new User(userID, password, fullName, birthdate, dateCreated, maPhanQuyen, phone, email, address, status);
			}
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Kiểm tra có tài khoản này trong database hay không
	 * @param indentity : phone hoặc email
	 * @param password
	 * @return -1: Ko có account trong database.<br> 0: có account nhưng ko đúng pass.<br> 1: đúng indentity đúng pass
	 */
	public int checkLogin(String indentity, String password) {
		int result = -1; // ko có account này trong database
		String sql = "";
		if(Tool.isEmail(indentity)) sql = "Select * from [User] where Email = ?";
		else sql = "Select * from [User] where Phone = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setString(1, indentity);
			ResultSet rs = c.executeQuery();
			if(rs.next()) {
				result = 0; // có account này
				if(rs.getString("password").trim().equals(password)) result = 1; // đúng pass
			}
			
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Lấy thông tin để vào session
	 * @param indentity
	 * @param password
	 * @return
	 */
	public User getLogin(String indentity, String password) {
		User result = null;
		String sql = "";
		if(Tool.isEmail(indentity)) sql = "Select * from [User] where Email = ? and Password = ?";
		else sql = "Select * from [User] where Phone = ? and Password = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setString(1, indentity);
			c.setString(2, password);
			ResultSet rs = c.executeQuery();
			if(rs.next()) {
				long userID = rs.getLong("UserID");
				String fullName = rs.getNString("fullName");
				result = new User(userID, fullName);
			}
			
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Thêm một user vào csdl
	 * @param user
	 * @return
	 */
	public boolean them(User user) {
		boolean result = false;
		try {
			String sql = "insert into [User](Password, FullName, Phone, Email) values (?, ?, ?, ?)";
			PreparedStatement c = thietLap.cn.prepareStatement(sql);
			c.setString(1, user.getPassword());
			c.setNString(2, user.getFullName());
			c.setString(3, user.getPhone());
			c.setString(4, user.getEmail());
			
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			System.out.println("Loi khi them");
			e.printStackTrace();
		} 
		return result;
	}
	
	/**
	 * Tìm kiếm liên kết giữa table user với một hoặc nhiều table khác. Nếu có return true.
	 * @param orderID
	 * @return
	 */
	private boolean daLienKet(long userID) {
		// Tìm kiếm liên kết với table OrderDetail
		String sql = "select * from Order where userID = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setLong(1, userID);
			ResultSet rs = c.executeQuery();
			//TODO: Kiểm tra những table còn lại có liên quan đến table User
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
	public boolean xoa(long userID) {
		if(daLienKet(userID)) return false; // kiểm tra mới liên kết
		boolean result = false;
		try {
			// Sai cho nay, dung ? ko dung
			String sql = "delete from [User] where userID = ?";
			PreparedStatement c = thietLap.cn.prepareStatement(sql);
			c.setLong(1, userID);
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			System.out.println("Loi khi xoa");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean sua(User user) {
		boolean result = false;
		try {
			String sql = "UPDATE [User] SET Password = ?, FullName = ?, Birthday = ?, MaPhanQuyen = ?, Phone = ?, Email = ?, Address = ?, Status = ? WHERE UserID = ?";
			PreparedStatement c = thietLap.cn.prepareStatement(sql);
			c.setString(1, user.getPassword());
			c.setNString(2, user.getFullName());
			c.setDate(3, user.getBirthdate());
			c.setString(4, user.getMaPhanQuyen());
			c.setString(5, user.getPhone());
			c.setString(6, user.getEmail());
			c.setNString(7, user.getAddress());
			c.setInt(8, user.getStatus());
			c.setLong(9, user.getUserID());
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			System.out.println("Loi khi sua!");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Cập nhật password
	 * @param nickname
	 * @param password
	 * @return
	 */
	public boolean changePassword(long userID, String password) {
		boolean result = false;
		try {
			String sql = "UPDATE [User] SET password = ? WHERE userID = ?";
			PreparedStatement c = thietLap.cn.prepareStatement(sql);
			c.setString(1, password);
			c.setLong(2, userID);
			
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			System.out.println("Loi khi sua!");
			e.printStackTrace();
		}
		return result;
	}
}
