package ShoppingMall;

public class User {

	private String userId;
	private String userPw;
	private String userName;
	private String responsibility;
	private int asset;

	public User() {}
	
	public User(String joinId, String joinPw, String joinName) {
		userId = joinId;
		userPw = joinPw;
		userName = joinName;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public int getAsset() {
		return asset;
	}

	public void setAsset(int asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "아이디 : " + userId + "비밀번호 : " + userPw + "닉네임 : " + userName + "권한 : "
				+ responsibility + "포인트 : " + asset;
	}


}
