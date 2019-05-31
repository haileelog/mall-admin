package cafe.jjdev.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.mall.vo.Category;

@Mapper
public interface CategoryMapper {
	// index에서 카테고리 리스트 출력
	public List<Category> selectCategoryList();
}
