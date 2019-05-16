package cafe.jjdev.mall.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.admin.service.ProductCommonService;
import cafe.jjdev.mall.admin.vo.CategoryProduct;
import cafe.jjdev.mall.admin.vo.Product;
import cafe.jjdev.mall.admin.vo.ProductCommon;

@Controller
public class ProductCommonController {
	
	@Autowired private ProductCommonService productCommonService;
	
	// 카테고리별 상품리스트 출력 
	//ProductCommon리스트 조회시 상단에 Category 출력
	@GetMapping("/product/getProductListByCategory")
	public String getProductCommonListByCategory(ProductCommon productCommon, Model model
												,@RequestParam(value="categoryNo", required=true) int categoryNo
												,@RequestParam(value="currentPage", defaultValue= "1") int currentPage
												,@RequestParam(value="searchWord", defaultValue="") String searchWord) {
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory]");
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory] categoryNo : "+categoryNo);
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory] currentPage : "+currentPage);
		
		Map<String, Object> map = productCommonService.getProductCommonListByCategoryNo(categoryNo, currentPage, searchWord);
		model.addAttribute("categoryP", map.get("categoryP"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("productCount", map.get("productCount"));
		model.addAttribute("categoryNo", categoryNo);
		model.addAttribute("currentPage", currentPage);

		System.out.println("categoryP: "+map.get("categoryP"));
		System.out.println("lastPage: "+map.get("lastPage"));
		System.out.println("productCount: " +map.get("productCount"));
		System.out.println("categoryNo: "+categoryNo);
		System.out.println("currentPage: "+currentPage);
		return "/product/getProductListByCategory";
	}
	
	// ProductCommon 상품 추가 폼
	@GetMapping("/product/addProductCommon")
	public String addProductCommon(HttpSession session, Model model
								,@RequestParam(value="categoryNo", required=true) int categoryNo) {
		System.out.println("[ProductCommonController GET addProductCommon]");
		
		String path = null; 
		
		if(session.getAttribute("loginMember") != null) {
			model.addAttribute("categoryNo", categoryNo);
			path = "/product/addProductCommon";
		}else {
			System.out.println("■■■addProduct 폼 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
	
	// ProductCommon 상품 추가 액션
	@PostMapping("/product/addProductCommon")
	public String addProductCommon(ProductCommon productCommon, HttpSession session
							,@RequestParam(value="categoryNo", required=true) int categoryNo) {
		System.out.println("[ProductCommonController POST addProductCommon]categoryNo : "+categoryNo);
		
		String path = null; 
		
		if(session.getAttribute("loginMember") != null) {			
			productCommonService.addProductCommon(productCommon);	
			System.out.println("[ProductCommonController POST addProductCommon]");
			path = "redirect:/product/getProductListByCategory?categoryNo="+categoryNo;
		}else {
			System.out.println("■■■addProduct 액션 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
	
	// product 상품리스트 출력 
	@GetMapping("/product/getProductListByProductCommonNo")
	public String getProductListByProductCommonNo(Product product, Model model, HttpSession session
												,@RequestParam(value="productCommonNo", required=true) int productCommonNo
												,@RequestParam(value="currentPage", defaultValue= "1") int currentPage) {
		String path = null;
		
		if(session.getAttribute("loginMember") != null) {
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory]");
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory] productCommonNo : "+productCommonNo);
		System.out.println("[ProductCommonController GET getProductCommonListByCagetory] currentPage : "+currentPage);
		
		Map<String, Object> map = productCommonService.getProductListByProductCommonNo(productCommonNo, currentPage);
		model.addAttribute("pc", map.get("pc"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("productCount", map.get("productCount"));
		model.addAttribute("productCommonNo", productCommonNo);
		model.addAttribute("currentPage", currentPage);
		
		System.out.println("pc: "+map.get("pc"));
		System.out.println("lastPage: "+map.get("lastPage"));
		System.out.println("productCount: " +map.get("productCount"));
		System.out.println("productCommonNo: "+productCommonNo);
		System.out.println("currentPage: "+currentPage); 
		
		path = "/product/getProductListByProductCommonNo";
		} else {
			System.out.println("■■■addProduct 액션 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
	
	// product 상품 추가 폼
	@GetMapping("/product/addProduct")
	public String addProduct(HttpSession session, Model model
							,@RequestParam(value="productCommonNo", required=true) int productCommonNo) {
		
		String path = null;
		if(session.getAttribute("loginMember") != null) {
			System.out.println("[ProductCommonController GET addProduct]");
			model.addAttribute("productCommonNo", productCommonNo);
			path = "/product/addProduct";
		}else {
			System.out.println("■■■addProduct 액션 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;
	}
	
	// product 상품 추가 액션
	@PostMapping("/product/addProduct")
	public String addProduct(Product product, HttpSession session
							,@RequestParam(value="productCommonNo", required=true) int productCommonNo) {
		System.out.println("[ProductCommonController POST addProductCommon]productCommonNo : "+productCommonNo);
		String path = null;
		if(session.getAttribute("loginMember") != null) {
			System.out.println("[ProductCommonController POST addProduct]");
			productCommonService.addProduct(product);
			path = "redirect:/product/getProductListByProductCommonNo?productCommonNo="+productCommonNo;
		}else {
			System.out.println("■■■addProduct 액션 세션 만료 ■■■");
			path = "/member/login";
		}
		return path;	
	}
}
