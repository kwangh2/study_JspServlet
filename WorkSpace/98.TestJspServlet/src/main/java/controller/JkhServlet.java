package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.jkh")
public class JkhServlet extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equals("/list.jkh")) {
			rd = req.getRequestDispatcher("jkh/list.jsp");
			rd.forward(req, resp);
		}else if(req.getServletPath().equals("/insert.jkh")) {
			req.setAttribute("param1", req.getParameter("param1")+"1");
			req.setAttribute("param2", req.getParameter("param2")+"1");
			System.out.println(req.getParameter("param1") + req.getParameter("param2"));
			rd = req.getRequestDispatcher("jkh/insert.jsp");
			rd.forward(req, resp);
		}
	}
}
