package club.ityuchao.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import club.ityuchao.dao.CustomerDao;
import club.ityuchao.domain.Customer;
import club.ityuchao.service.CustomerService;
import club.ityuchao.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;


	@Override
	public void saveOrUpdate(Customer customer) {
		customerDao.saveOrUpdate(customer);
		
	}
	
	@Override
	public PageBean getCustomerList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize) {
		//1、查询总记录数
		Integer totalCount = customerDao.getTotalCount(dCriteria);
		//2、创建PageBean
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//3、查询用户列表
		List<Customer> list = customerDao.getPageList(dCriteria, pageBean.getStart(), pageBean.getPageSize());
		//4、封装用户list到PageBean
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Customer getById(Integer cust_id) {
		Customer customer = customerDao.getById(cust_id);
		return customer;
	}
	
	@Override
	public void deleteById(Integer cust_id) {
		customerDao.delete(cust_id);
	}
	
	@Override
	public List<Customer> chooseCustomer(String likeString) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.like("cust_name", "%"+likeString+"%"));
		List<Customer> list = customerDao.getByCriteria(criteria);
		return list;
	}
	
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
