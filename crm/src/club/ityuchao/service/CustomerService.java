package club.ityuchao.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.dao.BaseDao;
import club.ityuchao.domain.Customer;
import club.ityuchao.utils.PageBean;

public interface CustomerService {

	//保存或更新客户
	void saveOrUpdate(Customer customer);

	//获得用户列表
	PageBean getCustomerList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize);

	//通过id获得customer
	Customer getById(Integer cust_id);

	//根据id删除用户
	void deleteById(Integer cust_id);

	//联系人添加或修改时：获得选择的customer列表
	List<Customer> chooseCustomer(String likeString);

}
