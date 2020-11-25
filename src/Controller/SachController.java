package Controller;

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
import bo.LoaiBO;
import bo.SachBO;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
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
				       
			request.setAttribute("listloaisach", lbo.getLoaiSach());
			
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
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
