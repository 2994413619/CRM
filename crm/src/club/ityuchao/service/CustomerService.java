package club.ityuchao.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.dao.BaseDao;
import club.ityuchao.domain.Customer;
import club.ityuchao.utils.PageBean;

public interface CustomerService {

	//�������¿ͻ�
	void saveOrUpdate(Customer customer);

	//����û��б�
	PageBean getCustomerList(DetachedCriteria dCriteria, Integer currentPage, Integer pageSize);

	//ͨ��id���customer
	Customer getById(Integer cust_id);

	//����idɾ���û�
	void deleteById(Integer cust_id);

	//��ϵ����ӻ��޸�ʱ�����ѡ���customer�б�
	List<Customer> chooseCustomer(String likeString);

}
