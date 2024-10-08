package ShoppingMall;

import java.sql.SQLException;

public class UserDao extends DAO {

	User checkUser(String id, String pw) {
		String sql = "select user_name, responsibility from tbl_user " + "where user_id = ? and user_pw = ? ";
		getOpen();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			// count로 아이디 비밀번호를 체크해서 맞으면 1을반환 둘중한개라도 틀리면 0을 반환해줌
			if (rs.next()) {
				User us = new User();
				us.setUserName(rs.getString("user_name"));
				us.setResponsibility(rs.getNString("responsibility"));
				return us;
//				int cnt = rs.getInt(1);
//				if(cnt > 0) {// id, pw 정상적이면
//					return rs.getNString(1);
//				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insert(User join) {
		getOpen();
		String sql = "insert into tbl_user(user_id, user_pw, user_name) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, join.getUserId());
			pstmt.setString(2, join.getUserPw());
			pstmt.setString(3, join.getUserName());
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("회원가입이 완료되었습니다.");
			} else {
				System.out.println("회원가입에 실패하였습니다.");
			}
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
