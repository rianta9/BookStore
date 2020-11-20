package bean;

import java.sql.Date;
import java.util.ArrayList;

public class OrderDetail {
	long orderDetailID;
	long orderID;
	Date ngayNhan;
	MonHang monHang;
	
	public OrderDetail(long orderDetailID, long orderID, Date ngayNhan, MonHang monHang) {
		super();
		this.orderDetailID = orderDetailID;
		this.orderID = orderID;
		this.ngayNhan = ngayNhan;
		this.monHang = monHang;
	}
	public long getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(long orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
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
