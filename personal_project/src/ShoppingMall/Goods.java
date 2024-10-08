package ShoppingMall;

public class Goods {

	private int goodsNum;
	private String goodsName;
	private int goodsPrice;
	private int goodsCount;

	public Goods(int num) {
		goodsNum = num;
	}

	public Goods() {}


	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	@Override
	public String toString() {
		return "Goods [goodsNum=" + goodsNum + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", goodsCount=" + goodsCount + "]";
	}

}
