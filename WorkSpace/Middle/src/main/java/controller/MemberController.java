package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.MemberDAO;
import member.MemberVO;


@WebServlet("*.me")
public class MemberController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equals("/login.me")) {
			System.out.println(req.getParameter("user_id"));
			MemberDAO dao = new MemberDAO();
			MemberVO vo = new MemberVO();
			vo.setUser_id(req.getParameter("user_id"));
			vo.setUser_pw(req.getParameter("user_pw"));
			vo.setSocial(req.getParameter("social"));
			vo = dao.member_login(vo);

			String param = new Gson().toJson(vo);
			
			System.out.println(param);
			resp.getWriter().println(param);
		}
	}

}
