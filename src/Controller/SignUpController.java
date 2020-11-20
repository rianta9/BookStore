package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import bo.UserBO;
import tools.Tool;

@WebServlet(urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// Nếu user đã đăng nhập thì không cho phép đăng ký nữa
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null) {
			resp.sendRedirect("SachController");
			return;
		}
		
		// Lấy thông tin từ after và errors để show lên nếu có lỗi từ lượt sign up trước đó
		// Nếu không có nghĩa là đây là lượt sign up đầu tiên
		Map<String, String> errors = (HashMap<String, String>)session.getAttribute("errors"); 
		Map<String, String> after = (HashMap<String, String>)session.getAttribute("after"); 
		
		if(after != null && errors != null) {
			req.setAttribute("after", after);
			req.setAttribute("errors", errors);
		}

		req.getRequestDispatcher("signup.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
