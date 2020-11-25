package bean;

import java.sql.Date;

public class MaGiamGia {
	private String code;
	private String Name;
	private Date ngayBatDau;
	private Date ngayHetHan;
	private double phanTram;
	private double giamToiDa;
	private double donGiaToiThieu;
	private double thongTin;
	public MaGiamGia(String code, String name, Date ngayBatDau, Date ngayHetHan, double phanTram, double giamToiDa,
			double donGiaToiThieu, double thongTin) {
		super();
		this.code = code;
		Name = name;
		this.ngayBatDau = ngayBatDau;
		this.ngayHetHan = ngayHetHan;
		this.phanTram = phanTram;
		this.giamToiDa = giamToiDa;
		this.donGiaToiThieu = donGiaToiThieu;
		this.thongTin = thongTin;
	}
	public MaGiamGia(String code) {
		super();
		this.code = code;
	}
	public MaGiamGia() {
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayHetHan() {
		return ngayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}
	public double getPhanTram() {
		return phanTram;
	}
	public void setPhanTram(double phanTram) {
		this.phanTram = phanTram;
	}
	public double getGiamToiDa() {
		return giamToiDa;
	}
	public void setGiamToiDa(double giamToiDa) {
		this.giamToiDa = giamToiDa;
	}
	public double getDonGiaToiThieu() {
		return donGiaToiThieu;
	}
	public void setDonGiaToiThieu(double donGiaToiThieu) {
		this.donGiaToiThieu = donGiaToiThieu;
	}
	public double getThongTin() {
		return thongTin;
	}
	public void setThongTin(double thongTin) {
		this.thongTin = thongTin;
	}
	
	
}
