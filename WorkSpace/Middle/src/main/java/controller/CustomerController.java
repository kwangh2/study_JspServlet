package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import customer.CustomerDAO;
import customer.CustomerVO;


@WebServlet("*.cu")
public class CustomerController extends HttpServlet {
	CustomerDAO dao = new CustomerDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getServletPath().equals("/select.cu")) {
			//1. 마이바티스 common config.xml파일확인
			//2 .				mapper.xml확인
			//3.				DAO <-(MybatisConnection)

			String query = req.getParameter("query");
			System.out.println(query);
			List<CustomerVO> list = dao.select(query);
			
			resp.getWriter().println(new Gson().toJson(list));
			}else if(req.getServletPath().equals("/delete.cu")){
				System.out.println(req.getParameter("customer_id"));
				int customer_id = Integer.parseInt(req.getParameter("customer_id"));
				dao.delete(customer_id);
			}else if(req.getServletPath().equals("/update.cu")) {
				System.out.println(req.getParameter("vo"));
				
				dao.update(new Gson().fromJson(req.getParameter("vo"), CustomerVO.class));
			}
	}

}
