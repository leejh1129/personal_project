package chap06;

public class Student {
	
	// 속성 = 필드
	String stNo;
	String name;
	
	// 생성자(객체 생성) => 객체의 속성을 초기화
	Student(String stNo, String name){
		this.stNo = stNo;	//초기화
		this.name = name;	//초기화
	}
	

	// 기능 = 메소드
	void study() {
		System.out.println("공부합니다.");
	}
	
	void study2() {
		System.out.println("공부안합니다.");
	}

}
