package cafe.jjdev.mall.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.mall.admin.mapper.ProductCommonMapper;
import cafe.jjdev.mall.admin.vo.CategoryProduct;
import cafe.jjdev.mall.admin.vo.Product;
import cafe.jjdev.mall.admin.vo.ProductCommon;

@Service
public class ProductCommonService {
	@Autowired private ProductCommonMapper productCommonMapper;
	
	// ProductCommon리스트 조회시 상단에 Category 출력	
	// ProductCommon 카테고리별 상품 리스트
	public Map<String, Object> getProductCommonListByCategoryNo(int categoryNo, int currentPage, String searchWord){
		// 페이징을 위한 작업
		final int ROW_PER_PAGE = 10;
		int beginRow = (currentPage-1)*ROW_PER_PAGE;
		// map내부에 셋팅
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryNo", categoryNo);
		map.put("beginRow", beginRow);
		map.put("ROW_PER_PAGE", ROW_PER_PAGE);
		map.put("searchWord", "%"+searchWord+"%");
		
		CategoryProduct categoryP = productCommonMapper.selectCategoryListByCategoryNo(map);
		int productCountByCategory = productCommonMapper.selectProductCommonCount(categoryNo);
		int lastPage = productCountByCategory/ROW_PER_PAGE;
		if(productCountByCategory%ROW_PER_PAGE != 0) {
			lastPage++;
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("categoryP", categoryP);
		//returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("productCount", productCountByCategory);
		return returnMap;
	}
	
	// ProductCommon 상품 추가
	public int addProductCommon(ProductCommon productCommon) {
		return productCommonMapper.insertProductCommon(productCommon);		
	}
	
	// Product 리스트
	public Map<String, Object> getProductListByProductCommonNo(int productCommonNo, int currentPage){
		// 페이징 작업
		final int ROW_PER_PAGE = 10;
		int beginRow = (currentPage-1)*ROW_PER_PAGE;
		
		// map내부에 셋팅
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("productCommonNo", productCommonNo);
		map.put("beginRow", beginRow);
		map.put("ROW_PER_PAGE", ROW_PER_PAGE);
		
		ProductCommon pc = productCommonMapper.selectProductListByProductCommonNo(map);
		System.out.println("service pc : "+ pc);
		int productCount = productCommonMapper.selectProductCount(productCommonNo);
		int lastPage = productCount/ROW_PER_PAGE;
		if(productCount%ROW_PER_PAGE != 0) {
			lastPage++;
		}
		
		// service에서 사용할 것들 returnMap에 담기
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("pc", pc);
		returnMap.put("lastPage", lastPage);
		returnMap.put("productCount", productCount);
		return returnMap;
	}
	
	// ProductCommon 상품 추가
		public int addProduct(Product product) {
			return productCommonMapper.insertProduct(product);		
		}
}
