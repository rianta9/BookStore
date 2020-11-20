package bo;

import java.util.ArrayList;

import bean.LoaiSach;
import dao.LoaiDAO;

public class LoaiBO {
	private LoaiDAO dao;
	
	public LoaiBO() {
		dao = new LoaiDAO();
	}
	
	public ArrayList<LoaiSach> getLoaiSach(){
		return dao.docDatabase();
	}
}
