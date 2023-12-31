package implicit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex01_Request")
public class Ex01_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request(요청) : 요청에 대한 모든 정보를 담고있음. (URL이 조작되어 서버로 페이지 또는 값을 요청하는 것)
		//URI : 식별자
		//URL : http프로토콜(각종프로토콜)의 주소와 식별자가 합쳐진 형태 
		//URN : htt......?param=값
		//RequestDispatcher : 요청객체 (request)로 초기화가 되며, 요청에 대한 처리를 다시 페이지로 넘길껀지, 처리결과를 얻어오는등.
		//여러가지 기능을 수행함 
		//Controller에서 페이지를 전환하는 용도로 사용 
		
		
		System.out.println("서버 도메인명 : " + request.getServerName());
		System.out.println("서버 포트 : " + request.getServerPort());
		System.out.println("요청 정보(URI) : " + request.getServletPath()); //url 정보 
		System.out.println("요청 정보(URL) : " + request.getRequestURL()); 
		System.out.println("요청 정보(Method) : " + request.getMethod()); 
		
		RequestDispatcher rd = request.getRequestDispatcher("02.Directive/Ex03_Main.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
