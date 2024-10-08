package 도서관리;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 목록(조회조건), 등록, 수정, 삭제, 단건.
public class MemberDao extends DAO{

	// 싱글톤 방식
	private static MemberDao instance = new MemberDao();
	public MemberDao() {}
	public MemberDao(String id) {
		
	}
	public static MemberDao getInstance() {
		return instance;
	}
	
	// Connection, getOpen, getClose
	// 아이디와 비밀번호 확인해서 true 반환 / false 반환. -> 회원이름 반환 -> 권한추가
	// 클래스타입으로 반환하면 여려개 담아서 반환해줄수있음
	Member checkMember(String id, String pw) {
		String sql = "select member_name, responsibility from tbl_member "
				+ 	 "where member_id = ? and password = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			// count로 아이디 비밀번호를 체크해서 맞으면 1을반환 둘중한개라도 틀리면 0을 반환해줌
			if(rs.next()) {
				Member member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setResponsibility(rs.getNString("responsibility"));
				return member;
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
	
	// 목록조회.
	List<Member> memberList(){
		String sql = "select member_id"//
				+ "         ,member_name"//
				+ "         ,password"//
				+ "         ,phone"//
				+ "         ,responsibility"//
				+ "         ,creation_date"//
				+ "   from tbl_member ";
		List<Member> result = new ArrayList<>();
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 조회
			//rs.next() = 
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				result.add(member);
//				getClose();
//				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	} // end of memberList()
	
	public void select(Member mb) {
		String sql = "select * from tbl_member where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mb.getMemberId());
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				System.out.println(member);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int update(Member mb2) {
		String sql = "update tbl_member set member_name=?, phone=? where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mb2.getMemberName());
			psmt.setString(2, mb2.getPhone());
			psmt.setString(3, mb2.getMemberId());
			int rows = psmt.executeUpdate();
			if(rows == 1) {
				System.out.println("변경성공");
			}else {
				System.out.println("없는 ID입니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int delete(Member mb3) {
		String sql = "delete from tbl_member where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mb3.getMemberId());
			
			int rows = psmt.executeUpdate();
			if(rows == 1) {
				System.out.println("삭제성공");
			}else {
				System.out.println("없는 ID입니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
