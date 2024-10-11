package ShoppingMall;

import java.sql.SQLException;

public class GoodsDao extends DAO {

	public void select(Goods num) {
		getOpen();
		String sql = "select distinct goods_color," + "        goods_name," + "        goods_price, "
				+ "        goods_brand, " + "        goods_num " + "from tbl_goods where goods_categorynum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num.getGoodsCategoryNum());

			rs = pstmt.executeQuery();
			System.out.println("상품번호\t\t상품\t\t가격\t\t남은수량\t\t사이즈");
			while (rs.next()) {
				num.setGoodsName(rs.getString("goods_name"));
				num.setGoodsPrice(rs.getInt("goods_price"));
				num.setGoodsColor(rs.getString("goods_color"));
				num.setGoodsBrand(rs.getString("goods_brand"));
				num.setGoodsNum(rs.getNString("goods_num"));

				System.out.printf("%s\t%s\t%s\t%d\t%s", num.getGoodsNum(), num.getGoodsBrand(), num.getGoodsName(),
						num.getGoodsPrice(), num.getGoodsColor());
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
		String sql = "select  goods_name, " + "        		goods_price, " + "        		goods_count, "
				+ "        		goods_size, " + "        		goods_color, " + "				goods_brand "
				+ "from tbl_goods " + "where goods_brand =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsBrand());
			rs = pstmt.executeQuery();
			System.out.println("브랜드명\t상품명\t가격\t색깔\t사이즈\t수량");
			while (rs.next()) {
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsPrice(rs.getInt("goods_price"));
				goods.setGoodsCount(rs.getInt("goods_count"));
				goods.setGoodsSize(rs.getInt("goods_size"));
				goods.setGoodsColor(rs.getString("goods_color"));
				goods.setGoodsBrand(rs.getString("goods_brand"));

				System.out.printf("%s\t%s\t%d\t%s\t%d\t%d", goods.getGoodsBrand(), goods.getGoodsName(),
						goods.getGoodsPrice(), goods.getGoodsColor(), goods.getGoodsSize(), goods.getGoodsCount());
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
//			System.out.println("상품번호\t브랜드\t맨투맨\t색상\t상품명\t가격\t사이즈\t수량");
			while (rs.next()) {
				goods.setGoodsNum(rs.getString("goods_num"));
				goods.setGoodsBrand(rs.getString("goods_brand"));
				goods.setGoodsCategory(rs.getString("goods_category"));
				goods.setGoodsColor(rs.getString("goods_color"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsPrice(rs.getInt("goods_price"));
				goods.setGoodsSize(rs.getInt("goods_size"));
				goods.setGoodsCount(rs.getInt("goods_count"));

				System.out.printf("상품번호: %s\t 브랜드: %s\t 맨투맨: %s\t 색상: %s\t 상품명: %s\t 가격: %d\t 사이즈: %d\t 수량: %d", goods.getGoodsNum(), goods.getGoodsBrand(),
						goods.getGoodsCategory(), goods.getGoodsColor(), goods.getGoodsName(), goods.getGoodsPrice(),
						goods.getGoodsSize(),goods.getGoodsCount());
				System.out.println();
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
			while (rs.next()) {
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
		String sql = "insert into tbl_goods values(upper(?),?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsNum());
			pstmt.setString(2, goods.getGoodsBrand());
			pstmt.setString(3, goods.getGoodsCategory());
			pstmt.setInt(4, goods.getGoodsCategoryNum());
			pstmt.setString(5, goods.getGoodsColor());
			pstmt.setString(6, goods.getGoodsName());
			pstmt.setInt(7, goods.getGoodsPrice());
			pstmt.setInt(8, goods.getGoodsCount());
			pstmt.setInt(9, goods.getGoodsSize());

			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("상품추가완료");
			} else {
				System.out.println("상품추가 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Goods goods) {
		getOpen();
		String sql = "delete from tbl_goods where goods_num=upper(?)";
		String sqlSelect = "select goods_name from tbl_goods where goods_num=upper(?)";
		try {

			pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setString(1, goods.getGoodsNum());

			rs = pstmt.executeQuery();

			String select = null;

			if (rs.next()) {
				select = rs.getString("goods_name");
			} else {
				System.out.println("상품이 존재하지 않습니다");
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsNum());
			System.out.printf("상품번호 : %s\t상품명 : %s\t 삭제완료", goods.getGoodsNum(), select);
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Goods goods, int num, User login ,int pointcheck) {
		getOpen();
		String sql = "update tbl_goods set goods_count=? where goods_num=upper(?)";
		String updateUser = "update tbl_user set asset=? where user_id=?";
		String selectGoods = "select goods_count, goods_price from tbl_goods where goods_num=upper(?)";
		try {

			pstmt = conn.prepareStatement(selectGoods);
			pstmt.setString(1, goods.getGoodsNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				goods.setGoodsCount(rs.getInt("goods_count"));
			}
			
			int rows = 0;
			pstmt = conn.prepareStatement(sql);
			
			int num1 = goods.getGoodsCount();
			
			if (goods.getGoodsCount() >= num) {
				num1 = goods.getGoodsCount() - num;
				pstmt.setInt(1, num1);
				pstmt.setString(2, goods.getGoodsNum());
				rows = pstmt.executeUpdate();
				
			} else {				
				System.out.println("선택하신 제품수량이 부족합니다 현재 수량 : " + num1);
			}
			
			if(rows == 1) {				
				pstmt = conn.prepareStatement(updateUser);
				
				int num2 = login.getAsset();
				
				if(login.getAsset() >= (goods.getGoodsPrice()*num)) {
					num2 = login.getAsset() -(goods.getGoodsPrice()*num);
					pstmt.setInt(1, num2);
					pstmt.setString(2, login.getUserId());
					pstmt.executeUpdate();
					System.out.println("결제완료");
					System.out.println("남은 포인트 : " + num2);
				} else {
					System.out.println("포인트가 부족합니다");
				}
			}

			


			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
