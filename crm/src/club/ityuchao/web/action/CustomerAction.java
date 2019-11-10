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
	
	private String likeString;//模糊查询
	private Integer currentPage;//当前页
	private Integer pageSize;//每页显示的记录数
	
	//文件属性
	private File customerImage;
	private String customerImageFileName;
	private String customerImageContentType;
	
	//获得客户列表
	public String customerList() {
		//1、模糊查询
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(likeString)) {
			dCriteria.add(Restrictions.like("cust_name", "%"+likeString+"%"));
		}
		
		//2、通过service获得用户列表
		PageBean pageBean = customerService.getCustomerList(dCriteria,currentPage,pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		
		//2、转发到显示页面
		return "customerList";
	}

	//添加客户
	public String saveOrUpdate() {
		customerService.saveOrUpdate(customer);
		if(customerImage != null) {
			String realPath = ServletActionContext.getServletContext().getRealPath("/uploadImage");
			customerImage.renameTo(new File(realPath+"\\"+customerImageFileName));
		}
		return "toList";
	}
	
	//根据id获得用户
	public String getById() {
		Customer customerNew = customerService.getById(customer.getCust_id());
		ActionContext.getContext().put("customer", customerNew);
		return "updateCustomer";
	}
	
	//根据id删除用户
	public String deleteById() {
		customerService.deleteById(customer.getCust_id());
		return "toList";
	}
	
	//联系人添加或修改时：获得选择的customer列表
	public String chooseCustomer() {
		//1、通过service层获得顾客列表
		List<Customer> list = customerService.chooseCustomer(likeString);
		//2、将顾客列表转化为json数据
		Gson gson = new Gson();
		String json = gson.toJson(list);
		//3、将json返回到客户端
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
