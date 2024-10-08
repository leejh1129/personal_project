package chap13;

import java.util.ArrayList;
import java.util.List;

public class ArrListMain {

	public static void main(String[] args) {
		
		// List 컬렉션
		// ArrayList
		List<String> list = new ArrayList<String>();
		
		
		// add = 값 저장(list 객체 추가)
		list.add("java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"Database");
		list.add("iBATIS");
		
		// size 배열 길이(list 크기)
		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		System.out.println();
		
		// get 값 불러오기(list 객체 가져오기)
		String skill = list.get(2);
		System.out.println("2 : " + skill);
		System.out.println();
		
		// 향샹된 for문
//		for(String ele : list) {
//			System.out.println(ele);
//		}
//		System.out.println();
		
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		System.out.println();
		
		
		// remove = 삭제
		list.remove(2);
		list.remove(2);
		list.remove("iBATIS");
		
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		
	}
	
}
