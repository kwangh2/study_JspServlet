package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import usertbl.UserTblDAO;
import usertbl.UserTblDTO;

// name , urlpatterns ... 추천x
// *.user , *.do .... 주의 : /를 빼야함
@WebServlet(name = "usertbl" , urlPatterns = {"/list","/detail" , "/update"})
public class UserTblController extends HttpServlet {
	
	RequestDispatcher rd;
	UserTblDAO dao = new UserTblDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		if(req.getServletPath().equals("/list")) {

			ArrayList<UserTblDTO> list = dao.selectList();
			req.setAttribute("list", list);//${list}
			
			rd = req.getRequestDispatcher("usertbl/list.jsp");
			
		}else if(req.getServletPath().equals("/detail")) {
			String name = req.getParameter("name");
			UserTblDTO dto = dao.selectOne(name);
			req.setAttribute("dto", dto);
			rd = req.getRequestDispatcher("usertbl/detail.jsp");
//			System.out.println(dto.getUsername() + dto.getAddress());
		}else if(req.getServletPath().equals("/update")) {
			UserTblDTO dto = new UserTblDTO();
			dto.setUsername(req.getParameter("username"));
			dto.setBirthyear(Integer.parseInt(req.getParameter("birthyear")));
			dto.setMobile(req.getParameter("mobile"));
			dto.setAddress(req.getParameter("address"));
		}
		rd.forward(req, resp);
	}
	
}
