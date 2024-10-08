package chap04;

import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
		
		// 2번
		// 3번
		while(true) {
			int num1 = (int)(Math.random() * 6) + 1;
			int num2 = (int)(Math.random() * 6) + 1;
			System.out.println(num1 + "," + num2);
			if(num1 + num2 == 5) {
				break;
			}
		}
		
		// 4번
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				if((4*i)+(5*j) == 60) {
					System.out.printf("(%d,%d) ", i, j);
				}
			}
		}
		System.out.println();
		
		// 5번
		System.out.println("*");
		System.out.println("**");
		System.out.println("***");
		System.out.println("****");
		
		String stars = "";
		for(int i = 1; i < 5; i++) {
			stars += "*";
			System.out.println(stars);
		}
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("   *");
		System.out.println("  **");
		System.out.println(" ***");
		System.out.println("****");
		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4-i; j++) {
				System.out.print(" ");
			}
			for(int z = 1; z <= i; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		String b = ""; 
		for(int i = 1; i <= 4; i++) {
			b += "*";
			for(int j = 1; j <= 4-i; j++) {
				System.out.print(" ");
			}
			System.out.print(b);
			System.out.println();
		}
		
		String str = "";
		for(int i = 1; i < 5; i++) {
			str += "*";
			System.out.printf("%4s\n",str);
		}
		
		
		// 7번 
//		boolean run = true;
//		int balance = 0;
//		Scanner sc = new Scanner(System.in);
//		
//		while(run) {
//			System.out.println("-----------------------------");
//			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
//			System.out.println("-----------------------------");
//			System.out.println("선택>");
//			int num1 = sc.nextInt();
//			if(num1 == 1) {
//				System.out.println("예금액>");
//			}else if(num1 == 2) {
//				System.out.println("출금액>");
//			}else if(num1 == 3) {
//				System.out.println("잔고>");
//			}else {
//				break;
//			}
//			int num2 = sc.nextInt();
//		}
//		System.out.println("프로그램 종료");
		
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.println("선택>");
			int selNo = Integer.parseInt(sc.nextLine());
			switch(selNo) {
			case 1:
				System.out.println("예금액>");
				int money = Integer.parseInt(sc.nextLine());
				balance += money;
				break;
			case 2:
				System.out.println("출금액>");
				money = Integer.parseInt(sc.nextLine());
				if(balance < money) {
					System.out.println("출금 불가");
					System.out.println("출금가능한 액수 : " + balance);
				}else {					
					balance -= money;
				}
				break;
			case 3:
				System.out.println("잔고>");
				System.out.println(balance);
				break;
			case 4:
				 run = false;
				 break;
				default:
					System.out.println("선택이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램 종료");
		
		sc.close();

	}

}
