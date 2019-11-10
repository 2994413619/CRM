package club.ityuchao.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.dao.SaleVisitDao;
import club.ityuchao.domain.SaleVisit;
import club.ityuchao.service.SaleVisitService;
import club.ityuchao.utils.PageBean;

public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao saleVisitdao;
	
	@Override
	public PageBean getSaleVisitList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize) {
		//1、查询总记录数
		Integer totalCount = saleVisitdao.getTotalCount(dCriteria);
		//2、创建PageBean
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//3、查询用户列表
		List<SaleVisit> list = saleVisitdao.getPageList(dCriteria, pageBean.getStart(), pageBean.getPageSize());
		//4、封装用户list到PageBean
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void saveOrUpdate(SaleVisit saleVisit) {
		saleVisitdao.saveOrUpdate(saleVisit);
	}

	@Override
	public SaleVisit getById(String visit_id) {
		SaleVisit saleVisit = saleVisitdao.getById(visit_id);
		return saleVisit;
	}

	@Override
	public void deleteById(String visit_id) {
		saleVisitdao.delete(visit_id);
		
	}

	public SaleVisitDao getSaleVisitdao() {
		return saleVisitdao;
	}

	public void setSaleVisitdao(SaleVisitDao saleVisitdao) {
		this.saleVisitdao = saleVisitdao;
	}

}
