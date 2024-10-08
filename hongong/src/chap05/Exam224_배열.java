package chap05;

import java.util.Scanner;

public class Exam224_배열 {

	public static void main(String[] args) {
		
		// 확인문제 6번
		
		boolean run = true;
		int studentNum = 0;
		int [] scores = null;
		Scanner sc = new Scanner(System.in); 
		int sum = 0;
		int max = 0;
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택>");
			int selectNo = Integer.parseInt(sc.nextLine());			
			
			
			switch(selectNo) {
			case 1:
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(sc.nextLine());
				scores = new int[studentNum];
				break;
			case 2:
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("scores>[%d] ", i);
					int num = Integer.parseInt(sc.nextLine());
					scores[i] = num;
				}
				break;
			case 3:
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]> %d\n", i,scores[i]);
				}
				break;
			case 4:
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(max < scores[i]) {
						max = scores[i];
					}
				}
				double avg = (double)sum / scores.length;
				System.out.println("최고 점수 : " + max);
				System.out.println("평균 점수 : " + avg);
				break;
			case 5:
				run = false;
			}
			
		}
		
		System.out.println("프로그램 종료");
		
		sc.close();

	}

}
