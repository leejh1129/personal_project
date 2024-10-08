package chap06;

public class MemberService {
	
	// 필드
	String id;
	String passwd;
	// 생성자
	// 메소드
	
	boolean login(String id, String passwd) {
		if(id == "hong" && passwd == "12345") {
			return true;
		}
		return false;
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
	

}
