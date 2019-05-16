package cafe.jjdev.mall.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.admin.vo.Category;

@Mapper
public interface CategoryMapper {
	// index에서 카테고리 리스트 보여주기
	public List<Category> selectCategoryList();
	
	// 관리자 카테고리 추가
	public int insertCategory(Category category);
}
