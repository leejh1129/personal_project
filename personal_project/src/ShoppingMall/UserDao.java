package ShoppingMall;

import java.sql.SQLException;

public class UserDao extends DAO {

	
	User checkUser(String id, String pw) {
		User us = new User();
		String sql = "select user_id, user_name, responsibility from tbl_user " + "where user_id = ? and user_pw = ? ";
		getOpen();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();
			// count로 아이디 비밀번호를 체크해서 맞으면 1을반환 둘중한개라도 틀리면 0을 반환해줌
			if (rs.next()) {
				us.setUserId(rs.getString("user_id"));
				us.setUserName(rs.getString("user_name"));
				us.setResponsibility(rs.getNString("responsibility"));
				getClose();
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
	}	//end checkUser

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
			getClose();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}	//end of insert

	public void pointcheck(User login) {
		getOpen();
		String sql = "select asset from tbl_user where user_id =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				login.setAsset(rs.getInt("asset"));
				System.out.printf("%s 님의 현재 포인트 : %d ",login.getUserName(),login.getAsset());
				System.out.println();
			}
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	// end of pointcheck

	public User charge(int num ,User login) {
		getOpen();
		String sql = "update tbl_user "
					+"set asset=? "
					+"where user_id =? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (num+login.getAsset()));
			pstmt.setString(2, login.getUserId());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				login.setAsset(rs.getInt("asset"));
				
				System.out.printf("%s님 충전금액 : %d",login.getUserName(),login.getAsset());
				System.out.println();
				System.out.printf("%s님 충전완료금액 : %d",login.getUserName(),login.getAsset());
			}
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void selectAll() {
		getOpen();
		String sql = "select * from tbl_user";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User us = new User();
				us.setUserId(rs.getString("user_id"));
				us.setUserPw(rs.getString("user_pw"));
				us.setUserName(rs.getString("user_name"));
				us.setResponsibility(rs.getString("responsibility"));
				us.setAsset(rs.getInt("asset"));
				
				System.out.println(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UserDelete(User user) {
		getOpen();
		String sql = "delete from tbl_user where user_id =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			
//			int rows = pstmt.executeUpdate();
			System.out.println("삭제완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



}
