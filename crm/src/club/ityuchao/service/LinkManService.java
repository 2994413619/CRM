package club.ityuchao.service;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.domain.LinkMan;
import club.ityuchao.utils.PageBean;

public interface LinkManService {

	//添加或更新联系人
	void saveOrUpdate(LinkMan linkMan);

	//获得联系人列表
	PageBean getlinkManList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize);

	//删除联系人
	void deleteById(LinkMan linkMan);

	//通过id获得LinkMan
	LinkMan getById(Integer lkm_id);

}
