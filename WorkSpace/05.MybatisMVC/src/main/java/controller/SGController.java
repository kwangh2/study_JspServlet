package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.sgDAO;
import sg.sgVO;





@WebServlet("*.sg")
public class SGController extends HttpServlet {
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path =  req.getServletPath();
		sgDAO dao = new sgDAO();
		sgVO vo = new sgVO();
		if(path.equals("/list.sg")) {
		rd = req.getRequestDispatcher("/sg/sgList.jsp");
		req.setAttribute("list",dao.select()) ;
		rd.forward(req, resp);
		
		
		}else if (path.equals("/delete.sg")) {
			dao.delete(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect("list.sg");
		}else if (path.equals("/insert.sg")) {
			vo.setName(req.getParameter("name"));
			vo.setDepartment_name(req.getParameter("department"));
			vo.setEmail(req.getParameter("email"));
			vo.setSalary(Integer.parseInt(req.getParameter("salary")));
			dao.insert(vo);
			resp.sendRedirect("/insert.sg");
		}
	}
}
