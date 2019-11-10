package club.ityuchao.service;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.domain.SaleVisit;
import club.ityuchao.utils.PageBean;

public interface SaleVisitService {

	//获得拜访记录列表
	PageBean getSaleVisitList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize);

	//添加或修改拜访记录
	void saveOrUpdate(SaleVisit saleVisit);

	//根据id获得拜访记录
	SaleVisit getById(String visit_id);

	//删除拜访记录
	void deleteById(String visit_id);

}
