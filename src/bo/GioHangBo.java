package bo;

import java.util.ArrayList;

import bean.MonHang;

public class GioHangBo {
	
	ArrayList<MonHang> ds = new ArrayList<MonHang>();
	
	public void Them(MonHang mh) {
		for (MonHang monHang : ds) {
			if(monHang.getMaHang().equals(mh.getMaHang())) {
				monHang.increase(mh.getSoLuong());
				return;
			}
		}
		ds.add(mh);
	}
	
	public void xoa(String maHang) {
		for (MonHang monHang : ds) {
			if(monHang.getMaHang().equals(maHang)) {
				ds.remove(monHang);
				return;
			}
		}
	}
	
	
}
