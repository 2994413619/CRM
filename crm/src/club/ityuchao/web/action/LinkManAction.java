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

	private String likeString;//模糊查询
	private Integer currentPage;//当前页
	private Integer pageSize;//每页显示的记录数
	private Integer cust_id;//所属客户
	
	//获得客户列表
	public String linkManList() {
		//1、模糊查询
		DetachedCriteria dCriteria = DetachedCriteria.forClass(LinkMan.class);
		if(StringUtils.isNotBlank(likeString)) {
			dCriteria.add(Restrictions.like("lkm_name", "%"+likeString+"%"));
		}
		
		//2、添加所属客户
		if(cust_id != null && !"".equals(cust_id)) {
			dCriteria.add(Restrictions.eq("customer.cust_id", cust_id));
		}
		
		//3、通过service获得用户列表
		PageBean pageBean = linkManService.getlinkManList(dCriteria,currentPage,pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		
		//4、转发到显示页面
		return "linkManList";
	}
	
	//添加或修改联系人
	public String saveOrUpdate() {
		linkManService.saveOrUpdate(linkMan);
		return "tolist";
	}
	
	//删除联系人
	public String deleteById() {
		linkManService.deleteById(linkMan);
		return "tolist";
	}
	
	//通过id获得联系人
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
