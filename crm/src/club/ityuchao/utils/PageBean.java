package club.ityuchao.utils;

import java.util.List;

public class PageBean {

	private Integer currentPage;
	private Integer totalCount;
	private Integer pageSize;
	private Integer totalPage;
	private List list;
	
	//只允许通过有参构造方法创建pageBean
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		//1、设置当前页
		if(currentPage == null)
			//默认当前页是第一页
			this.currentPage = 1;
		else
			this.currentPage = currentPage;
		//2、设置每页显示的记录数
		if(pageSize == null)
			//默认第一页显示10条数据
			this.pageSize = 10;
		else
			this.pageSize = pageSize;
		
		//3、设置总记录数
		this.totalCount = totalCount;
		
		//4、计算总页数
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		
		//5、判断当前页是否超出范围
		if(this.currentPage < 1)
			this.currentPage = 1;
		else if(this.currentPage > totalPage)
			this.currentPage = this.totalPage;
	}
	
	//计算sql查询的起始索引
	public Integer getStart() {
		return (this.currentPage - 1) * this.pageSize;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
