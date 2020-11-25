package bean;

public class LoaiSach {
	private String maLoai;
	private String tenLoai;
	
	public LoaiSach(String maLoai) {
		this.maLoai = maLoai;
	}
	
	public LoaiSach(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
	
	
}
