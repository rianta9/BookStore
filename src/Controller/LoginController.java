package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.User;
import bo.UserBO;

@WebServlet(urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		
		

		HttpSession session = req.getSession();
		// Nếu user đã đăng nhập thì không cho phép đăng ký nữa
		if(session.getAttribute("user") != null) {
			resp.sendRedirect(req.getContextPath()+ "/waiting");
			return;
		}
		
		else {
			// Create a Bundle of errors in the form of Map 

			Map<String, String> errors = new HashMap<String, String>(); 
			Map<String, String> after = new HashMap<String, String>(); 

			String indentity = req.getParameter("indentity");
			String password = req.getParameter("password");
			
			boolean isRememberMe = false;
			String remember = req.getParameter("remember");
			
			if(indentity != null && password != null) {
				UserBO bo = new UserBO();
				int checkResult = bo.checkLogin(indentity, password);
				if(checkResult == 1) {
					User u = bo.getLogin(indentity, password);
					session.setAttribute("user", u);
					System.out.println("UserID: " + u.getUserID() + ", MaPhanQuyen: "+ u.getMaPhanQuyen());
					// xoá after, errors
					session.removeAttribute("after");
					session.removeAttribute("errors");
					
					if("on".equals(remember)){
						isRememberMe = true;
					}
					
					if(isRememberMe){
						saveRemeberMe(resp, u.getName());
					}
					
					resp.sendRedirect(req.getContextPath()+ "/waiting");
					return;
				}
				else {
					after.put("indentity", indentity);
					if(checkResult == -1) errors.put("illegal_indentity", "Email hoặc sđt không tồn tại!");
					else errors.put("loginfail", "Mật khẩu không chính xác!");
				}
			}
			req.setAttribute("after", after);
			req.setAttribute("errors", errors);
		}

		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private void saveRemeberMe(HttpServletResponse response, String username){
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
	}
}
