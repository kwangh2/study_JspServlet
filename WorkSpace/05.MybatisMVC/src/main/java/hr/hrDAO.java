package hr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.MybatisConnection;

public class hrDAO extends MybatisConnection{

	public hrDAO() {
		super(DataResource.HR);
	}
//	select , update delete , insert
	public List<hrVO> select(HashMap<String, String> map) {
		return sql.selectList("hr.select", map);
	}
	
}
