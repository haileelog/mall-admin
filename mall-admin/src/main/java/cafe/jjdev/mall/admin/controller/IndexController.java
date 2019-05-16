package cafe.jjdev.mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cafe.jjdev.mall.admin.service.CategoryService;
import cafe.jjdev.mall.admin.vo.Category;

@Controller
public class IndexController {
	@Autowired private CategoryService categoryService;
	
	@GetMapping("/index")
	public String getCategoryList(Model model) {
		System.out.println("[IndexController GET getCategoryList] adminindex 카테고리 리스트 출력");
		
		List<Category> categoryList = categoryService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		
		return "/index";
	}


}
