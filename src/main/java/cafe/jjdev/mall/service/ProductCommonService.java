package cafe.jjdev.mall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.mall.mapper.ProductCommonMapper;
import cafe.jjdev.mall.vo.ProductCommon;

@Service
public class ProductCommonService {
	@Autowired private ProductCommonMapper productCommonMapper;
	
	public Map<String, Object> getProductCommonListByCategoryNo(int categoryNo, int currentPage){
		// 페이징 작업
		int ROW_PER_PAGE = 10;
		int beginRow = (currentPage-1)*ROW_PER_PAGE;
		
		// map내부에 셋팅
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ROW_PER_PAGE", ROW_PER_PAGE);
		map.put("beginRow", beginRow);
		map.put("categoryNo", categoryNo);
		
		List<ProductCommon> list = productCommonMapper.selectProductCommonListByCategoryNo(map);
		int productCount = productCommonMapper.selectProductCount(categoryNo);
		int lastPage = productCount/ROW_PER_PAGE;
		// 10개 단위로 딱 끝나지 않을 경우 나머지 행들 보여주는 페이지
		if(productCount%ROW_PER_PAGE != 0) {
			lastPage++;
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("lastPage", lastPage);
		returnMap.put("productCount", productCount);
		return returnMap;	
	}
}
