package club.ityuchao.service;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.domain.LinkMan;
import club.ityuchao.utils.PageBean;

public interface LinkManService {

	//��ӻ������ϵ��
	void saveOrUpdate(LinkMan linkMan);

	//�����ϵ���б�
	PageBean getlinkManList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize);

	//ɾ����ϵ��
	void deleteById(LinkMan linkMan);

	//ͨ��id���LinkMan
	LinkMan getById(Integer lkm_id);

}
