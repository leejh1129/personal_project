package 이주현;

import java.util.Scanner;

public class bankApp {

	 public static void main(String[] args) {
		
		 boolean run = true;
		 Scanner sc = new Scanner(System.in); 
		 Account[] accounts = new Account[100];
		 int asCnt = 0;
		 
		 while(run) {			 
			 System.out.println("---------------------------------------------");
			 System.out.println("| 1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 |");
			 System.out.println("---------------------------------------------");
			 System.out.print("메뉴 선택 : ");
			 int num = Integer.parseInt(sc.nextLine());
			 
			 switch(num) {
			 case 1:
				 System.out.println("--------");
				 System.out.println("계좌생성");
				 System.out.println("--------");
				 System.out.print("계좌번호 : ");
				 String ano = sc.nextLine();
				 System.out.print("계좌주 : ");
				 String owner = sc.nextLine();
				 System.out.print("초기입금액 : ");
				 int balance = Integer.parseInt(sc.nextLine());
				 
				 accounts[asCnt] = new Account(ano, owner, balance);
				 asCnt++;
				 
				 
				 break;
			 case 2:
				 System.out.println("--------");
				 System.out.println("계좌목록");
				 System.out.println("--------");
				 for(Account ac : accounts) {
					 if(ac != null) {						 
						 System.out.printf("%s %s %d \n", ac.getAno(), ac.getOwner(), ac.getBalance());
					 }
				 }
				 break;
			 case 3:
				 System.out.println("--------");
                 System.out.println("입금");
                 System.out.println("--------");
                 System.out.print("계좌번호 : ");
                 ano = sc.nextLine();
                 System.out.print("입금액 : ");
                 int depositAmt = Integer.parseInt(sc.nextLine());
                 
				Account Check = Account.acCheck(accounts, ano);

                 if(Check != null) {
                	 Check.setBalance(Check.getBalance() + depositAmt);
                	 System.out.println("입금이 완료되었습니다.");
                 }else {
                	 System.out.println("계좌가 존재하지 않습니다.");
                 }
				 
                 break;
                 
			 case 4:
				 System.out.println("--------");
                 System.out.println("출금");
                 System.out.println("--------");
                 System.out.print("계좌번호 : ");
                 ano = sc.nextLine();
                 System.out.print("출금액 : ");
                 int withdrawAmt = Integer.parseInt(sc.nextLine());

                 Account Check2 = Account.acCheck(accounts, ano);
                 
                 if(Check2 != null) {
                	 Check2.setBalance(Check2.getBalance() - withdrawAmt);
                	 System.out.println("출금이 완료되었습니다.");
                 }else {
                	 System.out.println("계좌가 존재하지 않습니다.");
                 }
                 break;
			 case 5:
				 run = false;
				 System.out.println("프로그램을 종료합니다.");
			 default:
                 System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                 break;
			 }
		 }
		 
		 sc.close();
	}
	
}
