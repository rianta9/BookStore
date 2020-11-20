package bean;

import java.sql.Date;

//Giỏ hàng sau khi được khách hàng xác nhận mua sẽ được ghi thông tin thành một order
public class Order {
	private long orderID;
	private Date dateCreated;
	private long userID;
	private String shipInfo;
	private String discountCode;
	
	public Order(long orderID, Date dateCreated, long userID, String shipInfo,
			String discountCode) {
		super();
		this.orderID = orderID;
		this.dateCreated = dateCreated;
		this.userID = userID;
		this.shipInfo = shipInfo;
		this.discountCode = discountCode;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getShipInfo() {
		return shipInfo;
	}

	public void setShipInfo(String shipInfo) {
		this.shipInfo = shipInfo;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	
	
	
}
