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

@WebServlet("/AddUserController")
public class AddUserController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// Nếu đã đăng nhập thì không cho đăng ký người dùng
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null) {
			resp.sendRedirect("SachController");
			return;
		}
		
		Map<String, String> errors = new HashMap<String, String>(); 
		Map<String, String> after = new HashMap<String, String>(); 
		
		// Lấy dữ liệu
		String fullName = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirm-password");
		
		boolean check = true;
		
		UserBO bo = new UserBO();
		if(fullName == null || fullName.isEmpty()) {
			check = false;
			errors.put("illegal_fullname", "Tên không được bỏ trống!");
		} else after.put("fullname", fullName);
		
		if(bo.isValidEmail(email)) {
			check = false;
			after.put("email", email);
		} else errors.put("illegal_email", "Email đã được sử dụng!");
		
		if(bo.isAvailablePhone(phone)) {
			after.put("phone", phone);
			check = false;
		} else errors.put("illegal_phone", "Số điện thoại đã được sử dụng!");
		
		if(confirmPassword.equals(password)) {
			after.put("password", password);
			check = false;
		} else {
			after.put("password", password);
			errors.put("illegal_confirm_password", "Password không trùng khớp!");
		}
		if(check) try {
			boolean result = bo.them(new User(fullName, password, email, phone));
			if(result) { // Đăng ký thành công
				User u = bo.getLogin(phone, password); // lấy phone vì là trường thông tin bắt buộc trong database
				session.setAttribute("user", u); // lưu lại thông tin đăng nhập
				
				// xoá after, errors
				session.removeAttribute("after");
				session.removeAttribute("errors");
				
				resp.sendRedirect("SachController"); // chuyển hướng đến trang chủ
				return;
			}
			else errors.put("signup_fail", "Tạo tài khoản thất bại, vui lòng kiểm tra thông tin trước khi thử lại!<br>");
		} catch (Exception e) {
			System.out.println("Lỗi khi thêm user");
			e.printStackTrace();
			errors.put("signup_fail", "Tạo tài khoản thất bại, vui lòng kiểm tra thông tin trước khi thử lại!<br>");
		}
		session.setAttribute("after", after);
		session.setAttribute("errors", errors);
		resp.sendRedirect("SignUpController"); // chuyển hướng đến trang đăng ký
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
