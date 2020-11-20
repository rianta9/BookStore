package bo;

import bean.User;
import dao.UserDAO;

public class UserBO {
	private UserDAO dao;
	
	public UserBO() {
		dao = new UserDAO();
	}
	
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
	
	
	public User getLogin(String indentity, String password) {
		return dao.getLogin(indentity, password);
	}
	
	public boolean them(User user) {
		return dao.them(user);
	}
	
	public boolean xoa(long userID) {
		return dao.xoa(userID);
	}
	
	public boolean sua(User user) {
		return dao.sua(user);
	}
	
	public boolean changePassword(long userID, String password) {
		return dao.changePassword(userID, password);
	}
	
	public boolean isValidEmail(String email) {
		return dao.isValidEmail(email);
	}
	
	public boolean isAvailablePhone(String phone) {
		return dao.isAvailablePhone(phone);
	}
}
