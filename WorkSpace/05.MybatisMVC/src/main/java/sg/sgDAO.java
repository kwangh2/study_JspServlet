package sg;

import java.util.List;

import common.MybatisConnection;

public class sgDAO extends MybatisConnection{
	
	public sgDAO() {
		super(DataResource.HANUL);
	}

	public List<sgVO> select() {
		return sql.selectList("sg.select");
	}
	public void delete(int employee_id ) {
		sql.delete("sg.delete",employee_id);
	}
	public void insert(sgVO vo) {
		sql.insert("sg.insert",vo);
	}
}
