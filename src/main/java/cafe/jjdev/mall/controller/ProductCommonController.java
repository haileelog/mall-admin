package cafe.jjdev.mall.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.service.ProductCommonService;
import cafe.jjdev.mall.vo.ProductCommon;

@Controller
public class ProductCommonController {
	@Autowired private ProductCommonService productCommonService;
	
	//카테고리별 상품 리스트 출력
	@GetMapping("/product/getProductListByCategory")
	public String getProductCommonListByCagegory(ProductCommon productCommon, Model model
												,@RequestParam(value="categoryNo", required=true) int categoryNo
												,@RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory]");
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory] categoryNo : "+categoryNo);
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory] currentPage : "+currentPage);
		
		Map<String, Object> map = productCommonService.getProductCommonListByCategoryNo(categoryNo, currentPage);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("productCount", map.get("productCount"));
		model.addAttribute("categoryNo", productCommon.getCategoryNo());
		model.addAttribute("currentPage", currentPage);
		
		System.out.println("list: "+map.get("list"));
		System.out.println("lastPage: "+map.get("lastPage"));
		System.out.println("productCount: " +map.get("productCount"));
		System.out.println("categoryNo: "+productCommon.getCategoryNo());
		System.out.println("currentPage: "+currentPage);
		return "/product/getProductListByCategory";		
	}
}
