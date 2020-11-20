package bean;

public class MonHang {
	private String maHang;
	private int soLuong;
	private double donGia;
	public MonHang(String maHang, int soLuong, double donGia) {
		super();
		this.maHang = maHang;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public void increase(int n){
		if(n > 0) this.soLuong += n;
	}
}
