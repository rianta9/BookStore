package bean;

import java.sql.Date;

import tools.Tool;

public class User {
	private long userID;
	private String password;
	private String fullName;
	private Date birthdate;
	private Date dateCreated;
	private String maPhanQuyen;
	private String phone;
	private String email;
	private String address;
	private int status;
	
	
	public User(long userID, String password, String fullName, Date birthdate, Date dateCreated, 
			String maPhanQuyen, String phone, String email, String address, int status) {
		super();
		this.userID = userID;
		this.password = password;
		this.fullName = fullName;
		this.birthdate = birthdate;
		this.maPhanQuyen = maPhanQuyen;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.status = status;
	}
	
	/**
	 * Thông tin đăng ký cần thiết
	 * @param fullName
	 * @param password
	 * @param email
	 * @param phone
	 */
	public User(String fullName, String password, String email, String phone) {
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	/**
	 * Thông tin session cần thiết
	 * @param nickname
	 * @param password
	 */
	public User(long userID, String fullName) {
		this.userID = userID;
		this.fullName = fullName;
	}
	
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/**
	 * Trả về tên gọi ngắn gọn
	 * @return
	 */
	public String getName() {
		String[] list = this.fullName.split("[ ]");
		if(list.length != 0) return list[list.length-1];
		return "#" + this.userID;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getMaPhanQuyen() {
		return maPhanQuyen;
	}
	public void setMaPhanQuyen(String maPhanQuyen) {
		this.maPhanQuyen = maPhanQuyen;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
