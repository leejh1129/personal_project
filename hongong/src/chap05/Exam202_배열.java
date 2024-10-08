package chap05;

import java.util.Arrays;

public class Exam202_배열 {

	public static void main(String[] args) {
		
		// Run => RunConfig...
//		int args1 = Integer.parseInt(args[2]);
//		System.out.println(args1 + 100);
		
		// 배열을 생성
		// 배열을 이용하는 방법
		
//		int [] scores = {83, 90, 87};
//		
//		System.out.println("scores[0] = " + scores[0]);
//		System.out.println("scores[1] = " + scores[1]);
//		System.out.println("scores[2] = " + scores[2]);
//		
//		int sum = 0;
//		for(int i = 0; i < scores.length; i++) {
//			sum += scores[i];
//		}
//		System.out.println("총합 : " + sum);
//		double avg = (double) sum / 3;
//		System.out.printf("평균 : %.6f", avg);
		
		// 배열에 1에서 100까지의 임의의 수 10개를 저장
		// 배열의 합과 최대값, 최소값을 구하세요
		// 배열생성
		// 배열 이용, 합, 평균, 최대, 최소값 구현
		
		// 배열 생성 후 랜덤수 집어 넣기
		int[] nums = new int[10];
//		int[] nums2 = {10,20,50,40};
		for(int i = 0; i < nums.length; i++) {
			int ran = (int)(Math.random() * 100) + 1;			
			nums[i] = ran;
		}
		
		System.out.println(nums);
		System.out.println(Arrays.toString(nums));
		
		// 배열 이용, 합, 평균, 최대, 최소값 구현
		int sum = 0;
		int max = nums[0];
//		int max = 0;
		int min = nums[0];
//		int min = 100;
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
			sum += nums[i];
			if(max < nums[i]) {
				max = nums[i];
			}
			if(min > nums[i]) {
				min = nums[i];
			}
		}
		
		double avg = (double)sum / nums.length;
		
		System.out.println();
		System.out.println("배열의 합 : " + sum);
		System.out.println("배열의 최대값 : " + max);
		System.out.println("배열의 최소값 : " + min);
		System.out.println("배열의 평균 : " + avg);
		
		System.out.printf("sum = %d , max = %d , min = %d, avg = %.1f", sum, max, min, avg);

		

	}

}
