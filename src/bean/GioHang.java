package bean;

import java.util.ArrayList;

public class GioHang {
	private ArrayList<MonHang> list;

	
	public GioHang() {
		this.list = new ArrayList<MonHang>();
	}
	
	public boolean contains(MonHang hang) {
		String maHang = hang.getMaHang();
		for (MonHang monHang : list) {
			if(monHang.getMaHang().equals(maHang)) return true;
		}
		return false;
	}
	
	public MonHang find(String maHang) {
		for (MonHang monHang : list) {
			if(monHang.getMaHang().equals(maHang)) return monHang;
		}
		return null;
	}
	
	public void add(MonHang hang) {
		MonHang find = find(hang.getMaHang());
		if(find == null) list.add(hang);
		else find.increase(hang.getSoLuong());
	}
	
	public void remove(String maHang) {
		MonHang find = find(maHang);
		if(find != null) list.remove(find);
	}
	
	public double tongTien() {
		double result = 0;
		for (MonHang monHang : list) {
			result += monHang.getDonGia()*monHang.getSoLuong();
		}
		return result;
	}

	public ArrayList<MonHang> getList() {
		return list;
	}

	public void setList(ArrayList<MonHang> list) {
		this.list = list;
	}
	
	
	
}
