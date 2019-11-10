package club.ityuchao.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import club.ityuchao.domain.Customer;
import club.ityuchao.domain.SaleVisit;
import club.ityuchao.domain.User;
import club.ityuchao.service.SaleVisitService;
import club.ityuchao.utils.PageBean;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

	private SaleVisitService saleVisitService;
	
	private SaleVisit saleVisit = new SaleVisit();
	
	private String likeString;//ģ����ѯ
	private Integer currentPage;//��ǰҳ
	private Integer pageSize;//ÿҳ��ʾ�ļ�¼��
	private Integer cust_id;//�����ͻ�
	
	//��÷��ʼ�¼�б�
	public String saleVisitList() {
		//1��ģ����ѯ
		DetachedCriteria dCriteria = DetachedCriteria.forClass(SaleVisit.class);
		if(StringUtils.isNotBlank(likeString)) {
			dCriteria.add(Restrictions.like("customer.cust_name", "%"+likeString+"%"));
		}
		
		System.out.println(cust_id);
		
		//2����������ͻ�
		if(cust_id != null) {
			dCriteria.add(Restrictions.eq("customer.cust_id", cust_id));
		}
		
		//3��ͨ��service����û��б�
		PageBean pageBean = saleVisitService.getSaleVisitList(dCriteria,currentPage,pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		
		//4��ת������ʾҳ��
		return "saleVisitList";
	}
	
	//��ӻ��޸ķ��ʼ�¼
	public String saveOrUpdate() {
		//��session�л��user_id
		User user = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(user);
		
		saleVisitService.saveOrUpdate(saleVisit);
		return "toList";
	}
	
	//����id��ðݷü�¼
	public String getById() {
		SaleVisit saleVisitNew = saleVisitService.getById(saleVisit.getVisit_id());
		ActionContext.getContext().put("saleVisit", saleVisitNew);
		return "updatesaleVisit";
	}
	
	//ɾ�����ʼ�¼
	public String deleteById() {
		saleVisitService.deleteById(saleVisit.getVisit_id());
		return "toList";
	}

	@Override
	public SaleVisit getModel() {
		return saleVisit;
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

	public SaleVisitService getSaleVisitService() {
		return saleVisitService;
	}

	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	
}
