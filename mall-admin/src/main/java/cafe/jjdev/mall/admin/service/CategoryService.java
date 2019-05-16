package cafe.jjdev.mall.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.admin.mapper.CategoryMapper;
import cafe.jjdev.mall.admin.vo.Category;
	
@Service
@Transactional
public class CategoryService {
	@Autowired private CategoryMapper categoryMapper;
	
	// index에서 카테고리 리스트 출력
	public List<Category> getCategoryList(){
		List<Category> list = categoryMapper.selectCategoryList();		
		return list;
	}
	
	// 관리자 카테고리 추가
	public int addCategory(Category category) {
		return categoryMapper.insertCategory(category);
	}
}



