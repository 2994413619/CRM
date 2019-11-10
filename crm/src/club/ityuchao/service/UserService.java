package club.ityuchao.service;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.domain.User;
import club.ityuchao.utils.PageBean;

public interface UserService {

	//ͨ����¼�����user����
	User getBuyUserCode(final String codeName);
	
	//������޸��û�
	void saveOrUpdate(User user);
	
	//���user��ҳ����
	PageBean getUserList(DetachedCriteria dCriteria, Integer page, Integer rows);
	
	//ͨ��Id���user����
	User getById(int user_id);
	
	//����ɾ���û�
	void deleteUsers(Integer[] user_ids);
	
	//��¼
	User login(User user);
	
}
