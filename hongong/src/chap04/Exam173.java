package chap04;

public class Exam173 {

	public static void main(String[] args) {
		
		// 50에서 100까지 3의 배수 합 구하기
		// 3의 배수 출력, 마지막에 3의 배수합 출력
		// 3의 배수 갯수
		int cnt = 0;
		int sum = 0;
		for(int i = 50; i <= 100; i++) {
			if(i % 3 == 0) {	
				System.out.print(i+" ");
				sum += i;
				cnt++;
			}
		}
		System.out.println("\n합:"+sum);
		System.out.println("3의 배수 갯수 : "+cnt);
		
		// 1에서 n 까지의 합이 300이 넘는 순간 n값 구하기
		// 7의 배수의 합이 300이 넘는 순간의 7의 배수 찾기
		
		int su = 0;
		sum = 0;
		while(sum < 300) {
			su += 7;
			sum += su;
		}
		System.out.println("7의 배수 = " + su);
		System.out.println("7의 배수 합 = " + sum);
		
		
		
//		while(true) {
//			su++;
//			if(su % 7 == 0) {
//				sum += su;
//				if(sum >= 300) {
//					break;
//				}
//			}
//		}
//		System.out.println("7의 배수 : " + su);
//		System.out.print("7의배수 합 : " + sum + " ");

		// 구구단 : 중첩 for
		
		for(int i = 2; i <= 9; i++) {
			System.out.println("=== " + i + " 단 ===");
			for(int j = 1; j <=9; j++) {
				System.err.printf("%d X %d = %2d ", i, j , i*j);
				System.out.println(i + " X " + j + " = " + i*j);
			}
		}
		
		
		
		//
		for(int i = 2; i <= 9; i++) {
			System.out.print("=====" + i +"단" + "==== \t");
		}
		System.out.println();
		for(int j = 1; j <= 9; j++) {
			for(int z = 2; z <= 9; z++) {
				System.out.printf("%d X %d = %2d \t", z, j , z*j);
			}
			System.out.println("");
		}
		
		
	}
}
