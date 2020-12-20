package bo;

import java.util.ArrayList;

import bean.TacGia;
import dao.TacGiaDAO;

public class TacGiaBO {
	private TacGiaDAO dao;
	public TacGiaBO() {
		dao = new TacGiaDAO();
	}
	
	public boolean them(TacGia tacGia) {
		return dao.them(tacGia);
	}
	
	public boolean sua(TacGia tacGia) {
		return dao.sua(tacGia);
	}
	
	public boolean xoa(String id) {
		return dao.xoa(id);
	}
	
	public TacGia timKiem(String id) {
		return dao.timKiem(id);
	}
	
	public ArrayList<TacGia> getData() {
		return dao.docDatabase();
	}
}
