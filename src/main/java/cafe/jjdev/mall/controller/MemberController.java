package cafe.jjdev.mall.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.service.MemberService;
import cafe.jjdev.mall.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	// ------------------------------------------------------회원가입 시작
	// 1. 회원가입 폼 GET addMember
	@GetMapping("/member/addMember")
	public String addMember(Model model
							,@RequestParam(value="memberId", required=true) String memberId) {
		System.out.println("[MemberController GET addMember]");
		model.addAttribute("memberId", memberId);
		return "/member/addMember";
	}

	// 2. 회원가입 액션 POST addMember
	@PostMapping("/member/addMember")
	public String addMember(Member member) {
		System.out.println("[MemberController POST addMember]");
		memberService.addMember(member);
		return "redirect:/index";
	}
	// ------------------------------------------------------회원가입 끝

	// ------------------------------------------------------로그인,로그아웃 시작
	// 3. 로그인 폼
	@GetMapping("/member/login")
	public String getMember(HttpSession session) {
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/index";
		} else {
			return "/member/login";
		}
	}

	// 4. 로그인 액션
	@PostMapping("/member/login")
	public String getMember(Model model, HttpSession session, Member member) {
		System.out.println("[MemberController POST getMember]");
		System.out.println("[MemberController getMember] loginId : " + member.getMemberId());
		System.out.println("[MemberController getMember] loginPw : " + member.getMemberPw());

		Member loginMember = memberService.getMember(member);
		// 로그인 실패
		if (loginMember == null) {
			System.out.println("로그인 실패");
			String alert = "로그인에 실패하였습니다. 다시 입력하여 주십시오";
			model.addAttribute("alert", alert);
			return "/member/login";
		}
		// 로그인 성공 -> 세션에 셋팅
		else {
			System.out.println("로그인 성공");
			session.setAttribute("loginMember", loginMember);
			return "redirect:/index";
		}
	}

	// 5. 로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		// 세션 만료시킨 후 index로 돌아가기
		session.invalidate();
		return "redirect:/index";
	}
	// ------------------------------------------------------로그인,로그아웃 끝

	// ------------------------------------------------------개인정보확인 시작
	// 6. 개인정보확인
	@GetMapping("/member/mypage")
	public String personalData(Model model
							,HttpSession session
							,@RequestParam(value = "memberNo", required = true) int memberNo) {
		System.out.println("[MemberController GET personalData]");
		System.out.println("[MemberController GET personalData] memberNo : " + memberNo);
		
		String path = "/member/mypage";
	
		if(session.getAttribute("loginMember") != null) {
			Member member = memberService.personalData(memberNo);
			model.addAttribute("member", member);
		} else {
			System.out.println("■■■personalData 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
	// ------------------------------------------------------개인정보확인 끝

	// ------------------------------------------------------비밀번호, 회원정보 수정 시작
	// 7. 비밀번호 수정 폼
	@GetMapping("/member/modifyPassword")
	public String modifyPassword(HttpSession session) {
		String path = null;
		if(session.getAttribute("loginMember") != null) {
			path = "/member/modifyPassword";
		} else {
			System.out.println("■■■modifyPassword 폼 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}

	// 8. 비밀번호 수정 액션
	@PostMapping("/member/modifyPassword")
	public String modifyPassword(HttpSession session
								,@RequestParam(value = "memberNo", required = true) int memberNo
								,@RequestParam(value = "memberPw", required = true) String memberPw
								,@RequestParam(value = "currentPw", required = true) String currentPw) {
		System.out.println("[MemberController modifyPassword]memberNo : " + memberNo);
		System.out.println("[MemberController modifyPassword]memberPw : " + memberPw);
		System.out.println("[MemberController modifyPassword]currentPw : " + currentPw);
		
		String path = "redirect:/member/mypage?memberNo=" + memberNo;
		
		if(session.getAttribute("loginMember") != null) {
			// 받아온 값들을 map에 셋팅
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("memberNo", memberNo);
			map.put("memberPw", memberPw);
			map.put("currentPw", currentPw);
			// map으로 modifyPassword메서드 호출
			memberService.modifyPassword(map);
		} else {
			System.out.println("■■■modifyPassword 액션 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}

	// 9. 회원정보 수정 폼
	@GetMapping("/member/modifyPersonalData")
	public String modifyPersonalData(HttpSession session
									,Model model
									,@RequestParam(value = "memberNo", required = true) int memberNo) {
		System.out.println("[MemberController GET modifyPersonalData]");
		System.out.println("[MemberController GET modifyPersonalData] memberNo : " + memberNo);
		
		String path = "/member/modifyPersonalData";
		
		if(session.getAttribute("loginMember") != null) {
			Member member = memberService.personalData(memberNo);
			model.addAttribute("member", member);
		} else {
			System.out.println("■■■modifyPersonalData 폼 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}

	// 10. 회원정보 수정 액션
	@PostMapping("/member/modifyPersonalData")
	public String modifyPersonalData(HttpSession session, Member member) {
		System.out.println("[MemberController POST modifyPersonalData]");
		
		String path = "redirect:/member/mypage?memberNo=" + member.getMemberNo();
		
		if(session.getAttribute("loginMember") != null) {
			memberService.modifyPersonalData(member);
		} else {
			System.out.println("■■■modifyPersonalData 액션 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
	// ------------------------------------------------------비밀번호, 회원정보 수정 끝

	// ------------------------------------------------------회원탈퇴 시작
	// 11. 회원탈퇴 폼 MemberContrller.removeMember -> removeMember.jsp
	@GetMapping("/member/removeMember")
	public String removeMember(HttpSession session) {
		System.out.println("[MemberController GET removeMember]");

		String path = null;
		
		if(session.getAttribute("loginMember") != null) {
			path = "/member/removeMember";
		} else {
			System.out.println("■■■removeMember 폼 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}

	// 12. 회원탈퇴 액션 MemberController.removeMember -> MemberService.removeMember
	@PostMapping("/member/removeMember")
	public String removeMember(Model model, Member member, HttpSession session) {
		System.out.println("[MemberController POST removeMember]");
		System.out.println("[MemberController POST removeMember] memberNo : "+member.getMemberNo());
		System.out.println("[MemberController POST removeMember] memberId : "+member.getMemberId());
		System.out.println("[MemberController POST removeMember] memberPw : "+member.getMemberPw());
		
		String path = "redirect:/index";
		String alert = null;		
		
		if(session.getAttribute("loginMember") != null) {
			boolean pwCheck = memberService.removeMember(member);
			System.out.println("■■■탈퇴■■■ boolean pwCheck : "+pwCheck);
			
			if(pwCheck == true) {
				System.out.println("■■■탈퇴 성공입니다■■■");
				session.invalidate();
			}else {
				System.out.println("■■■탈퇴 실패입니다■■■");
				alert = "탈퇴를 위한 비밀번호가 일치하지 않습니다.";
				path = "/member/removeMember";
			}	
			model.addAttribute("alert", alert);
		} else {
			System.out.println("■■■removeMember 액션 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
	// ------------------------------------------------------회원탈퇴 끝

	// ------------------------------------------------------아이디, 비밀번호 찾기 시작
	// 13_1. 아이디 찾기 폼
	@GetMapping("/member/findMyId")
	public String memberFindId() {
		System.out.println("[MemberController GET memberFindId]");
		return "/member/findMyId";
	}
	// 13_2. 아이디 찾기 액션
	@PostMapping("/member/findMyId")
	public String memberFindId(Member member
							,@RequestParam(value="memberName", required=true) String memberName
							,@RequestParam(value="memberEmail", required=true) String memberEmail) {
		System.out.println("[MemberController POST memberFindId]");
		System.out.println("[MemberController POST memberFindId] memberName : " + memberName);
		System.out.println("[MemberController POST memberFindId] memberEmail : " + memberEmail);
		
		// 받아온 값들을 map에 셋팅
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberName", memberName);
		map.put("memberEmail", memberEmail);
		// map으로 memberFindId메서드 호출
		memberService.memberFindId(map);
		return "redirect:/index";
	}
	
	// 14_1. 비밀번호 찾기 폼
	@GetMapping("/member/findMyPassword")
	public String memberFindPassword() {
		System.out.println("[MemberController GET memberFindPassword]");
		return "/member/findMyPassword";
	}
	// 14_2. 비밀번호 찾기 액션
	@PostMapping("/member/findMyPassword")
	public String memberFindId(Member member
							,@RequestParam(value="memberName", required=true) String memberName
							,@RequestParam(value="memberId", required=true) String memberId
							,@RequestParam(value="memberEmail", required=true) String memberEmail) {
		System.out.println("[MemberController POST memberFindId]");
		System.out.println("[MemberController POST memberFindId] memberName : " + memberName);
		System.out.println("[MemberController POST memberFindId] memberId : " + memberId);
		System.out.println("[MemberController POST memberFindId] memberEmail : " + memberEmail);
		
		// 받아온 값들을 map에 셋팅
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberName", memberName);
		map.put("memberId", memberId);
		map.put("memberEmail", memberEmail);
		// map으로 memberFindPw메서드 호출
	//	memberService.memberFindPw(map);
		return "redirect:/index";
	}
	// ------------------------------------------------------아이디, 비밀번호 찾기 끝
	
	// ------------------------------------------------------------아이디 중복확인 시작
	// 15. 아이디 중복체크 폼
	@GetMapping("/memberIdCheck")
	public String memberIdCheck() {
		System.out.println("[MemberController GET memberIdCheck]");
		return "/memberIdCheck";
	}

	// 16. 아이디 중복체크 액션
	@PostMapping("/memberIdCheck")
	public String memberIdCheck(Model model, @RequestParam(value = "memberId", required = true) String memberId) {
		System.out.println("[MemberController POST memberId]");
		System.out.println("[MemberController POST memberId] memberId : " + memberId);

		boolean idCheck = memberService.memberIdCheck(memberId);
		System.out.println("[MemberController POST memberIdCheck] boolean idCheck : " + idCheck);
		String alert = null;
		String path = "redirect:/member/addMember?memberId="+memberId;

		if (idCheck == true) {
			// 중복아이디 없는 경우
			System.out.println("■■■사용가능한 아이디입니다■■■");
		} else {
			// 아이디 중복되는 경우
			System.out.println("■■■이미 사용중인 아이디입니다■■■");
			alert = "이미 사용중인 아이디 입니다.";
			path = "memberIdCheck"; // redirect할 경우 map이 가지 않는다!! 바보!!
		}
		model.addAttribute("alert", alert);
		return path;
	}
	// ------------------------------------------------------------아이디 중복확인 끝
	
	// -------------------------------------------------------------이메일 전송 시작
	// 17. 이메일 전송
	// ------------------------------------------------------------이메일 전송 끝
}
