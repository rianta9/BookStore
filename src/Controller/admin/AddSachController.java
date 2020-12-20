package Controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoaiSach;
import bean.Sach;
import bean.TacGia;
import bo.LoaiBO;
import bo.SachBO;

/**
 * Servlet implementation class AddSachController
 */
@WebServlet("/admin/dist/add-sach")
public class AddSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		request.setAttribute("url", request.getContextPath() + "/admin/dist");
		
		LoaiBO lbo = new LoaiBO();
		ArrayList<LoaiSach> listLoaiSach = lbo.getLoaiSach();
		request.setAttribute("listloaisach", listLoaiSach);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("add-sach.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String tenSach = request.getParameter("tensach");
		String giaBan = request.getParameter("giaban");
		String tacGia = request.getParameter("tacgia");
		String anh = request.getParameter("biasach");
		String maLoaiSach = request.getParameter("maloaisach");
		String info = request.getParameter("description");
		
		
		
		if(tenSach != null && giaBan != null && tacGia != null && anh != null && maLoaiSach != null && info != null) {
			
			String maTacGia = tacGia.toLowerCase().replace(" ", "-");
			//TODO: Nếu tìm kiếm mã tác giả trong database không thấy thì tạo mới tác giả trước khi add sách
			//TODO: Tạo mới tác giả bằng tiếng việt thì phải chuyển mã tác giả sang chữ ko dấu
			long gia = 0;
			try {
				gia = Long.parseLong(giaBan);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
			Sach sach = new Sach(tenSach, new TacGia(maTacGia), gia, anh, new LoaiSach(maLoaiSach), info);
			SachBO bo = new SachBO();
			
			boolean result = bo.them(sach);
			if(result) {
				response.sendRedirect("QuanLySach");
				return;
			}
			else System.out.println("Thêm mới sách thất bại!");
		}
		else System.out.println("Dữ liệu còn thiếu. Chưa thể thêm sách!");
	}
}
