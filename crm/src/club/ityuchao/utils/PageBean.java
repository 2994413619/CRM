package club.ityuchao.utils;

import java.util.List;

public class PageBean {

	private Integer currentPage;
	private Integer totalCount;
	private Integer pageSize;
	private Integer totalPage;
	private List list;
	
	//ֻ����ͨ���вι��췽������pageBean
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		//1�����õ�ǰҳ
		if(currentPage == null)
			//Ĭ�ϵ�ǰҳ�ǵ�һҳ
			this.currentPage = 1;
		else
			this.currentPage = currentPage;
		//2������ÿҳ��ʾ�ļ�¼��
		if(pageSize == null)
			//Ĭ�ϵ�һҳ��ʾ10������
			this.pageSize = 10;
		else
			this.pageSize = pageSize;
		
		//3�������ܼ�¼��
		this.totalCount = totalCount;
		
		//4��������ҳ��
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		
		//5���жϵ�ǰҳ�Ƿ񳬳���Χ
		if(this.currentPage < 1)
			this.currentPage = 1;
		else if(this.currentPage > totalPage)
			this.currentPage = this.totalPage;
	}
	
	//����sql��ѯ����ʼ����
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
