package cafe.jjdev.mall.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.jjdev.mall.admin.service.CategoryService;
import cafe.jjdev.mall.admin.vo.Category;

@Controller
public class CategoryController {
	@Autowired CategoryService categoryService;
	// 관리자 카테고리 추가 폼
	@GetMapping("/category/addCategory")
	public String addCategory(HttpSession session) {
		System.out.println("[Category Controller GET addCategory]");
		
		String path = null;
		
		if(session.getAttribute("loginMember") != null) {
			path = "/category/addCategory";
		}else {
			System.out.println("■■■addCategory 폼 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
	// 관리자 카테고리 추가 액션	
	@PostMapping("/category/addCategory")
	public String addCategory(Category category, HttpSession session) {
		System.out.println("[Category Controller POST addCategory]");
		
		String path = null;
		
		if(session.getAttribute("loginMember") != null) {
			categoryService.addCategory(category);
			path = "redirect:/category/getCategoryList";
		} else {
			System.out.println("■■■addCategory 액션 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
}
