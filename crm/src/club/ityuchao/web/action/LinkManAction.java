package club.ityuchao.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import club.ityuchao.domain.Customer;
import club.ityuchao.domain.LinkMan;
import club.ityuchao.service.LinkManService;
import club.ityuchao.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkMan = new LinkMan();
	
	private LinkManService linkManService;

	private String likeString;//ģ����ѯ
	private Integer currentPage;//��ǰҳ
	private Integer pageSize;//ÿҳ��ʾ�ļ�¼��
	private Integer cust_id;//�����ͻ�
	
	//��ÿͻ��б�
	public String linkManList() {
		//1��ģ����ѯ
		DetachedCriteria dCriteria = DetachedCriteria.forClass(LinkMan.class);
		if(StringUtils.isNotBlank(likeString)) {
			dCriteria.add(Restrictions.like("lkm_name", "%"+likeString+"%"));
		}
		
		//2����������ͻ�
		if(cust_id != null && !"".equals(cust_id)) {
			dCriteria.add(Restrictions.eq("customer.cust_id", cust_id));
		}
		
		//3��ͨ��service����û��б�
		PageBean pageBean = linkManService.getlinkManList(dCriteria,currentPage,pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		
		//4��ת������ʾҳ��
		return "linkManList";
	}
	
	//��ӻ��޸���ϵ��
	public String saveOrUpdate() {
		linkManService.saveOrUpdate(linkMan);
		return "tolist";
	}
	
	//ɾ����ϵ��
	public String deleteById() {
		linkManService.deleteById(linkMan);
		return "tolist";
	}
	
	//ͨ��id�����ϵ��
	public String getById() {
		LinkMan linkManNew = linkManService.getById(linkMan.getLkm_id());
		ActionContext.getContext().put("linkMan", linkManNew);
		return "updateLinkMan";
	}
	
	public LinkMan getModel() {
		return linkMan;
	}

	public LinkManService getLinkManService() {
		return linkManService;
	}

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public String getLikeString() {
		return likeString;
	}

	public void setLikeString(String likeString) {
		this.likeString = likeString;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
