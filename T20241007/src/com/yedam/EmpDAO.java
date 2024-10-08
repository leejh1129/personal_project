package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO {

	Connection conn = null;
	ResultSet rs;
	Employee empl = new Employee();

	public void getOpen() {
		try {
			// jdbc 등록
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.14:1521:xe", // url
					"java", // 계정
					"1234"); // 비밀번호
//			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 2.연결끊기 메소드 : 메소드 (void)
	public void getClose() {
		if (conn != null) {
			try {
				conn.close();
//				System.out.println("연결끊기");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 추가
	public int insert(Employee emp) {
		getOpen();
		try {
			String sql = "insert into tbl_employee(employee_id, employee_name, phone, hire_date, salary) values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getEmployeeName());
			pstmt.setString(3, emp.getPhone());
			pstmt.setString(4, emp.getHireDate());
			pstmt.setInt(5, emp.getSalary());

			int rows = pstmt.executeUpdate();

			getClose();
			pstmt.close();
			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 수정
	public int update(Employee emp2) {
		getOpen();
		String sql = "update tbl_employee set salary=? " + "where employee_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp2.getSalary());
			pstmt.setString(2, emp2.getEmployeeId());
			int rows = pstmt.executeUpdate();

			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 삭제
	public int delete(Employee emp3) {
		getOpen();
		String sql = "delete from tbl_employee where employee_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp3.getEmployeeId());

			int rows = pstmt.executeUpdate();

			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 조회
	public void select(Employee emp4) {
		getOpen();
		String sql = "select employee_id, employee_name, to_char(hire_date,'YYYY-MM-DD')  from tbl_employee "
				+ "where hire_date >=?" + "order by hire_date";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp4.getHireDate());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				emp4.setEmployeeId(rs.getString(1));
				emp4.setEmployeeName(rs.getString(2));
				emp4.setHireDate(rs.getString(3));

				System.out.printf("%s\t%s\t%s\t", emp4.getEmployeeId(), emp4.getEmployeeName(), emp4.getHireDate());
				System.out.println();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectAll() {
		getOpen();
		String sql = "select employee_id, employee_name, phone " + "from tbl_employee";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				empl.setEmployeeId(rs.getString(1));
				empl.setEmployeeName(rs.getString(2));
				empl.setHireDate(rs.getString(3));
				;
				System.out.println("사번 \t 이름 \t 전화번호");
				System.out.printf("%s\t%s\t%s", empl.getEmployeeId(), empl.getEmployeeName(), empl.getHireDate());
				System.out.println();
			}
			getClose();
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
