package chap13;

public class Member {
	
	public String name;
	public int age;
	
	public Member(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age==age);
		}else {			
			return false;
		}
	}
	
	
	// 중복값을 제거하기 위해 hashCode 재정의(데이터가 다른지 같은지 체크하는용도)
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	
	// toString 이나 객체 자체로 출력할때 해쉬코드말고 값으로 볼려면 toString 재정의가 필요함
//	@Override
//	public String toString() {
//		return name + " : " + age;
//	}

}
