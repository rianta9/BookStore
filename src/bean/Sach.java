package bean;

public class Sach {
	private String maSach;
	private String tenSach;
	private TacGia tacGia;
	private long gia;
	private String anh;
	private LoaiSach loaiSach;

	public String getMasach() {
		return maSach;
	}
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sach(String masach, String tensach, TacGia tacGia, long gia, String anh, LoaiSach loaiSach) {
		super();
		this.maSach = masach;
		this.tenSach = tensach;
		this.tacGia = tacGia;
		this.gia = gia;
		this.anh = anh;
		this.loaiSach = loaiSach;
	}
	
	
	public void setMasach(String masach) {
		this.maSach = masach;
	}
	public String getTensach() {
		return tenSach;
	}
	public void setTensach(String tensach) {
		this.tenSach = tensach;
	}
	
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	public LoaiSach getLoaiSach() {
		return loaiSach;
	}
	public void setLoaiSach(LoaiSach loaiSach) {
		this.loaiSach = loaiSach;
	}
}