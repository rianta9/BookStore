package dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.LoaiSach;
import bean.Sach;
import bean.TacGia;
import jdbc.ThietLap;

public class SachDAO {
	private ArrayList<Sach> list;
	private ThietLap thietLap;
	
	public SachDAO() {
		list = new ArrayList<Sach>();
		thietLap = new ThietLap();
		thietLap.connect();
	}
	
	private Long toLong(BigDecimal a) {
		double n = Double.valueOf(a.toString());
		return (long)n;
	}
	
	
	private boolean daLienKet(int ID) {
		// Tìm kiếm liên kết với table OrderDetail
		String sql = "select * from [OrderDetails] where MaSach = ?";
		PreparedStatement c;
		try {
			c = thietLap.cn.prepareStatement(sql);
			c.setInt(1, ID);
			ResultSet rs = c.executeQuery();
			return rs.next();
		} catch (Exception e) {
			System.out.println("Loi tim ma!");
			e.printStackTrace();
			return true; // return true để ko cho xoá
		}
		// Tìm kiếm liên kết với table ...
	}
	
	public boolean xoa(int Id) {
		String sql = "delete from [Sach] where MaSach = ?";
		boolean result = false;
		if(!daLienKet(Id)) { // Nếu sách chưa liên kết với các bảng dữ liệu khác
			try {
				PreparedStatement c = ThietLap.cn.prepareStatement(sql);
				c.setInt(1, Id);
				if(c.executeUpdate() == 1) result = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean them(Sach sach) {
		String sql = "Insert into [Sach](TenSach, GiaBan, MaTacGia, MaLoaiSach, BiaSach, GioiThieu) values (?, ?, ?, ?, ?, ?)";
		boolean result = false;
		try {
			PreparedStatement c = ThietLap.cn.prepareStatement(sql);
			c.setNString(1, sach.getTensach());
			c.setBigDecimal(2, BigDecimal.valueOf(sach.getGia()));
			c.setString(3, sach.getTacGia().getMaTacGia());
			c.setString(4, sach.getLoaiSach().getMaLoai());
			c.setNString(5, sach.getAnh());
			c.setNString(6, sach.getInfo());
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			System.out.println("SachDAO Them:");
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean update(Sach sach) {
		String sql = "Update [Sach] set TenSach = ?, GiaBan = ?, MaTacGia = ?, MaLoaiSach = ?, BiaSach = ?, GioiThieu = ?";
		boolean result = false;
		try {
			PreparedStatement c = ThietLap.cn.prepareStatement(sql);
			c.setNString(1, sach.getTensach());
			c.setBigDecimal(2, BigDecimal.valueOf(sach.getGia()));
			c.setString(3, sach.getTacGia().getMaTacGia());
			c.setString(4, sach.getLoaiSach().getMaLoai());
			c.setNString(5, sach.getAnh());
			c.setNString(6, sach.getInfo());
			if(c.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Sach> docDatabase() {
		list = new ArrayList<Sach>();
		try {
			String sql = "select * from [Sach] as s left join [TacGia] as t on s.MaTacGia = t.maTacGia left join [LoaiSach] as l on s.MaLoaiSach = l.MaLoaiSach";
			PreparedStatement c = ThietLap.cn.prepareStatement(sql);
			ResultSet data = c.executeQuery();
			
			if(data == null) System.out.println("Data null");
			while(data.next()) {
				String masach = String.valueOf(data.getInt("MaSach"));
				String tensach = data.getNString("TenSach");
				Long gia = toLong(data.getBigDecimal("GiaBan"));
				String maTacGia = data.getString("MaTacGia").trim();
				//TODO: Dùng TacGiaDao để lấy thông tin
				String tenTacGia = data.getString("TenTacGia");
				String info = data.getString("Info");
				String hinhAnh = data.getString("HinhAnh");
				String anh = data.getString("BiaSach");
				String maloai = data.getString("MaLoaiSach").trim();
				String tenloai = data.getNString("TenLoaiSach").trim();
				String gioiThieuSach = data.getNString("GioiThieu");
				list.add(new Sach(masach, tensach, new TacGia(maTacGia, tenTacGia, info, hinhAnh), gia, anh, new LoaiSach(maloai, tenloai), gioiThieuSach));
			}
			data.close();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Lỗi đọc database!");
		}
		return list;
	}
	
	public Sach find(String maSach) {
		for (Sach sach : list) {
			if(sach.getMasach().equals(maSach)) return sach;
		}
		return null;
	}
	
	public ArrayList<Sach> timTheoTenSach(String text){
		ArrayList<Sach> result = new ArrayList<Sach>();
		if(list != null) {
			for (Sach sach : list) {
				if(sach.getTensach().toLowerCase().contains(text.toLowerCase())) {
					result.add(sach);
				}
			}
		}
		return result;
	}
	
	public ArrayList<Sach> timTheoTenTacGia(String text){
		ArrayList<Sach> result = new ArrayList<Sach>();
		if(list != null) {
			for (Sach sach : list) {
				if(sach.getTacGia().getTenTacGia().toLowerCase().contains(text.toLowerCase())) {
					result.add(sach);
				}
			}
		}
		return result;
	}
	
	public ArrayList<Sach> timKiemLienQuan(String text){
		ArrayList<Sach> result = new ArrayList<Sach>();
		if(list != null) {
			for (Sach sach : list) {
				if(sach.getTacGia().getTenTacGia().toLowerCase().contains(text.toLowerCase()) || sach.getTensach().toLowerCase().contains(text.toLowerCase())) {
					result.add(sach);
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param tag: mã loại sách
	 * @return
	 */
	public ArrayList<Sach> locTheoLoaiSach(String tag){
		ArrayList<Sach> result = new ArrayList<Sach>();
		if(list != null) {
			for (Sach sach : list) {
				if(sach.getLoaiSach().getMaLoai().toLowerCase().equals(tag.toLowerCase())) {
					result.add(sach);
				}
			}
		}
		return result;
	}
	
	/**
	 * Lấy số phần tử của danh sách
	 * @return
	 */
	public int getSize() {
		if(list == null) return 0;
		return list.size();
	}
	
	/**
	 * Lấy danh sách của trang thứ page
	 * @param page: Trang thứ
	 * @param sizeOfPage: Số phần tử trong trang
	 * @return
	 */
	public ArrayList<Sach> getPage( int page, int sizeOfPage){
		ArrayList<Sach> result = new ArrayList<Sach>();
		int m = Math.min((page-1)*sizeOfPage, getSize()); // phần tử đầu tiên cần trả về
		int n = Math.min(m+sizeOfPage, getSize()); // phần tử cuối cùng cần trả về
		for(int i = m; i < n; i++) {
			result.add(list.get(i));
		}
		return result;
	}
	
	/**
	 * Lấy số trang
	 * @param sizeOfPage: Số phần tử trong một trang
	 * @return
	 */
	public int getNumberOfPage(int sizeOfPage){
		int size = getSize();
		int result = size/sizeOfPage;
		if(size%sizeOfPage > 0) result++;
		return result;
	}
	
	
	
}
