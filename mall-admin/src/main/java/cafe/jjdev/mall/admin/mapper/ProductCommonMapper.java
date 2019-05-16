package cafe.jjdev.mall.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.admin.vo.CategoryProduct;
import cafe.jjdev.mall.admin.vo.Product;
import cafe.jjdev.mall.admin.vo.ProductCommon;

@Mapper
public interface ProductCommonMapper {
	
	// ProductCommon리스트 조회시 상단에 Category 출력 resultMap / 페이징
	public CategoryProduct selectCategoryListByCategoryNo(Map<String, Object> map);
	// ProductCommon 상품 갯수 세기
	public int selectProductCommonCount(int categoryNo);
	
	
	// product 상품 리스트 보기
	public ProductCommon selectProductListByProductCommonNo(Map<String, Object> map);
	// product 상품갯수 세기
	public int selectProductCount(int productCommonNo);
	
	// ProductCommon resultMap 상품 상세보기
	public ProductCommon selectProductListByProductNo(int productCommonNo);
	
	// 2-1 product_common에 상품 추가
	public int insertProductCommon(ProductCommon productCommon);
	// 2-2 product 에 상품 추가
	public int insertProduct(Product product);
}
