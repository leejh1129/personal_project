package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemberMain {

	public static void main(String[] args) {
		
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		set.add(new Member("최길동", 25));
		set.add(new Member("최길동", 30));
		
		System.out.println("총 객체수 : " + set.size());
		
		// iterator은 set에 index가 없어서 사용해야함
		Iterator<Member> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			Member mb = iterator.next();
//			System.out.println(mb);
//			System.out.println(mb.name + " : " + mb.age);
		}
		
		
		for(Member mb : set) {
//			System.out.println(mb);
//			System.out.println(mb.hashCode());
//			System.out.println(mb.toString());
			System.out.println(mb.name + " : " + mb.age);
		}
		
	}
	
}
