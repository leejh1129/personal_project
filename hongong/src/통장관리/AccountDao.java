package 통장관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {

	Connection conn = null;
	Account ac = new Account();

	public void getOpen() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int insert(Account ac) {
		getOpen();
		try {
			String sql = "insert into account(ano,owners,balance) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareCall(sql);
			pstmt.setString(1, ac.getAno());
			pstmt.setString(2, ac.getOwners());
			pstmt.setInt(3, ac.getBalance());

			int rows = pstmt.executeUpdate();

			if (rows == 1) {
				System.out.println("계좌생성 성공!!");
			} else {
				System.out.println("계좌생성 실패 ㅠㅠ");
			}

			getClose();
			pstmt.close();
			return rows;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void selectAll() {
		getOpen();
		String sql = "select * from account";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ac.setAno(rs.getString(1));
				ac.setOwners(rs.getString(2));
				ac.setBalance(rs.getInt(3));

				System.out.println(ac);
			}
			getClose();
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int updatePlus(Account ac2) {
		getOpen();
		
		try {
			String sql = "" + "update account " + "set balance=?" + "where ano=?";
	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ac.getBalance() + ac2.getBalance());
			pstmt.setString(2, ac2.getAno());
			
			int rows = pstmt.executeUpdate();
			
			if(rows == 1) {
				System.out.println("계좌 : " + ac2.getAno() + "입금성공");
			}else {
				System.out.println(ac2.getAno() + "없는 계좌입니다");
			}
			
			pstmt.close();
			getClose();
			return rows;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int updateMinus(Account ac3) {
		getOpen();
		
		try {
			String sql = "" + "update account " + "set balance=?" + "where ano=?";
	
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ac.getBalance() - ac3.getBalance());
			pstmt.setString(2, ac3.getAno());
			
			int rows = pstmt.executeUpdate();
			
			if(rows == 1) {
				System.out.println("계좌 : " + ac3.getAno() + "출금성공");
			}else {
				System.out.println(ac3.getAno() + "없는 계좌입니다");
			}
			
			pstmt.close();
			getClose();
			return rows;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
