package cafe.jjdev.mall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.ProductCommon;

@Mapper
public interface ProductCommonMapper {
	// 1-1 상품 리스트
	public List<ProductCommon> selectProductCommonListByCategoryNo(Map<String, Object> map);
	// 1-2 상품 갯수세기
	public int selectProductCount(int categoryNo);
	
}
