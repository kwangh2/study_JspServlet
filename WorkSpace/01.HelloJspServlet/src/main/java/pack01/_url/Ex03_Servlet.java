package pack01._url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex03")
public class Ex03_Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청이 들어옴 . Request");
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("id"));
		
	
		
//		PrintWriter writer = response.getWriter();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		if("admin".equals(request.getParameter("id")) && "admin1234".equals(request.getParameter("pw"))) {
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<h1> success</h1>");
			writer.println("</body>");
			writer.println("</html>");
		}else {
			PrintWriter writer = response.getWriter();//
			writer.println("<html>");
			writer.println("<body>");
			writer.println("<h1> asdn</h1>");
			writer.println("</body>");
			writer.println("</html>");
		}
	}

}
