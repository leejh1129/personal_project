package 도서관리;

import java.util.Date;

// 두단어 조합 oracle : member_id /java : memberId
public class Member {

	private String memberId;
	private String password;
	private String memberName;
	private String phone;
	private String responsibility;
	private Date creationDate;

	public Member() {
		
	}

	public Member(String id) {
		memberId = id;
	}

	public Member(String id, String name) {
		memberId = id;
		memberName = name;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "아이디 : " + memberId + " \t " +"비밀번호 : " + password + " \t " + "닉네임 : " + memberName + " \t " + "전화번호 : " + phone + " \t " + "권한 : " + responsibility + " \t " + "생성일 : " + creationDate;
	}

}
