package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {

	public static void main(String[] args) {
		
		// 연결
		Connection conn = null;
		
		// jdbc 연결
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "1234");
			System.out.println("연결 성공");
			
			// 데이터 조회
			String sql = "select * from boards where bwriter=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "글쓴이4");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {				
				Board bd = new Board();
				bd.setBno(rs.getInt(1));
				bd.setBtitle(rs.getString(2));
				bd.setBcontent(rs.getString(3));
				bd.setBwriter(rs.getString(4));
				bd.setBdate(rs.getDate(5));
				
				System.out.println(bd);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
