package ShoppingMall;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GoodsDao extends DAO{

	public void select(Goods num) {
		getOpen();
		String sql = "select * from tbl_goods where goods_num=?";
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num.getGoodsNum());
			
			rs = pstmt.executeQuery();
			System.out.println("상품\t가격\t남은수량\t");
			while(rs.next()) {
				num.setGoodsNum(rs.getInt("goods_num"));
				num.setGoodsName(rs.getString("goods_name"));
				num.setGoodsPrice(rs.getInt("goods_price"));
				num.setGoodsCount(rs.getInt("goods_count"));
				
				System.out.printf("%s\t%d\t%d",num.getGoodsName(),num.getGoodsPrice(),num.getGoodsCount());
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public void selectAll() {
//		getOpen();
//		String sql = "select * from tbl_goods ";
//		Goods gd = new Goods();
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				gd.setGoodsNum(rs.getInt("goods_num"));
//				gd.setGoodsName(rs.getString("goods_name"));
//				gd.setGoodsPrice(rs.getInt("goods_price"));
//				gd.setGoodsCount(rs.getInt("goods_count"));
//				
//				System.out.println(gd);
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}



}
