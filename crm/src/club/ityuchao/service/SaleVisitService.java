package club.ityuchao.service;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.domain.SaleVisit;
import club.ityuchao.utils.PageBean;

public interface SaleVisitService {

	//��ðݷü�¼�б�
	PageBean getSaleVisitList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize);

	//��ӻ��޸İݷü�¼
	void saveOrUpdate(SaleVisit saleVisit);

	//����id��ðݷü�¼
	SaleVisit getById(String visit_id);

	//ɾ���ݷü�¼
	void deleteById(String visit_id);

}
