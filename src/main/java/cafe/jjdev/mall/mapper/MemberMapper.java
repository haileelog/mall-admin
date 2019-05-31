package cafe.jjdev.mall.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Email;
import cafe.jjdev.mall.vo.Member;

@Mapper
public interface MemberMapper {
	// 회원가입 시 아이디 중복체크
	public Member selectIdCheck(String memberId);
	
	// 회원가입
	public int insertMember(Member member);
	// 회원가입 시 아이디 테이블에 아이디 저장
	public int insertUsedMemberId(Member member);
	// 회원가입 시 권한테이블에 회원번호 저장
	public int insertConsumerByMemberNo(Member memberNo);
	public int insertEmployeeByMemberNo(Member memberNo);
	
	// 로그인
	public Member selectMemberByIdAndPw(Member member);
	
	//회원정보조회
	public Member selectMemberByMemberNo(int memberNo);
	
	// 회원정보 수정
	public int updatePersonalData(Member member);
	// 비밀번호 수정
	public int updatePassword(Map<String, Object> map);
	
	// 회원 탈퇴 시 등급테이블에서 삭제 및 회원탈퇴
	public int deleteMember(Member member);
	// 회원 탈퇴 시 탈퇴테이블에 저장
	public int insertMemberOutId(Member member);
	
	// 아이디 찾기
	public Member searchId(Map<String, Object> map);
	// 비밀번호 찾기
	public Member searchPw(Map<String, Object> map);
}
