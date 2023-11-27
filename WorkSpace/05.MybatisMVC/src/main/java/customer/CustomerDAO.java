package customer;

import java.util.List;

import common.MybatisConnection;

public class CustomerDAO extends MybatisConnection{
	 public void test() {
		 int result = sql.selectOne("cu.test");
		 System.out.println(result);
	 }
	 public List<CustomerVO> select() {
		return sql.selectList("cu.select");
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
