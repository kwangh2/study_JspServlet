package customer;

import java.util.List;

import common.MybatisConnection;

public class CustomerDAO extends MybatisConnection{
	 public CustomerDAO() {
		super(DataResource.HANUL);
	}
	 
	 //초기 데이터베이스 연결 테스트 1을 조회하는 쿼리를 넣어두고 실행결과 1을 조회후 결과로 가지고오는지 테스트
	public void test() {
		 int result = sql.selectOne("cu.test");
		 System.out.println(result);
	 }
	 public List<CustomerVO> select(String query) {
		return sql.selectList("cu.select" , query);
	}
	 public void delete(int customer_id) {
		sql.delete("cu.delete", customer_id); 
	}
	 public void insert(CustomerVO vo) {
		System.out.println("인서트 : " + sql.insert("cu.insert" , vo));
	}
	 public void update(CustomerVO vo) {
		System.out.println("인서트 : " + sql.update("cu.update" , vo));
	}
}
