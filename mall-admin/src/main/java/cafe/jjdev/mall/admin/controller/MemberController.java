package cafe.jjdev.mall.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.jjdev.mall.admin.service.MemberService;
import cafe.jjdev.mall.admin.vo.Member;

@Controller
public class MemberController {
	@Autowired private MemberService memberService;
	
	// 로그인 폼
	@GetMapping("/member/login")
	public String adminLogin(HttpSession session) {
		System.out.println("[MemberController GET adminLogin]");
		
		String path = "redirect:/index";
		
		if(session.getAttribute("loginMember") != null) {
			System.out.println("로그인 성공");			
		}else {
			System.out.println("로그인 실패");
			path = "/member/login";			
		}
		return path;
	}
	
	// 로그인 액션
	@PostMapping("/member/login")
	public String adminLogin(Member member, HttpSession session, Model model) {
		System.out.println("[MemberController POST adminLogin]");
		System.out.println("[MemberController POST adminLogin] id : "+ member.getMemberId());
		System.out.println("[MemberController POST adminLogin] pw : "+ member.getMemberPw());
		System.out.println("[MemberController POST adminLogin] pw : "+ member.getMemberLevel());
		
		Member loginMember = memberService.adminLogin(member);
		String path = "redirect:/index";
		
		if(loginMember == null) {
			System.out.println("관리자 로그인 실패");
			String loginAlert = "로그인에 실패하였습니다. 다시 시도하여 주십시오";
			model.addAttribute("loginAlert", loginAlert);
			path = "/member/login";
		} else {
			System.out.println("관리자 로그인 성공");
			session.setAttribute("loginMember", loginMember);
		}		
		return path;
		
	}
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String adminLogout(HttpSession session) {
		System.out.println("[MemberController GET adminLogout]");
		
		session.invalidate();
		return "redirect:/index";
	}	
}
