package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;
import member.MemberDAO_id;
import member.MemberService;
import member.MemberVO;


@WebServlet("*.me")
public class MemberController extends HttpServlet {
	RequestDispatcher rd;
	MemberService service;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equals("/loginpage.me")) {
		rd = req.getRequestDispatcher("member/login.jsp");
		rd.forward(req, resp);
		}else if (req.getServletPath().equals("/login.me")) {
			
//			System.out.println(req.getParameter("user_id"));
//			System.out.println(req.getParameter("user_pw"));
			service = new MemberDAO();
			MemberVO vo = new MemberVO();

			vo.setUser_id(req.getParameter("user_id"));
			vo.setUser_pw(req.getParameter("user_pw"));
			vo = service.member_login(vo);
			
			req.getSession().setAttribute("logininfo" , vo);
			String result = req.getSession().getAttribute("logininfo") == null ? "-1" : "1";
			resp.getWriter().print(result);
		}else if (req.getServletPath().equals("/logout.me")) {
			req.getSession().removeAttribute("logininfo"); //login에서 받아서 Session을 만들었던거 제거
			resp.sendRedirect("/mvc");
		}else if (req.getServletPath().equals("/joinpage.me")) {
			rd = req.getRequestDispatcher("member/join.jsp");
			rd.forward(req, resp);
		}else if(req.getServletPath().equals("/join.me")) {
			MemberVO vo = new MemberVO();
			vo.setUser_id(req.getParameter("user_id"));
			vo.setUser_pw(req.getParameter("user_pw"));
			vo.setName(req.getParameter("name"));
			vo.setEmail(req.getParameter("email"));
			vo.setAddress(req.getParameter("address"));
			vo.setPost(req.getParameter("post"));
			
			service = new MemberDAO();
			System.out.println(service.member_join(vo)); 
		}else if (req.getServletPath().equals("/idCheck.me")) {
			System.out.println(req.getParameter("user_id"));
			service = new MemberDAO_id();
			service.member_idCheck(req.getParameter("user_id"));	
		}
	}
}
