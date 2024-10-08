package 이주현;

import java.util.Scanner;

public class Doself {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1.번 윤년 계산 프로그램
//		System.out.println("##년도 입력");
//		int year = Integer.parseInt(sc.nextLine());
//		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
//			System.out.println(year + "년은 윤년입니다.");
//		}else {
//			System.out.println(year + "년은 평년입니다.");
//		}
		
		// 2.번 동전 계산 프로그램
//		System.out.println("교환할 금액 입력 : ");
//		int money = Integer.parseInt(sc.nextLine());
//		int coin = money;
//		System.out.println("##교환할 금액 : " + coin);	
//		System.out.println("500원 짜리 : " +  coin / 500);
//		coin = money % 500;
//		System.out.println("100원 짜리 : " + coin / 100);	
//		coin = money % 100;
//		System.out.println("50원 짜리 : " + coin / 50);
//		coin = money % 50;
//		System.out.println("10원 짜리 : " + coin / 10);
//		coin = money % 10;
//		System.out.println("교환 금액 : " + (money-coin));
//		System.out.println("남은 금액 : " + coin);
		

		
		// 3.번 숫자 추측 게임
//		int ran = (int)(Math.random() * 100) + 1;
//		while(true) {			
//			System.out.println("숫자 입력 : ");
//			int su = Integer.parseInt(sc.nextLine());
//			if(su > ran) {
//				System.out.println("down하세요!!");
//			}else if(su < ran) {
//				System.out.println("up하세요!!");
//			}else {
//				System.out.println("축하합니다!!");
//				break;
//			}
//		}
		
		
		// 4.번 구구단 프로그램
//		for(int i = 2; i <= 9; i++) {
//			System.out.print("=====" + i +"단" + "==== \t");
//		}
//		System.out.println();
//		for(int j = 1; j <= 9; j++) {
//			for(int z = 2; z <= 9; z++) {
//				System.out.printf("%d X %d = %2d \t", z, j , z*j);
//			}
//			System.out.println("");
//		}
		
		
		// 5.번 섭씨-화씨 온도 변환 프로그램
//		boolean run = true; 
//		while(run) {			
//			System.out.println("-----------");
//			System.out.println("화씨 => 섭씨");
//			System.out.println("섭씨 => 화씨");
//			System.out.println("종료");
//			System.out.println("-----------");
//			System.out.println("번호 선택 : ");
//			int num = Integer.parseInt(sc.nextLine());
//			switch(num){
//			case 1:
//				System.out.println("섭씨온도 입력 : ");
//				double temperature = Double.parseDouble(sc.nextLine());
//				temperature = (double)5/9*(temperature-32);
//				System.out.println("섭씨온도 = " + temperature);
//				break;
//			case 2:
//				System.out.println("화씨온도 입력 : ");
//				temperature = Double.parseDouble(sc.nextLine());
//				temperature = (double)9/5*temperature+32;
//				System.out.println("화씨온도" + temperature);
//				break;
//			case 3:
//				run = false;
//				break;
//				default:
//					
//			}
//		}
//		System.out.println("program end");
		
		
		
		// 6.번 가위바위보 게임 프로그램
		int com = 0;
		int human = 0;
		while(true) {
			int ran = (int)(Math.random() * 3);
			String cnt = ""; 
			System.out.print("## 가위(0) 바위(1) 보(2) : ");
			int game = Integer.parseInt(sc.nextLine());

			if(game - ran == -2 || game - ran == 1) {
				human++;
				System.out.printf("사람 (%d), 컴 (%d) 사람 승리 \n", human, com);
			}else if(game == ran){
				System.out.printf("사람 (%d), 컴 (%d) 비겼음 \n", human, com);
			}else if(ran - game == -2 || ran - game == 1) {
				com++;
				System.out.printf("사람 (%d), 컴 (%d) 컴 승리 \n", human, com);
			}else if(game >= 3){
				System.out.println("game over");
				break;
			}
		}
		
		
		
		
		// 7.번 3,6,9게임 프로그램
		
//		for(int i = 1; i <= 50; i++) {
//			if(i % 10 == 3 | i % 10== 6 | i % 10 == 9) {
//				if(i / 10 == 3) {
//					System.out.print("♥♥\t");
//				}else {
//					System.out.print("♥\t");
//				}
//			}else if(i / 10 == 3) {
//				System.out.print("♥\t");
//			}else {			
//				System.out.print(i + "\t");
//			}
//			if(i % 10 == 0) {
//				System.out.println();
//			}
//		}
		
		sc.close();
		
	}

}
