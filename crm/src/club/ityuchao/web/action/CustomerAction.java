package club.ityuchao.web.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import club.ityuchao.domain.Customer;
import club.ityuchao.domain.User;
import club.ityuchao.service.CustomerService;
import club.ityuchao.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	
	private CustomerService customerService;
	private Customer customer = new Customer();
	
	private String likeString;//ģ����ѯ
	private Integer currentPage;//��ǰҳ
	private Integer pageSize;//ÿҳ��ʾ�ļ�¼��
	
	//�ļ�����
	private File customerImage;
	private String customerImageFileName;
	private String customerImageContentType;
	
	//��ÿͻ��б�
	public String customerList() {
		//1��ģ����ѯ
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(likeString)) {
			dCriteria.add(Restrictions.like("cust_name", "%"+likeString+"%"));
		}
		
		//2��ͨ��service����û��б�
		PageBean pageBean = customerService.getCustomerList(dCriteria,currentPage,pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		
		//2��ת������ʾҳ��
		return "customerList";
	}

	//��ӿͻ�
	public String saveOrUpdate() {
		customerService.saveOrUpdate(customer);
		if(customerImage != null) {
			String realPath = ServletActionContext.getServletContext().getRealPath("/uploadImage");
			customerImage.renameTo(new File(realPath+"\\"+customerImageFileName));
		}
		return "toList";
	}
	
	//����id����û�
	public String getById() {
		Customer customerNew = customerService.getById(customer.getCust_id());
		ActionContext.getContext().put("customer", customerNew);
		return "updateCustomer";
	}
	
	//����idɾ���û�
	public String deleteById() {
		customerService.deleteById(customer.getCust_id());
		return "toList";
	}
	
	//��ϵ����ӻ��޸�ʱ�����ѡ���customer�б�
	public String chooseCustomer() {
		//1��ͨ��service���ù˿��б�
		List<Customer> list = customerService.chooseCustomer(likeString);
		//2�����˿��б�ת��Ϊjson����
		Gson gson = new Gson();
		String json = gson.toJson(list);
		//3����json���ص��ͻ���
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Customer getModel() {
		return customer;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
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

	public File getCustomerImage() {
		return customerImage;
	}

	public void setCustomerImage(File customerImage) {
		this.customerImage = customerImage;
	}

	public String getCustomerImageFileName() {
		return customerImageFileName;
	}

	public void setCustomerImageFileName(String customerImageFileName) {
		this.customerImageFileName = customerImageFileName;
	}

	public String getCustomerImageContentType() {
		return customerImageContentType;
	}

	public void setCustomerImageContentType(String customerImageContentType) {
		this.customerImageContentType = customerImageContentType;
	}
	
}
