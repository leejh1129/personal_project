package 통장관리;

import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		AccountDao dao = new AccountDao();

		while (run) {
			System.out.println("===========================================");
			System.out.println("| 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("===========================================");
			System.out.print("메뉴 선택 : ");
			int num = Integer.parseInt(sc.nextLine());

			switch (num) {
			case 1:
				System.out.println("--------");
				System.out.println("계좌생성");
				System.out.println("--------");
				System.out.print("계좌번호 : ");
				String ano = sc.nextLine();
				System.out.print("계좌주 : ");
				String owners = sc.nextLine();
				System.out.print("초기입금액 : ");
				int balance = Integer.parseInt(sc.nextLine());
				Account ac = new Account(ano,owners,balance);
				dao.insert(ac);
				break;
			case 2:
				System.out.println("--------");
				System.out.println("계좌목록");
				System.out.println("--------");
				dao.selectAll();
				break;
			case 3:
				System.out.println("--------");
				System.out.println("입금");
				System.out.println("--------");
				System.out.print("계좌번호 : ");
				ano = sc.nextLine();
				System.out.print("입금액 : ");
				int depositAmt = Integer.parseInt(sc.nextLine());
				Account ac2 = new Account(ano,depositAmt);
				dao.updatePlus(ac2);
				break;
			case 4:
				System.out.println("--------");
				System.out.println("출금");
				System.out.println("--------");
				System.out.print("계좌번호 : ");
				ano = sc.nextLine();
				System.out.print("출금액 : ");
				int withdrawAmt = Integer.parseInt(sc.nextLine());
				Account ac3 = new Account(ano,withdrawAmt);
				dao.updateMinus(ac3);
				break;
			case 5:
				run = false;
				System.out.println("프로그램을 종료합니다");
				break;
			default:
				System.out.println("잘못된 입력입니다. 다시 선택해주세요.");

			}

		}

	}

}
