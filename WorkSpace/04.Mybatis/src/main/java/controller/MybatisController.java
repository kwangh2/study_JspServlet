package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.MybatisVO;

@WebServlet("*.my")
public class MybatisController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resource = "mybatis/config.xml"; // 폴더 및 파일.
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); // 마이바티스 홈페이지에서
																									// SqlSessionFactory
																									// 빌드
	
		SqlSession sql = sqlSessionFactory.openSession(true);// Connection객체를 이용해서 ps(전송)
		String path = req.getServletPath();
		
		if (req.getServletPath().equals("/select1.my")) {
			int result = sql.selectOne("testmapper.select1"); // namespace.id , mapper xml파일에서 만들어놓은 쿼리문 실행.
			System.out.println(result);
		}else if(req.getServletPath().equals("/select2.my")) {
			String result = sql.selectOne("testmapper.select2");
			System.out.println(result);
		}else if(path.equals("/selectVO.my")) {
			MybatisVO vo = sql.selectOne("testmapper.selectVO");
			System.out.println(vo.getParam1() + " : " + vo.getParam2());
		}else if(path.equals("/selectVOList.my")) {
			List<MybatisVO> list =  sql.selectList("testmapper.selectVOList");
			System.out.println(list.size());
			System.out.println(list.get(1).getParam1());
			System.out.println(list.get(0).getParam1());
		}else if(path.equals("/param1.my")) {
			String param = "jkh";
			String result = sql.selectOne("testmapper.param1",param);//선언한 변수 넘어감 
			System.out.println(result);
		}else if(path.equals("/param2.my")) {
			int param2 =2;
			int result = sql.selectOne("testmapper.param2",param2);
			System.out.println(result);
		}else if(path.equals("/params.my")) {
			MybatisVO vo = new MybatisVO();
			vo.setParam1("abc");
			vo.setParam2("sdf");
			MybatisVO noRtn = sql.selectOne("params",vo);
			System.out.println(noRtn.getParam1());
			System.out.println(noRtn.getParam2());
		}else if(path.equals("/parammap.my")) {
			HashMap<String, String> paramMap = new HashMap<>();
			paramMap.put("param1", "abc");
			paramMap.put("param2", "dfdv");
			MybatisVO voRtn = sql.selectOne("params",paramMap);
			System.out.println(voRtn.getParam1());
			System.out.println(voRtn.getParam2());
		}else if(path.equals("/insert.my")) {
			int result = sql.insert("testmapper.insert");
//			sql.commit(); //커밋안해주면 중간에 멈춤
			System.out.println(result);
		}else if(path.equals("/update.my")) {
			int result = sql.update("testmapper.update");
			System.out.println(result);
		}else if(path.equals("/delete.my")) {
			int result = sql.delete("testmapper.delete");
			System.out.println(result);
		}
	}
}
