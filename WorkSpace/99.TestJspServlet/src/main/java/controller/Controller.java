package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testtbl.testTblDAO;
import testtbl.testTblDTO;


@WebServlet(name = "testtbl" ,urlPatterns =  {"/list", "/update"})
public class Controller extends HttpServlet {
	RequestDispatcher rd;
	testTblDAO dao = new testTblDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getServletPath().equals("/list")) {
		rd = req.getRequestDispatcher("jkh/list.jsp");
		ArrayList<testTblDTO> list = dao.list();
		req.setAttribute("list", list);
		rd.forward(req, resp);
		} else if(req.getServletPath().equals("/update")) {
			testTblDTO dto = new testTblDTO();

			dto.setUsername(req.getParameter("username"));
			req.setAttribute("username", dto.getUsername());
			rd = req.getRequestDispatcher("jkh/update.jsp");
			rd.forward(req, resp);
		} else if(req.getServletPath().equals("/updatevalue")) {
			
			rd = req.getRequestDispatcher("/jkh/list.jsp");
			rd.forward(req, resp);
		}
	}
}
