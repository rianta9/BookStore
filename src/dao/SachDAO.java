package dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.LoaiSach;
import bean.Sach;
import jdbc.ThietLap;

public class SachDAO {
	private ArrayList<Sach> list;
	private ThietLap thietLap;
	
	public SachDAO() {
		list = new ArrayList<Sach>();
		thietLap = new ThietLap();
		thietLap.connect();
	}

	public ArrayList<Sach> getSach() {
		list = new ArrayList<Sach>();
		list.add(new Sach("s1","Đắc Nhân Tâm","Daniel Carnegie",10000,"images//a1.jpg","tieuthuyet"));
		list.add(new Sach("s2","Tôi Tài Giỏi Bạn Cũng Thế","Adam Khoo",10000,"images//a2.jpg","lightnovel"));
		list.add(new Sach("s3","Làm Chủ Tư Duy Thay Đổi Vận Mệnh","Adam Khoo",50000,"images//a3.jpg","manga"));
		list.add(new Sach("s4","Cảm Xúc Là Kẻ Thù Số Một Của Thành Công","Lê Thẩm Dương",100000,"images//a4.jpg","tamlyhoc"));
		list.add(new Sach("s5","Code Dạo Ký Sự","Phạm Huy Hoàng",10000,"images//a5.jpg","trinhtham"));
		list.add(new Sach("s6","Quẳng Gánh Lo Đi Mà Vui Sống","Daniel Carnegie",50000,"images//a6.jpg","ngontinh"));
		list.add(new Sach("s6","Người Giỏi Không Bởi Học Nhiều","Alpha Book Biên Soạn",90000,"images//a6.jpg","ngontinh"));
		list.add(new Sach("s6","Giới Hạn Của Bạn Là Xuất Phát Điểm Của Người Khác","Mèo Maverick",100000,"images//a6.jpg","ngontinh"));

		return list;
	}
	
	
	private Long toLong(BigDecimal a) {
		double n = Double.valueOf(a.toString());
		return (long)n;
	}
	
	public ArrayList<Sach> docDatabase() {
		list = new ArrayList<Sach>();
		try {
			String sql = "select * from [Sach] as s join [TacGia] as t on s.MaTacGia = t.maTacGia";
			PreparedStatement c = thietLap.cn.prepareStatement(sql);
			ResultSet data = c.executeQuery();
			
			if(data == null) System.out.println("Data null");
			while(data.next()) {
				String masach = String.valueOf(data.getInt("MaSach"));
				String tensach = data.getNString("TenSach").trim();
				Long gia = toLong(data.getBigDecimal("GiaBan"));
				String tacgia = data.getString("TenTacGia").trim();
				String anh = data.getString("BiaSach").trim();
				String maloai = data.getString("MaLoaiSach").trim();
				list.add(new Sach(masach, tensach, tacgia, gia, anh, maloai));
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
				if(sach.getTacgia().toLowerCase().contains(text.toLowerCase())) {
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
				if(sach.getTacgia().toLowerCase().contains(text.toLowerCase()) || sach.getTensach().toLowerCase().contains(text.toLowerCase())) {
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
				if(sach.getMaloai().toLowerCase().equals(tag.toLowerCase())) {
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
