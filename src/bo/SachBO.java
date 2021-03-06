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
	
	public ArrayList<Sach> timKiemLienQuan(String text){
		return dao.timKiemLienQuan(text);
	}
	
	public ArrayList<Sach> locTheoLoaiSach(String tag){
		return dao.locTheoLoaiSach(tag);
	}
	
	public Sach find(String maSach) {
		return dao.find(maSach);
	}
	
	public boolean them(Sach sach) {
		return dao.them(sach);
	}
	
	public boolean xoa(int id) {
		return dao.xoa(id);
	}
	
	public boolean update(Sach sach) {
		return dao.update(sach);
	}
}
