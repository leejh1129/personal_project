package ShoppingMall;

import java.sql.SQLException;

public class CartDao extends DAO{

	public void insert(String cartList ,User login) {
		getOpen();
		String sql = "insert into tbl_cart (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			pstmt.setString(2, cartList);
			pstmt.setString(3, sql);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	
	
}
