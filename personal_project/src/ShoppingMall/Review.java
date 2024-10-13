package ShoppingMall;

public class Review {

	private String goodsNumFk;
	private String userIdFk;
	private String review;
	private String reviewDate;

	public String getGoodsNumFk() {
		return goodsNumFk;
	}

	public void setGoodsNumFk(String goodsNumFk) {
		this.goodsNumFk = goodsNumFk;
	}

	public String getUserIdFk() {
		return userIdFk;
	}

	public void setUserIdFk(String userIdFk) {
		this.userIdFk = userIdFk;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "Review [goodsNumFk=" + goodsNumFk + ", userIdFk=" + userIdFk + ", review=" + review + ", reviewDate="
				+ reviewDate + "]";
	}

}
