package club.ityuchao.service;

import org.hibernate.criterion.DetachedCriteria;

import club.ityuchao.domain.User;
import club.ityuchao.utils.PageBean;

public interface UserService {

	//通过登录名获得user对象
	User getBuyUserCode(final String codeName);
	
	//保存或修改用户
	void saveOrUpdate(User user);
	
	//获得user分页数据
	PageBean getUserList(DetachedCriteria dCriteria, Integer page, Integer rows);
	
	//通过Id获得user对象
	User getById(int user_id);
	
	//批量删除用户
	void deleteUsers(Integer[] user_ids);
	
	//登录
	User login(User user);
	
}
