package ShoppingMall;

import java.sql.SQLException;

public class ReviewDao extends DAO{

	public void insert(User login, String goodsNum ,String review) {
		getOpen();
		String sql = "insert into tbl_review (goods_num ,user_id ,review) values(upper(?),?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, login.getUserId());
			pstmt.setString(3, review);
			
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				System.out.println("리뷰등록 완료!!");
			}else {
				System.out.println("리뷰등록 실패 ㅠ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void select(String review) {
		getOpen();
		String sql = "select * from tbl_review where goods_num=upper(?) order by review_date desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review);
			
			Review rv = new Review();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rv.setGoodsNumFk(rs.getString("goods_num"));
				rv.setUserIdFk(rs.getString("user_id"));
				rv.setReview(rs.getString("review"));
				rv.setReviewDate(rs.getString("review_date"));
				
				System.out.printf("%s\t%s\t%s\t%s", rv.getUserIdFk() ,rv.getGoodsNumFk() ,rv.getReview() ,rv.getReviewDate());
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	


}
