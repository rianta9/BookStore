package bean;

public class TacGia {
	private String maTacGia;
	private String tenTacGia;
	private String info;
	private String hinhAnh;
	
	
	
	public TacGia(String maTacGia, String tenTacGia, String info, String hinhAnh) {
		super();
		this.maTacGia = maTacGia;
		this.tenTacGia = tenTacGia;
		this.info = info;
		this.hinhAnh = hinhAnh;
	}
	public TacGia(String maTacGia) {
		this.maTacGia = maTacGia;
		this.tenTacGia = null;
		this.info = null;
		this.hinhAnh = null;
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	
}
