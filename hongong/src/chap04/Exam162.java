package chap04;

public class Exam162 {

	public static void main(String[] args) {
		
		// 주사위 2개를 던져서 합이 5가되면 종료 - game over
		// 5가 아니면 (1,3) 주사위 눈 표시
		// 몇번만에 나왔는지 체크

		// cnt를 while안에 쓰면 while이 실행 될때마다 0으로 초기화 되서 while 밖에서 선언해줘야됨
		int cnt = 0;
		while(true){			
			int num1 = (int)(Math.random() * 6) + 1;
			int num2 = (int)(Math.random() * 6) + 1;
			cnt++;
			
			System.out.printf("(%d,%d)\t", num1, num2);
			if(num1 + num2 == 5) {
				System.out.println("\n" + cnt + "번 game over");
				break;
			}
		}
		
		// 주사위 눈이 1이면 1등 ~ 6이면 6등이라고 출력
		int num = (int)(Math.random() * 6) + 1;
		
		// if문으로 주사위 눈이 1이면 1등 ~ 6이면 6등이라고 출력
		
		System.out.println("주사위 값 : " + num);
		
		if(num == 1) {
			System.out.println("1등");
		}else if(num == 2) {
			System.out.println("2등");
		}else if(num == 3) {
			System.out.println("3등");
		}else if(num == 4) {
			System.out.println("4등");
		}else if(num == 5) {
			System.out.println("5등");
		}else {
			System.out.println("6등");
		}
		
		
		// switch 주사위 눈이 1이면 1등 ~ 6이면 6등이라고 출력
		
		switch(num) {
		case 1:
			System.out.println("1등");
			break;
		case 2:
			System.out.println("2등");
			break;
		case 3:
			System.out.println("3등");
			break;
		case 4:
			System.out.println("4등");
			break;
		case 5:
			System.out.println("5등");
			break;
		default:
			System.out.println("6등");
			// break 걸어도 되고 안걸어도됨
			break;
		}
		
		System.out.println(num + "등");
		
		// 50에서 100까지 수를 발생
		// 90 이상이면 A, 80이상이면 B, 
		
		int num1 = (int)(Math.random() * 51) + 50;
		
		System.out.println("점수 : " + num1);
		
		switch(num1/10) {
		case 10:
		case 9:
			System.out.println("등급 : A");
			break;
		case 8 :
			System.out.println("등급 : B");
			break;
		case  7:
			System.out.println("등급 : C");
			break;
		case  6:
			System.out.println("등급 : D");
			break;
		default  :
			System.out.println("등급 : F");
			break;
		}
		
		
		

	}

}
