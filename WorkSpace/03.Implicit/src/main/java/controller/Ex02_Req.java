package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ex02")
public class Ex02_Req extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("EX02까지 옴 ");
	//DAO , JDBC 이용 로그인 확인 => Model
		//req (form 태그 또는 a태그 등으로 들어오는 파라메터를 가지고 있다.) jsp -> servlet 동안만 : getParameter <- String 
		String email = req.getParameter("email");
		System.out.println(email);
		String pw = req.getParameter("pw");
		if("admin1234".equals(pw) && "admin".equals(email)) {
			 rd = req.getRequestDispatcher("request/ex03req.jsp");
		}else {
			 rd = req.getRequestDispatcher("request/ex02req.jsp");
			rd.forward(req, resp);
		}
		
		//Attribute 
//		req.setAttribute("key", "data");
		
		
		ArrayList<String> arrList = new ArrayList();
		arrList.add("String 1");
		arrList.add("String 2");
		arrList.add("String 3");
		arrList.add("String 4");
		arrList.add("String 5");
		
		req.setAttribute("key", "data");
//		rd.forward(req, resp);
		
		ArrayList<String> list = new ArrayList();
		list.add("String 1");
		list.add("String 2");
		list.add("String 3");
		list.add("String 4");
		list.add("String 5");
//		req.setAttribute("key", "data");
		req.setAttribute("list", list);
		rd.forward(req, resp);
		}

}
