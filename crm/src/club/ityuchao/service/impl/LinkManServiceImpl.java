package club.ityuchao.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.dao.LinkManDao;
import club.ityuchao.domain.Customer;
import club.ityuchao.domain.LinkMan;
import club.ityuchao.service.LinkManService;
import club.ityuchao.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {
	
	private LinkManDao linkManDao;

	@Override
	public void saveOrUpdate(LinkMan linkMan) {
		linkManDao.saveOrUpdate(linkMan);

	}
	
	@Override
	public PageBean getlinkManList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize) {
		//1����ѯ�ܼ�¼��
		Integer totalCount = linkManDao.getTotalCount(dCriteria);
		//2������PageBean
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//3����ѯ�û��б�
		List<LinkMan> list = linkManDao.getPageList(dCriteria, pageBean.getStart(), pageBean.getPageSize());
		//4����װ�û�list��PageBean
		pageBean.setList(list);
		return pageBean;
	}
	
	@Override
	public void deleteById(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}
	
	@Override
	public LinkMan getById(Integer lkm_id) {
		LinkMan linkMan = linkManDao.getById(lkm_id);
		return linkMan;
	}

	public LinkManDao getLinkManDao() {
		return linkManDao;
	}

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}


}
