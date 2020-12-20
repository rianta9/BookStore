package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.TacGia;
import jdbc.ThietLap;

public class TacGiaDAO {
	private ArrayList<TacGia> list;
	private ThietLap thietLap;
	
	public TacGiaDAO() {
		list = new ArrayList<TacGia>();
		thietLap = new ThietLap();
		thietLap.connect();
	}
	
	public boolean them(TacGia tacGia) {
		boolean result = false;
		String sql = "insert into [TacGia](MaTacGia, TenTacGia, Info, HinhAnh) values(?, ?, ?, ?)";
		try {
			PreparedStatement p = ThietLap.cn.prepareStatement(sql);
			p.setString(1, tacGia.getMaTacGia());
			p.setNString(2, tacGia.getTenTacGia());
			p.setNString(3, tacGia.getInfo());
			p.setString(4, tacGia.getHinhAnh());
			
			if(p.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean sua(TacGia tacGia) {
		boolean result = false;
		String sql = "update [TacGia] set TenTacGia = ?, Info = ?, HinhAnh = ? where MaTacGia = ?";
		try {
			PreparedStatement p = ThietLap.cn.prepareStatement(sql);
			p.setNString(1, tacGia.getTenTacGia());
			p.setNString(2, tacGia.getInfo());
			p.setString(3, tacGia.getHinhAnh());
			p.setString(4, tacGia.getMaTacGia());
			
			if(p.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean xoa(String id) {
		boolean result = false;
		String sql = "delete from [TacGia] where MaTacGia = ?";
		try {
			PreparedStatement p = ThietLap.cn.prepareStatement(sql);
			p.setString(1, id);
			
			if(p.executeUpdate() == 1) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public TacGia timKiem(String id) {
		String sql = "select * from [TacGia] where MaTacGia = ?";
		try {
			PreparedStatement p = ThietLap.cn.prepareStatement(sql);
			p.setString(1, id);
			
			ResultSet rs = p.executeQuery();
			if(rs.next()) {
				String maTacGia = rs.getString("MaTacGia");
				String tenTacGia = rs.getNString("TenTacGia");
				String info = rs.getNString("Info");
				String hinhAnh = rs.getString("HinhAnh");
				TacGia tacGia = new TacGia(maTacGia, tenTacGia, info, hinhAnh);
				return tacGia;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<TacGia> docDatabase(){
		list = new ArrayList<TacGia>();
		try {
			ResultSet data = ThietLap.getTable("LoaiSach");
			if(data == null) System.out.println("Data tacgia null");
			while(data.next()) {
				String maTacGia = data.getString("MaTacGia");
				if(maTacGia != null) maTacGia = maTacGia.trim();
				String tenTacGia = data.getNString("TenTacGia");
				if(tenTacGia != null) tenTacGia = tenTacGia.trim();
				String info = data.getNString("Info");
				if(info != null) info = info.trim();
				String hinhAnh = data.getString("HinhAnh");
				if(hinhAnh != null) hinhAnh = hinhAnh.trim();
				list.add(new TacGia(maTacGia, tenTacGia, info, hinhAnh));
			}
			data.close();
		} catch (SQLException e){
			System.out.println("Lỗi đọc database!");
		}
		return list;
	}
}
