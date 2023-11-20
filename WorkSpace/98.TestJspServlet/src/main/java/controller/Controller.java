package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.DTO;


@WebServlet("*.te")
public class Controller extends HttpServlet {
	RequestDispatcher rd ;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if(req.getServletPath().equals("/list.te")) {
		
		rd = req.getRequestDispatcher("test/list.jsp");
		req.setAttribute("data", "servletData");
		rd.forward(req, resp);
		}else if(req.getServletPath().equals("/new.te")) {
			rd = req.getRequestDispatcher("test/new.jsp");
			rd.forward(req, resp);
		}else if(req.getServletPath().equals("/insert.te")) {
			DTO dto = new DTO();
			rd = req.getRequestDispatcher("test/update.jsp");
			dto.setUserId(req.getParameter("userId"));
			dto.setUserPw(req.getParameter("userPw"));
			req.setAttribute("userID", dto.getUserId());
			req.setAttribute("userPW", dto.getUserPw());
			rd.forward(req, resp);
		}else if(req.getServletPath().equals("/delete.te")) {
			req.getParameter("deleteid");
			
			
		}else {
			resp.getWriter().println("오류!");
		}
		
		
		
		
	}
}

