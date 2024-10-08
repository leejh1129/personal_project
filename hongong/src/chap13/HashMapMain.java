package chap13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
	public static void main(String[] args) {
		
		// map : 키(key)와 벨류(value)로 구성된 entry 저장
		Map<String , Integer> map = new HashMap<>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		
		// map 크기
		System.out.println("전체 읽어오기 ------------------------------------");
		System.out.println("총 Entry수 : " + map.size());
		
		// 객체 찾기
		System.out.println("홍길동 : " + map.get("홍길동"));
		
		// 객체를 하나씩 처리
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		// 객체 삭제
		map.remove("홍길동");
		
		
		// 객체를 하나씩 처리
		System.out.println("전체 읽어오기 ------------------------------------");
		System.out.println("총 Entry수 : " + map.size());
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//		var entrySet = map.entrySet();
		
		for(var entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		map.clear();
		
		System.out.println("총 Entry수 : " + map.size());
		
		
		
		
		
	}
}
