package ShoppingMall;

import java.util.Scanner;

public class ShoppingMain {

	static Scanner sc = new Scanner(System.in);
	static boolean run = true;
	static Goods goods = new Goods();
	static User user = new User();
	static UserDao udao = new UserDao();
	public static void main(String[] args) {

		UserDao udao = new UserDao();
		User login = null;

		while(run) {
			System.out.println("======================");
			System.out.println("| 1.로그인 | 2.회원가입 |");
			System.out.println("======================");
			System.out.print("목록을 선택하세요>>");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				while (true) {
					System.out.print("아이디를 입력하세요>>");
					String id = sc.nextLine();
					System.out.print("비밀번호를 입력하세요>>");
					String pw = sc.nextLine();

					login = udao.checkUser(id, pw);
					if (login != null) {
						System.out.println(login.getUserName() + "님 환영합니다!!");
						break;
					}
					System.out.println("아이다 또는 비밀번호가 일치하지 않습니다");
				}
				if (login.getResponsibility().equals("User") || login.getResponsibility().equals(null)) {
					// 권한이 User 이면 상품구매 메서드 실행
					User();
				} else if (login.getResponsibility().equals("Admin")) {
					// 권한이 Admin 이면 상품관리 및 회원관리 메서드 실행
					Manager();
				}
				break;
			case 2:
				System.out.println("===================");
				System.out.println("     회원가입");
				System.out.println("===================");
				System.out.print("사용하실 아이디를 입력하세요>>");
				String joinId = sc.nextLine();
				System.out.print("사용하실 비밀번호를 입력하세요>>");
				String joinPw = sc.nextLine();
				System.out.println("사용하실 닉네임을 입력해하세요>>");
				String joinName = sc.nextLine();
				User join = new User(joinId, joinPw, joinName);
				
				if(join.getUserId().equals(join)) {
					System.out.println("사용중인 아이디입니다.");
				}else {					
					udao.insert(join);
				}
				
				break;
			} // end of 로그인,회원가입 switch
		}	// end of 로그인,회원가입 while
		

	} // end of amin

	public static void User() {
		GoodsDao gdao = new GoodsDao();
		while (run) {
			System.out.println("=============================================");
			System.out.println("| 1.맨투맨 | 2.후드티 | 3.니트 | 4.바지 | 5.종료 |");
			System.out.println("=============================================");
			System.out.print("카테고리를 선택해주세요>>");
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
//				while(run) {					
//					System.out.println("========================");
//					System.out.println("          맨투맨");
//					System.out.println("========================");
					goods = new Goods(num);
//					gdao.select(goods);
//					System.out.print("상세보기하고싶은 상품을 입력하세요>>");
//					String Man = sc.nextLine();
//					switch(Man) {
//					case :
//						break;
//					case 1:
//						break;
//					}
//				}
				break;
			case 2:
				System.out.println("========================");
				System.out.println("          후드티");
				System.out.println("========================");
				goods = new Goods(num);
				gdao.select(goods);
				break;
			case 3:
				System.out.println("========================");
				System.out.println("          니트");
				System.out.println("========================");
				goods = new Goods(num);
				gdao.select(goods);
				break;
			case 4:
				System.out.println("========================");
				System.out.println("          바지");
				System.out.println("========================");
				goods = new Goods(num);
				gdao.select(goods);
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("잘못입력하셧습니다.");
			}
		}
	}

	public static void Manager() {
		while (run) {
			System.out.println("==================================================================");
			System.out.println("| 1.회원목록조회 | 2.회원삭제 | 3.상품목록조회 | 4.상품등록 | 5.상품삭제 | 6.종료 |");
			System.out.println("==================================================================");
			System.out.print("목록을 선택하세요>>");
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				break;
			}
		}
	}

}
