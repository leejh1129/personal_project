package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UpdateMain {

	public static void main(String[] args) {
		
		// 연결하기
		Connection conn = null;
		
		try {
			// jdbc 등록
			Class.forName("oracle.jdbc.OracleDriver");
			//연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",	// url
					"java",	 // 계정
					"1234"); // 비밀번호
			System.out.println("연결성공");
			
			// 데이터 수정
			String sql = "" +
						"update boards " +
						"set btitle=?, bcontent=? " +
						"where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"btitle","bcontent"});
			pstmt.setString(1, "오늘점심은?");
			pstmt.setString(2, "오늘점심 메뉴 추천좀 점메추~");
			pstmt.setInt(3, 4);
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 갯수  : " + rows);
			
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					
					
//					String title = rs.getString(1);
//					String content = rs.getString(2);
//					System.out.println("변경된 title : " + title);
//					System.out.println("변경된 content : " + content);
					
				}
			}
			
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
