package chap01;

import java.util.Scanner;

public class Scanner118 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String strin;
		
		// 문자열 입력
		System.out.print("문자열 입력 : ");
		strin = sc.nextLine();
		System.out.println("입력 받은 문자열 : " + strin);
		if(strin == "q") {
			System.out.println("q입력됨");
		}else {
			System.out.println("같지 않음");
		}
		// strin은 값이 저장되있는 주소값이라 else가 실행되는데
		// equals로 비교하면 값으로 비교함
		if(strin.equals("q")) {
			System.out.println("q입력됨");
		}else {
			System.out.println("같지않음");
		}
		
		// 숫자 입력
		System.out.print("숫자 입력 : ");
		int valInt = sc.nextInt();
		System.out.println("입력 받은 숫자 : " + valInt);
		// int로 입력받으면 공백이 생기는데 그걸 nextLine으로 한번 받아서 정상작동시킴
		strin = sc.nextLine();
		
		System.out.print("숫자 입력 : ");
		valInt = Integer.parseInt(sc.nextLine());
	    System.out.println("입력 받은 숫자 + 100 : " + (valInt + 100));
		// sc사용후 반납
		sc.close();

	}

}
