package member;

import java.util.HashMap;

public interface MemberService {
	//member_join() : 파마메터 MemberVO를 입력받아 회원가입 처리. 회원가입 로직 구현시 아이디 중복 체크를 비동기로해야함.
	//int member_idcheck(String user_id) :...
	
	int member_join(MemberVO vo);
	int member_idCheck(String user_id);
	
	MemberVO member_login(HashMap<String, String> param);
	int member_update(MemberVO vo);
	int member_delete(MemberVO vo);
	
	//진행예정
	void findPassWord(MemberVO vo);
	//회원가입 (아이디 체크) 
	//로그인
	//수정, 삭제
	//비밀번호찾기
	
}
