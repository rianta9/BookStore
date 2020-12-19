package Controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

@WebServlet(urlPatterns="/admin")
public class welcome extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		Object obj=session.getAttribute("user");
		if(obj == null) {
			resp.sendRedirect(req.getContextPath() + "/LoginController");
			return;
		}
		req.setAttribute("url", req.getContextPath() + "/admin/dist");
		User user=(User) obj;
		req.setAttribute("username", user.getName());
		req.getRequestDispatcher("/admin/dist/index.jsp").forward(req, resp);
	}

}
