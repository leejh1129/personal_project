package chap01;

import java.util.Scanner;

public class Exam120 {

	public static void main(String[] args) {

		// 문제 1번 : 출력문 연습
		String name = "김자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		System.out.println("이름 : " + name);
		System.out.print("나이 : " + age + "\n");
		System.out.printf("전화 : %s - %s - %s",tel1, tel2,tel3);
		
		// 문제 2번 : 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("첫 번째 수 : ");
		String strNum1 = scanner.nextLine();
		
		System.out.println("두 번째 수 : ");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과 : " + result);
		
		// 문제 3번
		System.out.println("이름을 입력하세요 : ");
		String str1 = scanner.nextLine();
		System.out.println("주민번호 앞 6자리를 입력하세요 : ");
		String str2 = scanner.nextLine();
		System.out.println("전화번호를 입력하세요 : ");
		String str3 = scanner.nextLine();
		
		System.out.println("이름 : " + str1);
		System.out.println("주민번호 앞 6자리 : " + str2);
		System.out.println("전화번호 : " + str3);
		
		

	}

}
