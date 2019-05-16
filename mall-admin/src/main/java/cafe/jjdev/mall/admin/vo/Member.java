package cafe.jjdev.mall.admin.vo;

public class Member {
	public Member() {
		super();
	}
	
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberAddress;
	private String memberGender;
	private String memberLevel;
	private String memberEmail;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		System.out.println("[Member]memberNo: "+memberNo);
		this.memberNo = memberNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		System.out.println("[Member]memberId : "+memberId);
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		System.out.println("[Member]memberPw : "+memberPw);
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		System.out.println("[Member]memberName : "+memberName);
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		System.out.println("[Member]memberPhone : "+memberPhone);
		this.memberPhone = memberPhone;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		System.out.println("[Member]memberAddress : "+memberAddress);
		this.memberAddress = memberAddress;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		System.out.println("[Member]memberGender : "+memberGender);
		this.memberGender = memberGender;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		System.out.println("[Member]memberLevel : "+memberLevel);
		this.memberLevel = memberLevel;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		System.out.println("[Member]memberEmail : "+memberEmail);
		this.memberEmail = memberEmail;
	}
	

}
