package chap05;

public class Exam214_2차원배열 {

	public static void main(String[] args) {
		
		// 2차원 배열
		int[][] scores = {
				{10,20,30},
				{40,50,60}
		};
		
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {				
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		for(int i = 0; i < scores.length; i++) {
			for(int j : scores[i]) {				
				System.out.print(j + "\t");
			}
			System.out.println();
		}
		
		
		// 2*3 배열을 선언하고
		// 1에서 10까지 무작위 수를 입력하세요
		// 같은 수 입력 가능
		
		int[][] nums = new int[2][3];
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				int num = (int)(Math.random() * 10) +1;
				nums[i][j] = num;
				System.out.print(nums[i][j] + "\t");
			}
			System.out.println();
		}
		
		// 향상된 for문
		int[] su = {10, 200, 30, 40, -50, 777, 555};
		// 배열의 합, 최대값, 최소값
		// 향상된 for문을 이용
		int sum = 0;
		int max = Integer.MIN_VALUE;	// int 값 중에 최소값
//		int max = 0;
		int min = Integer.MAX_VALUE;	// int 값 중에 최대값
//		int min = 0;
		for(int ele : su) {
			sum += ele;
			if(max < ele) {
				max = ele;
			}
			if(min > ele) {
				min = ele;
			}
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println("sum = " + sum);
		
		
	}
}
