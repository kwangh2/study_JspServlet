package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;
	
	//인코딩 초기화 : web.xml에 넣어둔 param 사용
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		Filter.super.init(filterConfig);
		encoding = filterConfig.getInitParameter("encoding"); //UTF-8
	}
	
	//필터 작동부
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding); //UTF-8
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html; charset=UTF-8");
		chain.doFilter(request, response); 	
	}
}
