package Controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Sach;
import bean.User;
import bo.LoaiBO;
import bo.SachBO;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/admin/dist/QuanLySach")
public class SachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	LoaiBO lbo = new LoaiBO();
	SachBO sbo = new SachBO();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user == null || !user.getMaPhanQuyen().equalsIgnoreCase("Admin")) {
				if(user == null) System.out.println("User null");
				response.sendRedirect("/BookStore/LoginController");
				return;
			}
			
			String action = request.getParameter("action");
			
			if(action == null || action.isEmpty()) viewList(request, response);
			else if(action.equals("delete")) {
				String id = request.getParameter("id");
				if(id != null && !id.isEmpty()) {
					int Id = Integer.parseInt(id);
					xoa(Id, request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void viewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listloaisach", lbo.getLoaiSach());
		request.setAttribute("url", request.getContextPath() + "/admin/dist");
		ArrayList<Sach> ds = sbo.getSach();
		String search = request.getParameter("search");
		if(search != null && !search.isEmpty()) {
			ds = sbo.timKiemLienQuan(search);
		}
		else{
			String tag = request.getParameter("tag"); 
			if(tag == null || tag.isEmpty()) ds = sbo.getSach();
			else ds = sbo.locTheoLoaiSach(tag);
		}
		
		request.setAttribute("listsach", ds);
		
		RequestDispatcher rd = request.getRequestDispatcher("sach.jsp");
		rd.forward(request, response);
	}
	
	protected void xoa(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		SachBO bo = new SachBO();
		boolean result = bo.xoa(id);
		if(result) System.out.println("Xoá sách #" + id + " thành công!");
		System.out.println("Xoá sách #" + id + " thất bại!");
		if(result) response.getWriter().print("<script>alert('Xoá Thành Công!')</script>");
		else response.getWriter().print("<script>alert('Xoá Thất Bại!')</script>");
		
		response.sendRedirect("QuanLySach");
	}

}
