package bo;

import bean.User;
import dao.UserDAO;

public class UserBO {
	private UserDAO dao;
	
	public UserBO() {
		dao = new UserDAO();
	}
	
	/**
	 * Tìmm kiếm user theo ID
	 * @param userID
	 * @return
	 */
	public User timKiem(long userID){
		return dao.timKiem(userID);
	}
	
	/**
	 * Kiểm tra có tài khoản này trong database hay không
	 * @param indentity
	 * @param password
	 * @return -1: Ko có account trong database.<br> 0: có account nhưng ko đúng pass.<br> 1: đúng indentity đúng pass
	 */
	public int checkLogin(String indentity, String password) {
		return dao.checkLogin(indentity, password);
	}
	
	
	/**
	 * Lấy thông tin của 1 user
	 * @param indentity
	 * @param password
	 * @return
	 */
	public User getLogin(String indentity, String password) {
		return dao.getLogin(indentity, password);
	}
	
	/**
	 * Thêm 1 user vào database
	 * @param user
	 * @return
	 */
	public boolean them(User user) {
		return dao.them(user);
	}
	
	/**
	 * Xoá 1 user khỏi database
	 * @param userID
	 * @return
	 */
	public boolean xoa(long userID) {
		return dao.xoa(userID);
	}
	
	/**
	 * Chỉnh sửa thông tin của 1 user trong database
	 * @param user
	 * @return
	 */
	public boolean sua(User user) {
		return dao.sua(user);
	}
	
	/**
	 * Thay đổi password của user
	 * @param userID
	 * @param password
	 * @return
	 */
	public boolean changePassword(long userID, String password) {
		return dao.changePassword(userID, password);
	}
	
	/**
	 * Kiểm tra email đã tồn tại trong database hay chưa
	 * @param email
	 * @return
	 */
	public boolean isValidEmail(String email) {
		return dao.isValidEmail(email);
	}
	
	/**
	 * Kiểm tra số điện thoại đã tồn tại trong database hay chưa
	 * @param phone
	 * @return
	 */
	public boolean isAvailablePhone(String phone) {
		return dao.isAvailablePhone(phone);
	}
}
