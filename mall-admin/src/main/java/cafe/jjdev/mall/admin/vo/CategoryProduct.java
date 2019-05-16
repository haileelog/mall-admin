package cafe.jjdev.mall.admin.vo;

import java.util.List;

public class CategoryProduct {
	private int categoryNo;
	private String categoryName;
	private List<ProductCommon> productCommons;
	
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<ProductCommon> getProductCommons() {
		return productCommons;
	}
	public void setProductCommons(List<ProductCommon> productCommons) {
		this.productCommons = productCommons;
	}
	
	@Override
	public String toString() {
		return "CategoryProduct [categoryNo=" + categoryNo + ", categoryName=" + categoryName + ", productCommons="
				+ productCommons + "]";
	}
	
	

}
