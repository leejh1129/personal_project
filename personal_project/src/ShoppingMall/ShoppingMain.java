package ShoppingMall;

import java.util.Scanner;

public class ShoppingMain {

	static Scanner sc = new Scanner(System.in);
	static boolean run = true;
	static Goods goods = new Goods();
	static User user = new User();
	static UserDao udao = new UserDao();
	static User login = null;
	static GoodsDao gdao = new GoodsDao();

	public static void main(String[] args) {


			login :
			while (run) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                      | 1.로그인 | 2.회원가입 | 3.종료 |");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("목록을 선택하세요>>");
			int num = Integer.parseInt(sc.nextLine());

			switch (num) {
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
				if (login.getResponsibility().equals("User")) {
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
				System.out.print("사용하실 닉네임을 입력해하세요>>");
				String joinName = sc.nextLine();
				User join = new User(joinId, joinPw, joinName);
				udao.insert(join);

//				if(join.getUserId().equals(join)) {
//					System.out.println("사용중인 아이디입니다.");
//				}else {					
//				}

				break;
			case 3:
				run = false;
				break;
			default:
				System.out.println("잘못입력하셧습니다 다시 입력해주세요.");
			} // end of 로그인,회원가입 switch
		} // end of 로그인,회원가입 while

	} // end of amin

	public static void User() {
		user :
		while (run) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                                카테고리");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("    | 1.맨투맨 | 2.후드티 | 3.니트 | 4.바지 | 5.포인트확인 | 6.포인트충전 | 7.로그아웃 | ");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("카테고리를 선택해주세요>>");
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				category:
				while (run) {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("                                맨투맨");
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("                | 스톤아일랜드 | cp컴퍼니 | .... | ..... | .....|");
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("                | 1.브랜드별 묶어보기 | 2.리뷰보기 | 3.구매 | 4.카테고리 |");
					System.out.println("----------------------------------------------------------------------------");
					goods = new Goods(num);
					gdao.select(goods);
					System.out.print("메뉴를 선택하세요>>");
					num = Integer.parseInt(sc.nextLine());
					리뷰 :
					while(run) {
						switch(num) {
						case 1:
							System.out.print("묶어보고싶은 브랜드를 입력하세요>>");
							String view = sc.nextLine();
							switch(view) {
							case "스톤아일랜드":
								while(run) {		
									System.out.println("----------------------------------------------------------------------------");
									System.out.println("                                카테고리");
									System.out.println("----------------------------------------------------------------------------");
									System.out.println("----------------------------------------------------------------------------");
									System.out.println("                             | 1.되돌아가기 |");
									System.out.println("----------------------------------------------------------------------------");
									goods = new Goods(view);
									gdao.selectView(goods);
									System.out.print("메뉴를 선택하세요>>");
									num = Integer.parseInt(sc.nextLine());
									switch(num) {
									case 1:
										break category;
									}
								}
								break;
							case "cp컴퍼니":
								while(run) {			
									System.out.println("----------------------------------------------------------------------------");
									System.out.println("                                카테고리");
									System.out.println("----------------------------------------------------------------------------");
									System.out.println("----------------------------------------------------------------------------");
									System.out.println("                             | 1.되돌아가기 |");
									System.out.println("----------------------------------------------------------------------------");
									goods = new Goods(view);
									gdao.selectView(goods);
									System.out.print("메뉴를 선택하세요>>");
									num = Integer.parseInt(sc.nextLine());
									switch(num) {
									case 1:
										break category;
									}
								}
							default :
								System.out.println("잘못입력하셧습니다.");
							}
							break;
						case 2:
							// 상품번호 입력받아서 리뷰 구매수 표시
							System.out.print("리뷰확인하실 상품명을 입력하세요>>");
							String review = sc.nextLine();
							ReviewDao rdao = new ReviewDao();
							rdao.select(review);
							System.out.println();
							break category;
						case 3:
							System.out.print("구매하실 상품번호를 입력해주세요>>");
							String goodsNum = sc.nextLine();
							goods.setGoodsNum(goodsNum);
							// 구매확정을하면 포인트 확인 후 결제할수있으면 tbl_goods테이블에 count 하나 빼기
							// 옷 가격많큼 포인트 빼기
							구매:
							while(run) {
								System.out.println("----------------------------------------------------------------------------");
								System.out.println("                                구매");
								System.out.println("----------------------------------------------------------------------------");
								System.out.println("                     | 1.구매하기 | 3.되돌아가기 |");
								System.out.println("----------------------------------------------------------------------------");
								gdao.purchase(goods);
								System.out.print("메뉴를 입력하세요>>");
								num = Integer.parseInt(sc.nextLine());
								switch(num) {
								case 1:
									gdao.purchase(goods);
									System.out.print("구매수량을 입력하세요>>");
									num = Integer.parseInt(sc.nextLine());
									System.out.print("해당 상품을 구매하시겠습니까?? y : 구매 , n : 취소>>");
									String a = sc.nextLine();
									switch(a) {
									case "y":
										goods.setGoodsNum(goodsNum);
//										gdao.update(goods,num,login,udao.pointcheck(login));
										if(gdao.update(goods,num,login,udao.pointcheck(login)) == 1) {
											System.out.println("리뷰를 작성하세요>>");
											String reviewText = sc.nextLine();
											ReviewDao rv = new ReviewDao();
											rv.insert(login,goodsNum,reviewText);
										}
										break;
									case "n":
										break;
										default:
											System.out.println("잘못입력하셧습니다");
									}
									
								case 2:
									break 구매;
									default:
										System.out.println("잘못입력하셧습니다");
								}
								
							}
							
							System.out.println();
							break category;
						case 4:
							break category;
						}
					}
				}	// end of 카테고리 while
				break;
			case 2:
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                후드티");
				System.out.println("----------------------------------------------------------------------------");
				goods = new Goods(num);
				gdao.select(goods);
				break;
			case 3:
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                니트");
				System.out.println("----------------------------------------------------------------------------");
				goods = new Goods(num);
				gdao.select(goods);
				break;
			case 4:
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                바지");
				System.out.println("----------------------------------------------------------------------------");
				goods = new Goods(num);
				gdao.select(goods);
				break;
			case 5:
				// 포인트 확인
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                                포인트확인");
				System.out.println("----------------------------------------------------------------------------");
				udao.pointcheck(login);
				point :
				while(run) {
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("                       | 1.포인트충전하기 | 2.되돌아가기 |");
					System.out.println("----------------------------------------------------------------------------");
					System.out.print("메뉴를 입력하세요>>");
					num = Integer.parseInt(sc.nextLine());
					switch(num) {
					case 1:
						System.out.println("----------------------------------------------------------------------------");
						System.out.println("                              포인트충전");
						System.out.println("----------------------------------------------------------------------------");
						System.out.print("충전할 금액을 입력하세요>>");
						num = Integer.parseInt(sc.nextLine());
						udao.charge(num,login);
						break;
					case 2:
						break point;
					}
				}
				break;
			case 6:
				// 포인트 충전
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                              포인트충전");
				System.out.println("----------------------------------------------------------------------------");
				System.out.print("충전할 금액을 입력하세요>>");
				num = Integer.parseInt(sc.nextLine());
				udao.charge(num,login);
				break;
			case 7:
				break user;
			default:
				System.out.println("잘못입력하셧습니다.");
			}	//end of 맨투맨 switch
		}	//end of 전체 while
	}	//end of User()

	public static void Manager() {
		Manager:
		while (run) {
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("                                 관리자");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("     | 1.회원목록조회 | 2.회원삭제 | 3.상품목록조회 | 4.상품등록 | 5.상품삭제 | 6.로그아웃 |");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("목록을 선택하세요>>");
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                            회원목록조회");
				System.out.println("----------------------------------------------------------------------------");
				udao.selectAll();
				break;
			case 2:
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                            회원삭제");
				System.out.println("----------------------------------------------------------------------------");
				System.out.print("삭제하실 아이디를 입력하세요 : ");
				String deleteId = sc.nextLine();
				user.setUserId(deleteId);
				udao.UserDelete(user);
				break;
			case 3:
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                            상품목록조회");
				System.out.println("----------------------------------------------------------------------------");
				gdao.selectAll();
				break;
			case 4:
				// 상품등록
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                            상품등록");
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                            등록예시");
				System.out.println("----------------------------------------------------------------------------");
				System.out.print("상품번호를 입력하세요 (상품번호 : A브랜드약어_상품코드_사이즈색상)>>");
				String goodsNum = sc.nextLine();
				System.out.print("브랜드를 입력하세요 (브랜드명 : 스톤아일랜드,cp컴퍼니 ....)>>");
				String goodsBrand = sc.nextLine();
				System.out.print("카테고리를 입력하세요 (카테고리 : 맨투맨,후드티...)>>");
				String goodsCategory = sc.nextLine();
				System.out.print("카테고리번호를 입력하세요 (카테고리번호 : 1.맨투맨 2.후트티 3.니트 4.바지)>>");
				int goodsCategoryNum = Integer.parseInt(sc.nextLine());
				System.out.print("색상을 입력하세요 (색상 : 블랙,레드..)>>");
				String goodsColor = sc.nextLine();
				System.out.print("상품명을 입력하세요 (상품명 : 알렉산더맥퀸 그래픽 맨투맨...)>>");
				String goodsName = sc.nextLine();
				System.out.print("가격을 입력하세요>>");
				int goodsPrice = Integer.parseInt(sc.nextLine());
				System.out.print("수량을 입력하세요>>");
				int goodsCount = Integer.parseInt(sc.nextLine());
				System.out.print("사이즈를 입력하세요>>");
				int goodsSize = Integer.parseInt(sc.nextLine());
				goods = new Goods(goodsNum,goodsBrand,goodsCategory,goodsCategoryNum,goodsColor
						,goodsName,goodsPrice,goodsCount,goodsSize);
				gdao.insert(goods);
				break;
			case 5:
				//상품 삭제
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("                            상품삭제");
				System.out.println("----------------------------------------------------------------------------");
				System.out.println("삭제할 상품번호를 입력하세요>>");
				String goodsDelete = sc.nextLine();
				goods.setGoodsNum(goodsDelete);
				gdao.delete(goods);
				break;
			case 6:
				break Manager;
				default :
					System.out.println("잘못입력하셧습니다.");
			}
		}
	}

}
