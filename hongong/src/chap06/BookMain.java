package chap06;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		// null은 변수 초기화(배열주소 할당x, 값이 배열하고 연결이안됨)
		Book[] books = null;
		int bookCnt = 0;
		

		
		while(run) {
			System.out.println("==========================================================");
			System.out.println("| 1.도서 수 입력 | 2.도서 입력 | 3.도서목록 조회 | 4.도서분석 | 5.종료 |");
			System.out.println("==========================================================");
			System.out.print("메뉴 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {			
			case 1:
				System.out.print("도서 수를 입력하세요 : ");
				bookCnt = Integer.parseInt(sc.nextLine());
				// bookCnt에 입력받은 만큼 books에 배열크기 지정
				books = new Book[bookCnt];
				break;
			case 2:
				for(int i = 0; i < books.length; i ++) {	
					System.out.print((i+1) + "번째 아이디 입력하세요 : ");
					int bookId = Integer.parseInt(sc.nextLine());
					System.out.print((i+1) + "번째 제목 입력하세요 : ");
					String bookName = sc.nextLine();
					System.out.print((i+1) + "번째 가격 입력하세요 : ");
					int bookPrice = Integer.parseInt(sc.nextLine());
					
					// books[i] 번째 방 마다 bookID,bookName,bookPrice를 저장
					books[i] = new Book(bookId,bookName,bookPrice);
				}
				break;
			case 3:
				for(Book book : books) {
					System.out.printf("아이디 : %d, 제목 : %s, 가격 : %d \n", book.getBook_id(),book.getBook_name(),book.getBook_price());
				}
				break;
			case 4:
				int sum = 0;
				String title = null;
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				for(Book book : books) {
					int p = book.getBook_price();
					sum += p;
					if(max < p) {
						max = p;
						title = book.getBook_name();
					}
					if(min > p) {
						min = p;
					}
				}
				System.out.printf("합 : %d, 최대 가격 : %d, 최소 가격 : %d", sum,max,min);
				System.out.println();
				System.out.println("가장 비싼 책 : " + title);
				break;
			case 5:
				run = false;
				default:
					System.out.println("메뉴를 다시선택하세요");
			}
		}
		sc.close();

	}

}
