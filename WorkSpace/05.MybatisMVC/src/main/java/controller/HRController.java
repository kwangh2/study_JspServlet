package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import hr.hrDAO;

@WebServlet("*.hr")
public class HRController extends HttpServlet {
	RequestDispatcher rd;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		hrDAO dao = new hrDAO();
		
		if(req.getServletPath().equals("/list.hr")) {
			rd = req.getRequestDispatcher("hr/hrList.jsp");
			HashMap<String, String> map = new HashMap<>();
			map.put("option", req.getParameter("option"));
			map.put("keyword", req.getParameter("keyword"));
			
			req.setAttribute("option", map.get("option"));
			req.setAttribute("keyword", map.get("keyword"));
			req.setAttribute("list", dao.select(map));
			rd.forward(req, resp);
		}
	}
}
