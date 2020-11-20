package bean;

import java.sql.Date;
import java.util.ArrayList;

public class OrderDetail {
	String orderDetailID;
	String orderID;
	Date ngayNhan;
	MonHang monHang;
	
	public OrderDetail(String orderDetailID, String orderID, Date ngayNhan, MonHang monHang) {
		super();
		this.orderDetailID = orderDetailID;
		this.orderID = orderID;
		this.ngayNhan = ngayNhan;
		this.monHang = monHang;
	}
	public String getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public MonHang getMonHang() {
		return monHang;
	}
	public void setMonHang(MonHang monHang) {
		this.monHang = monHang;
	}
	public Date getNgayNhan() {
		return ngayNhan;
	}
	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}
	
	
}
