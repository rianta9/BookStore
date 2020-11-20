package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.LoaiSach;
import jdbc.ThietLap;

public class LoaiDAO {

	ArrayList<LoaiSach> list;
	ThietLap database;
	
	public LoaiDAO() {
		database = new ThietLap();
		database.connect();
		list = new ArrayList<LoaiSach>();
	}
	
	public ArrayList<LoaiSach> getLoaiSach(){
		list = new ArrayList<LoaiSach>();
		
		list.add(new LoaiSach("tieuthuyet", "Tiểu Thuyết"));
		list.add(new LoaiSach("trinhtham", "Trinh Thám"));
		list.add(new LoaiSach("chinhtri-phapluat", "Chính Trị - Pháp Luật"));
		list.add(new LoaiSach("khoahoc-congnghe", "Khoa Học - Công Nghệ"));
		list.add(new LoaiSach("kinhte", "Kinh Tế"));
		list.add(new LoaiSach("nghethuat", "Nghệ Thuật"));
		list.add(new LoaiSach("giaokhoa", "Giáo Khoa"));
		list.add(new LoaiSach("truyenngan", "Truyện Ngắn"));
		list.add(new LoaiSach("lightnovel", "Light Novel"));
		list.add(new LoaiSach("manga", "Manga"));
		list.add(new LoaiSach("ngontinh", "Ngôn Tình"));
		list.add(new LoaiSach("tamlyhoc", "Tâm Lý Học"));
		list.add(new LoaiSach("triethoc", "Triết Học"));
		list.add(new LoaiSach("tamlinh", "Tâm Linh"));
		list.add(new LoaiSach("tongiao", "Tôn Giáo"));
		list.add(new LoaiSach("kynangsong", "Kỹ Năng Sống"));
		
		return list;
	}
	
	public ArrayList<LoaiSach> docDatabase() {
		list = new ArrayList<LoaiSach>();
		try {
			ResultSet data = ThietLap.getTable("LoaiSach");
			if(data == null) System.out.println("Data null");
			while(data.next()) {
				String maLoai = data.getString("MaLoaiSach").trim();
				String tenLoai = data.getNString("TenLoaiSach").trim();
				list.add(new LoaiSach(maLoai, tenLoai));
			}
			data.close();
		} catch (SQLException e){
			System.out.println("Lỗi đọc database!");
		}
		return list;
	}
	
}
