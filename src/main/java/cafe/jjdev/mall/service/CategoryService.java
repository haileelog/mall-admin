package cafe.jjdev.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.mapper.CategoryMapper;
import cafe.jjdev.mall.vo.Category;

@Service
@Transactional
public class CategoryService {
	@Autowired private CategoryMapper categoryMapper;
	
	// index에서 카테고리 리스트 출력
	public List<Category> getCategoryList(){
		List<Category> list = categoryMapper.selectCategoryList();		
		return list;
	}
}
