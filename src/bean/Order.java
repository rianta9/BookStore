package bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//Giỏ hàng sau khi được khách hàng xác nhận mua sẽ được ghi thông tin thành một order
public class Order {
	private String orderID;
	private Date dateCreated;
	private User user;
	private String shipInfo;
	private MaGiamGia discountCode;
	
	public Order(String orderID, Date dateCreated, User user, String shipInfo,
			MaGiamGia discountCode) {
		super();
		this.orderID = orderID;
		this.dateCreated = dateCreated;
		this.user = user;
		this.shipInfo = shipInfo;
		this.discountCode = discountCode;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getShipInfo() {
		return shipInfo;
	}

	public void setShipInfo(String shipInfo) {
		this.shipInfo = shipInfo;
	}

	public MaGiamGia getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(MaGiamGia discountCode) {
		this.discountCode = discountCode;
	}
	
	public java.util.Date getDateCreatedUtil() {
		return new java.util.Date(this.getDateCreated().getTime());
	}
	
}
