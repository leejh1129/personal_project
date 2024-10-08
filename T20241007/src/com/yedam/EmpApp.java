package com.yedam;

import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		EmpDAO dao = new EmpDAO();
		int cnt = 0;
		while(run) {
			System.out.println("=============================================================");
			System.out.println("| 1.등록 | 2.목록 | 3.수정(급여) | 4.삭제 | 5.조회(조건:입사일자) | 6.종료");
			System.out.println("=============================================================");
			System.out.print("목록 선택>>");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				System.out.println("============");
				System.out.println("   사원생성");
				System.out.println("============");
				System.out.print("사번입력>>");
				String employeeId = sc.nextLine();
				System.out.println("이름입력>>");
				String employeeName = sc.nextLine();
				System.out.println("전화번호입력>>");
				String phone = sc.nextLine();
				System.out.println("입사일입력");
				String hireDate = sc.nextLine();
				System.out.println("급여입력");
				int salary = Integer.parseInt(sc.nextLine());
				
				Employee emp = new Employee(employeeId,employeeName,phone,hireDate,salary);
				cnt = dao.insert(emp);
				
				if (cnt == 1) {
					System.out.println("사원생성 성공");
				} else {
					System.out.println("사원생성 실패");
				}
				
				break;
			case 2:
				System.out.println("============");
				System.out.println("   사원조회");
				System.out.println("============");
				dao.selectAll();
				break;
			case 3:
				System.out.println("============");
				System.out.println("   급여수정");
				System.out.println("============");
				System.out.print("사번을입력하세요>>");
				employeeId = sc.nextLine();
				System.out.print("변경할 급여를 입력하세요>>");
				salary = Integer.parseInt(sc.nextLine());
				Employee emp2 = new Employee(employeeId,salary);
				cnt = dao.update(emp2);
				if (cnt == 1) {
					System.out.println("급여수정 성공");
				} else {
					System.out.println("급여수정 실패");
				}
				break;
			case 4:
				System.out.println("============");
				System.out.println("   사원삭제");
				System.out.println("============");
				System.out.print("사원번호를 입력하세요>>");
				employeeId = sc.nextLine();
				Employee emp3 = new Employee(employeeId);
				cnt = dao.delete(emp3);
				if(cnt == 1) {
					System.out.println("삭제성공");
				}else {
					System.out.println("없는 사원번호입니다");
				}
				break;
			case 5:
				System.out.println("============");
				System.out.println("   조건조회");
				System.out.println("============");
				System.out.print("입사일을 입력하세요>>");
				hireDate = sc.nextLine();
				Employee emp4 = new Employee();
				emp4.setHireDate(hireDate);
				dao.select(emp4);
				break;
			case 6:
				run = false;
				break;
				default:
					System.out.println("잘못입력하셧습니다.");
				
			}
			
		}
		
		sc.close();
	}
	
}
