package ShoppingMall;

public class Goods {

	private String goodsNum;
	private String goodsBrand;
	private String goodsCategory;
	private int goodsCategoryNum;
	private String goodsColor;
	private String goodsName;
	private int goodsPrice;
	private int goodsCount;
	private int goodsSize;

	public Goods(int num) {
		goodsCategoryNum = num;
	}

	public Goods() {
	}

	public Goods(String view) {
		goodsBrand = view;
	}

	public Goods(String goodsNum, String goodsBrand, String goodsCategory, int goodsCategoryNum,
			String goodsColor, String goodsName, int goodsPrice, int goodsCount, int goodsSize) {
		this.goodsNum = goodsNum;
		this.goodsBrand = goodsBrand;
		this.goodsCategory = goodsCategory;
		this.goodsCategoryNum = goodsCategoryNum;
		this.goodsColor = goodsColor;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsCount = goodsCount;
		this.goodsSize = goodsSize;
	}

	public String getGoodsBrand() {
		return goodsBrand;
	}

	public void setGoodsBrand(String goodsBrand) {
		this.goodsBrand = goodsBrand;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public int getGoodsCategoryNum() {
		return goodsCategoryNum;
	}

	public void setGoodsCategoryNum(int goodsCategoryNum) {
		this.goodsCategoryNum = goodsCategoryNum;
	}

	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
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

	public int getGoodsSize() {
		return goodsSize;
	}

	public void setGoodsSize(int goodsSize) {
		this.goodsSize = goodsSize;
	}

	@Override
	public String toString() {
		return "상품번호 : " + goodsNum + "\t" + "브랜드 : " + goodsBrand + "\t" + "카테고리 : " + goodsCategory + "\t"
				+ "카테고리 번호 : " + goodsCategoryNum + "\t" + "색깔 : " + goodsColor + "\t" + "상품명 : " + goodsName + "\t"
				+ "상품 가격 : " + goodsPrice + "\t" + "상품 수량 : " + goodsCount + "\t" + "상품 사이즈 : " + goodsSize;
	}

}
