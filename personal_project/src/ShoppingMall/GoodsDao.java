package ShoppingMall;

import java.sql.SQLException;

public class GoodsDao extends DAO{

	public void select(Goods num) {
		getOpen();
		String sql = "select distinct goods_color,"
				+ "        goods_name,"
				+ "        goods_price, "
				+ "        goods_brand, "
				+ "        goods_num "
				+ "from tbl_goods where goods_categorynum=?";
		 try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num.getGoodsCategoryNum());
			
			rs = pstmt.executeQuery();
			System.out.println("상품번호\t\t상품\t\t가격\t\t남은수량\t\t사이즈");
			while(rs.next()) {
				num.setGoodsName(rs.getString("goods_name"));
				num.setGoodsPrice(rs.getInt("goods_price"));
				num.setGoodsColor(rs.getString("goods_color"));
				num.setGoodsBrand(rs.getString("goods_brand"));
				num.setGoodsNum(rs.getNString("goods_num"));
				
				System.out.printf("%s\t%s\t%s\t%d\t%s",num.getGoodsNum(),num.getGoodsBrand(),num.getGoodsName(),num.getGoodsPrice(),num.getGoodsColor());
				System.out.println();
			}
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 getClose();
	}

	public void selectView(Goods goods) {
		getOpen();
		String sql = "select  goods_name, "
				+ "        		goods_price, "
				+ "        		goods_count, "
				+ "        		goods_size, "
				+ "        		goods_color, "
				+ "				goods_brand "
				+ "from tbl_goods "
				+ "where goods_brand =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsBrand());
			rs = pstmt.executeQuery();
			System.out.println("브랜드명\t상품명\t가격\t색깔\t사이즈\t수량");
			while(rs.next()) {
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsPrice(rs.getInt("goods_price"));
				goods.setGoodsCount(rs.getInt("goods_count"));
				goods.setGoodsSize(rs.getInt("goods_size"));
				goods.setGoodsColor(rs.getString("goods_color"));
				goods.setGoodsBrand(rs.getString("goods_brand"));
				
				System.out.printf("%s\t%s\t%d\t%s\t%d\t%d",goods.getGoodsBrand(),goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsColor(),goods.getGoodsSize(),goods.getGoodsCount());
				System.out.println();
			}
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getClose();
	}

	public void purchase(Goods goods) {
		getOpen();
		String sql = "select * from tbl_goods where goods_num =upper(?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsNum());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				goods.setGoodsNum(rs.getString("goods_num"));
				goods.setGoodsBrand(rs.getString("goods_brand"));
				goods.setGoodsCategory(rs.getString("goods_category"));
				goods.setGoodsColor(rs.getString("goods_color"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsPrice(rs.getInt("goods_price"));
				goods.setGoodsSize(rs.getInt("goods_size"));
				
				System.out.printf("%s\t%s\t%s\t%s\t%s\t%d\t%d",goods.getGoodsNum(),goods.getGoodsBrand(),goods.getGoodsCategory(),goods.getGoodsColor(),goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsSize());
			}
			getClose();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectAll() {
		getOpen();
		String sql = "select * from tbl_goods";
		try {
			Goods gd = new Goods();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gd.setGoodsNum(rs.getString("goods_num"));
				gd.setGoodsBrand(rs.getString("goods_brand"));
				gd.setGoodsCategory(rs.getNString("goods_category"));
				gd.setGoodsCategoryNum(rs.getInt("goods_categorynum"));
				gd.setGoodsColor(rs.getString("goods_color"));
				gd.setGoodsName(rs.getString("goods_name"));
				gd.setGoodsPrice(rs.getInt("goods_price"));
				gd.setGoodsCount(rs.getInt("goods_count"));
				gd.setGoodsSize(rs.getInt("goods_size"));
				
				System.out.println(gd);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(Goods goods) {
		getOpen();
		String sql = "insert into tbl_goods values(upper(?),?,?,?,?,?,?,?,?);";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sql);
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
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//				getClose();
//	}



}
