package cafe.jjdev.mall.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.mall.admin.mapper.MemberMapper;
import cafe.jjdev.mall.admin.vo.Member;

@Service
public class MemberService {
	@Autowired private MemberMapper memberMapper;
	
	public Member adminLogin(Member member) {
		return memberMapper.selectMemberByIdAndPw(member);
		
	}
	

}
