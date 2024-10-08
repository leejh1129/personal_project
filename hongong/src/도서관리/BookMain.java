package 도서관리;

import java.util.List;
import java.util.Scanner;

public class BookMain {
	
	static Scanner sc = new Scanner(System.in);
	static MemberDao mdao = MemberDao.getInstance();
	
	public static void main(String[] args) {
		// 도서관리
		// 메인메뉴

		// 선택2번 : 도서검색 => 책제목으로 검색
		// 선택3번 : 도서전체 조회
		// 선택4번 : 도서삭제
		// 선택5번 : 도서 정보 변경
		// 책제목, 변경할 책번호, 변경할 책 가격 입력
		// 선택6번 : 프로그램 종료
		
		
		Member member = null;
		
		// 로그인 체크
		while(true) {			
			System.out.print("아이디를 입력하세요>>");
			String id = sc.nextLine();
			System.out.print("비밀번호를 입력하세요>>");
			String pw = sc.nextLine();
			
			// 정상적인 로그인되면 member_name 출력 환영메시지
			member = mdao.checkMember(id, pw);
			if(member != null) {
				System.out.println("로그인성공!");
				System.out.println(member.getMemberName() + "님 환영합니다!!");
				break;
			}
			System.out.println("아이디와 비밀번호를 확인하세요!!");
		}	// end of 로그인체크
		
		
		
		if(member.getResponsibility().equals("User")) {
			// 권한이 User => 도서관리 처리
			bookManage();
		}else if(member.getResponsibility().equals("Admin")) {
			// 권한이 Admin => 회원관리 처리
			memberManage();
		}
		

	}	// end of main
	
	static void bookManage() {	// 도서 관리
		
		BookDao dao = new BookDao();
		
		boolean run = true;
		while (run) {
			System.out.println("=========================================================================");
			System.out.println("| 1.도서등록 | 2.도서검색 | 3.도서전체 조회 | 4.도서삭제 | 5.도서정보변경 | 6.회원목록 | 7.프로그램 종료 |");
			System.out.println("=========================================================================");
			System.out.print("목록 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch (num) {
			case 1:
				System.out.println("도서등록");
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("저자 : ");
				String writer = sc.nextLine();
				System.out.print("가격 : ");
				int price = Integer.parseInt(sc.nextLine());
				System.out.print("책 번호 : ");
				String bnum = sc.nextLine();
				Book book = new Book(title, writer, price, bnum);
				dao.insert(book);
				
				break;
				
			case 2:
				System.out.println("도서 조회(조건)");
				System.out.print("도서 제목을 입력하세요 > ");
				title = sc.nextLine();
				Book book2 = new Book(title);
				dao.select(book2);
				break;
			case 3:
				System.out.println("도서 조회(전체)");
				dao.selectAll();
				break;
			case 4:
				System.out.println("도서삭제");
				System.out.print("도서 번호를 입력하세요 >");
				bnum = sc.nextLine();
				Book book3 = new Book();
				book3.setBnum(bnum);
				dao.delete(book3);
				break;
			case 5:
				System.out.println("도서정보 변경");
				System.out.print("도서 제목을 입력하세요 : ");
				title = sc.nextLine();
				System.out.println("변경할 가격과 책번호를 입력하세요");
				System.out.println("변경할 가격 : ");
				price = Integer.parseInt(sc.nextLine());
				System.out.println("변경할 책번호 : ");
				bnum = sc.nextLine();
				Book book4 = new Book(title,price,bnum);
				dao.update(book4);
				
				break;
			
			case 7:
				run = false;
				sc.close();
				break;
			default:
			}	// end of switch
		}	// end of while
	}	// end of bookManage
	
	static void memberManage() {	// 회원관리
		boolean run = true;
		System.out.println("관리자 메뉴입니다");
		while(run) {	
			System.out.println("============================");
			System.out.println("| 1.회원목록조회 | 2.회원목록조회(조건) | 3.회원정보변경 | 4.회원삭제 | 5.종료 |");
			System.out.println("============================");
			System.out.print("목록선택>>");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {		
			case 1:
				//회원목록 출력
				List<Member> list = mdao.memberList();
				System.out.println("=====================================");
				System.out.println("	회원목록");
				System.out.println("=====================================");
				for(Member member : list) {
					System.out.println(member.toString());
				}
				break;
			case 2:
				System.out.println("===================");
				System.out.println("	회원목록(조건)");
				System.out.println("===================");
				System.out.print("조회할 ID를 입력하세요 >>");
				String id = sc.nextLine();
				Member mb = new Member(id);
				mdao.select(mb);
				break;
			case 3:
				System.out.println("===================");
				System.out.println("	정보변경");
				System.out.println("===================");
				System.out.print("변경할 ID를 입력하세요");
				id = sc.nextLine();
				System.out.print("변경할 이름을 입력하세요> ");
				String name = sc.nextLine();
				
				Member mb2 = new Member(id,name);
				mdao.update(mb2);
				break;
			case 4:
				System.out.println("===================");
				System.out.println("	아이디 삭제");
				System.out.println("===================");
				System.out.print("삭제할 ID를 입력하세요");
				id = sc.nextLine();
				
				Member mb3 = new Member(id);
				mdao.delete(mb3);
				
				break;
			case 5:
				run = false;
				break;
				default:
					System.out.println("잘못입력하셧습니다 다시입력해주세요.");
			}
		}
	}	// end of memberManage

}
