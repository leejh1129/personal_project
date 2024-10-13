package ShoppingMall;

import java.sql.SQLException;

public class CartDao extends DAO{
	
	

	public void insert(String cartList ,User login) {
		getOpen();
		String sql = "insert into tbl_cart (?,?,?,?,?)";
		String selectPrice = "select goods_price, goods_name, goods_count from tbl_goods where goods_num =?";
		try {
			pstmt = conn.prepareStatement(selectPrice);
			pstmt.setString(1, cartList);
			
			rs = pstmt.executeQuery();
			
			
			
//			System.out.println(rs.getString("goods_name")+rs.getInt("goods_price")+rs.getInt("goods_count"));
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			pstmt.setString(2, cartList);
			pstmt.setString(3, rs.getString("goods_name"));
			pstmt.setInt(4, rs.getInt("goods_price"));
			pstmt.setInt(5, rs.getInt("goods_count"));
			
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				System.out.println("장바구니 추가완료");
			}else {
				System.out.println("장바구니 추가실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void select(String view) {
		getOpen();
		String sql = "select goods_color, goods_name, goods_price, goods_brand, goods_num from tbl_goods where goods_brand=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, view);
			
			rs = pstmt.executeQuery();
			Goods goods = new Goods();
			while(rs.next()) {
				
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsPrice(rs.getInt("goods_price"));
				goods.setGoodsColor(rs.getString("goods_color"));
				goods.setGoodsBrand(rs.getString("goods_brand"));
				goods.setGoodsNum(rs.getNString("goods_num"));
				
				System.out.printf("%s\t%s\t%s\t%d\t%s", goods.getGoodsNum(), goods.getGoodsBrand(), goods.getGoodsName(),
						goods.getGoodsPrice(), goods.getGoodsColor());
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}


	public void selectId(User login) {
		getOpen();
		String sql = "select * from tbl_cart where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserId());
			
			rs = pstmt.executeQuery();
			Cart cart = new Cart();
			while(rs.next()) {
				cart.setGoodsNum(rs.getString("goods_num"));
				cart.setCartName(rs.getString("cart_name"));
				cart.setCartPrice(rs.getInt("cart_price"));
				cart.setCaryCount(rs.getInt("cart_count"));
				
				System.out.printf("상품번호 : %s\t 상품명 : %s\t 가격 : %d\t 수량 : %d",cart.getGoodsNum() ,cart.getCartName() ,cart.getCartPrice() ,cart.getCaryCount());
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update() {
		getOpen();
		String sql = "update tbl_goods set goods_count=? where goods_num=upper(?)";
		String select = "select * from tbl_cart";
		
		try {
			pstmt = conn.prepareStatement(select);
			
			Cart cart = new Cart();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cart.setUserId(rs.getString("user_id"));
				cart.setGoodsNum(rs.getString("goods_num"));
				cart.setCartName(rs.getString("cart_name"));
				cart.setCartPrice(rs.getInt("cart_price"));
				cart.setCaryCount(rs.getInt("cart_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	
	
}
