package chap06;

public class StMain {

	public static void main(String[] args) {
		
		// 싱글톤 사용시 객체생성 불가 -> 메소드 호출해서 받아와야 함
		
		Singleton st = Singleton.getInstance();
		Singleton st2 = Singleton.getInstance();
		
		if(st == st2) {
			System.out.println("같은 객체입니다");
		}else {
			System.out.println("다른 객체입니다");
		}
		
		st2.name = "거시기";
		System.out.println(st.name);
		st.name = "아무개";
		System.out.println(st2.name);
		
		// p307 3번문제
		// 싱글톤 메소트 호출
		ShopService sh = ShopService.getInstance();
		ShopService sh2 = ShopService.getInstance();
		
			
		if(sh == sh2) {
			System.out.println("같은 객체입니다");
		}else {
			System.out.println("다른 객체입니다.");
		}
		
		
	}
}
