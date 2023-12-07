package member;

import java.util.HashMap;

import common.MybatisConnection;

public class MemberDAO extends MybatisConnection implements MemberService{

	public MemberDAO(DataResource res) {
		super(DataResource.HANUL);
		
	}

	@Override
	public int member_join(MemberVO vo) {
		return 0;
	}

	@Override
	public int member_idCheck(String user_id) {
		return 0;
	}

	@Override
	public MemberVO member_login(HashMap<String, String> param) {
		return null;
	}

	@Override
	public int member_update(MemberVO vo) {
		return 0;
	}

	@Override
	public int member_delete(MemberVO vo) {
		return 0;
	}

	//진행예정
	@Override
	public void findPassWord(MemberVO vo) {}
	
}
