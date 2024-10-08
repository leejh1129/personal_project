package chap06;

public class MemberMain {

	public static void main(String[] args) {
		
		Member member = new Member();
		Member member2 = new Member("홍길동","hong");
		
		System.out.println("이름 : " + member.name);
		System.out.println("아이디 : " + member.id);
		System.out.println("비밀번호 : " + member.passwd);
		System.out.println("나이 : " + member.age);
		
		System.out.println();
		
		member.name = "최하얀";
		member.age = 23;
		
		System.out.println("이름 : " + member.name);
		System.out.println("아이디 : " + member.id);
		System.out.println("비밀번호 : " + member.passwd);
		System.out.println("나이 : " + member.age);
		
		System.out.println();
		
		System.out.println("이름 : " + member2.name);
		System.out.println("아이디 : " + member2.id);
		System.out.println("비밀번호 : " + member2.passwd);
		System.out.println("나이 : " + member2.age);
		
	}

}
