package ShoppingMall;

public class Cart {

	private String userId;
	private String goodsNum;
	private String cartName;
	private int cartPrice;
	private int caryCount;

//	public Cart(String cartList) {
//		goodsNum = cartList;
//	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public int getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCaryCount() {
		return caryCount;
	}

	public void setCaryCount(int caryCount) {
		this.caryCount = caryCount;
	}

	@Override
	public String toString() {
		return "Cart [userId=" + userId + ", goodsNum=" + goodsNum + ", cartName=" + cartName + ", cartPrice="
				+ cartPrice + ", caryCount=" + caryCount + "]";
	}

}
