package cafe.jjdev.mall.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.email.EmailServiceImpl;
import cafe.jjdev.mall.mapper.MemberMapper;
import cafe.jjdev.mall.vo.Email;
import cafe.jjdev.mall.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	@Autowired private EmailServiceImpl emailServiceImpl;
	
	// 회원가입
	public int addMember(Member member) {
		// member 테이블에 추가
		memberMapper.insertMember(member);
		// member_used_id테이블에 아이디 추가
		memberMapper.insertUsedMemberId(member);
		// member_권한 테이블에 memberNo 추가
		return memberMapper.insertConsumerByMemberNo(member);
	}
	
	// 아이디 중복확인 
	public boolean memberIdCheck(String memberId) {
		boolean idCheck = false;
		System.out.println(memberId);
		System.out.println("[memberService idCheck]"+memberMapper.selectIdCheck(memberId));
		
		if(memberMapper.selectIdCheck(memberId) == null) {
			idCheck = true;			
		}
		return idCheck;
	}
	
	// 로그인
	public Member getMember(Member member) {
		return memberMapper.selectMemberByIdAndPw(member);
	}
	
	// 개인정보조회
	public Member personalData(int memberNo) {		
		return memberMapper.selectMemberByMemberNo(memberNo);
	}
	
	// 회원정보 수정
	public int modifyPersonalData(Member member) {
		return memberMapper.updatePersonalData(member);		
	}
	
	// 비밀번호 수정 (map 사용)
	public int modifyPassword(Map<String, Object> map) {
		return memberMapper.updatePassword(map);
		
		
	}
	
	// 회원 탈퇴
	public boolean removeMember(Member member) {		
		memberMapper.deleteMember(member);
		System.out.println("■■■■!!!회원정보 삭제!!!■■■■");
		
		boolean pwCheck = false;
		
		if(memberMapper.selectMemberByMemberNo(member.getMemberNo()) == null) {
			System.out.println("■■■■!!!!!!!회원탈퇴성공  탈퇴리스트 업데이트!!!!!!!■■■■");
			memberMapper.insertMemberOutId(member);
			pwCheck = true;
		}
		return pwCheck;
	}
	

	// 아이디 찾기
	public void memberFindId(Map<String, Object> map) {
	  System.out.println("[MemberService memberFindId] map : "+map);
		  
	  Member member = memberMapper.searchId(map);
	  String subject = "아이디 찾기 결과입니다.";
	  
	  emailServiceImpl.sendSimpleMessage(member, subject); 
	  } 
	
	//비밀번호 찾기 
	public Member memberFindPw(Map<String, Object> map) {
	  System.out.println("[MemberService memberFindPw] map : "+map); 
	  
	  return memberMapper.searchPw(map); 
	  }
	 
	
}
