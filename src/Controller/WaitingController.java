package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;

@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("user") != null) {
			User u=(User) session.getAttribute("user");
			req.setAttribute("username", u.getName());
			if(u.getMaPhanQuyen().equalsIgnoreCase("admin")) {
				resp.sendRedirect(req.getContextPath()+"/admin");
			}else {
				resp.sendRedirect(req.getContextPath()+"/SachController");
			}
			
		}else {
			resp.sendRedirect(req.getContextPath()+"/LoginController");
		}
	}

}
