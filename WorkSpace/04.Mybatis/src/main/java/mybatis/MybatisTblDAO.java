package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTblDAO {
	//싱글톤 ( static 블러킹을 이용해서 전역적인 초기화식 사용) : 단점 맵퍼 변경사항이나 config.xml 변경사항을 읽지않음.-> 서버 재가동시켜야함
	private static SqlSession sql;
	static {
		System.out.println("싱글톤?");
		String resource = "mybatis/config.xml"; // 
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
			 sql = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public int insert(MybatisTblVO vo) {

		int result = sql.insert("testmapper.insertTbl",vo);
		return result ;
	}
	public int update(MybatisTblVO vo) {
		int result = sql.update("testmapper.updateTbl",vo);
		return result;
				
	}
	public int delete(MybatisTblVO vo) {
		return sql.delete("testmapper.deleteTbl",vo);
	}
	public List<MybatisTblVO> select() {
		List<MybatisTblVO> list = sql.selectList("testmapper.selectTbl");
		return list;
	}
}
