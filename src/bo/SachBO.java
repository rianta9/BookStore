package bo;

import java.util.ArrayList;

import bean.Sach;
import dao.SachDAO;

public class SachBO {
	SachDAO dao = new SachDAO();

	public void SachBO() {
		getSach();
	}
	
	public ArrayList<Sach> getSach(){
		return dao.docDatabase();
	}
	
	public ArrayList<Sach> getPage( int page, int sizeOfPage){
		return dao.getPage(page, sizeOfPage);
	}
	
	public int getNumberOfPage(int sizeOfPage) {
		return  dao.getNumberOfPage(sizeOfPage);
	}
	
	public ArrayList<Sach> timTheoTenSach(String text){
		return dao.timTheoTenSach(text);
	}
	
	public ArrayList<Sach> timTheoTenTacGia(String text){
		return dao.timTheoTenTacGia(text);
	}
	
	public ArrayList<Sach> locTheoLoaiSach(String tag){
		return dao.locTheoLoaiSach(tag);
	}
	
	public Sach find(String maSach) {
		return dao.find(maSach);
	}
}
