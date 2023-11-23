package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.MybatisTblDAO;
import mybatis.MybatisTblVO;


@WebServlet("*.mytbl")
public class MybatisTblController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		MybatisTblDAO dao = new MybatisTblDAO();
		
		MybatisTblVO vo = new MybatisTblVO();
	
		if(path.equals("/insert.mytbl")){
			System.out.println("insert 입장");
			vo.setCol1(req.getParameter("col1"));
			vo.setCol2(req.getParameter("col2"));
			vo.setCol3(req.getParameter("col3"));
			dao = new MybatisTblDAO();
			dao.insert(vo);
			//1.DAO호출
			
			
		}else if(path.equals("/update.mytbl")){
			System.out.println("update");
			vo.setCol1(req.getParameter("col1"));
			vo.setCol2(req.getParameter("col2"));
			vo.setCol3(req.getParameter("col3"));
			dao.update(vo);
			
		}else if(path.equals("/delete.mytbl")){
			vo.setCol1(req.getParameter("col1"));

			dao.delete(vo);
		}else if(path.equals("/select.mytbl")){
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			List<MybatisTblVO> list = dao.select();
			req.setAttribute("list", list);
			rd.forward(req, resp);
			return;
			
		}
		resp.sendRedirect("select.mytbl");
	}
}
