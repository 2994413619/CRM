package club.ityuchao.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import club.ityuchao.dao.UserDao;
import club.ityuchao.domain.User;
import club.ityuchao.service.UserService;
import club.ityuchao.utils.PageBean;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public User getBuyUserCode(String codeName) {
		return userDao.getBuyUserCode(codeName);
	}

	@Override
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}
	
	@Override
	public PageBean getUserList(DetachedCriteria dCriteria, Integer page, Integer rows) {
		//1、查询总记录数
		Integer totalCount = userDao.getTotalCount(dCriteria);
		//2、创建PageBean
		PageBean pageBean = new PageBean(page, totalCount, rows);
		//3、查询userList
		List<User> list = userDao.getPageList(dCriteria, pageBean.getStart(), pageBean.getPageSize());
		//4、封装userList到PageBean
		pageBean.setList(list);
		return pageBean;
	}
	
	@Override
	public void deleteUsers(Integer[] user_ids) {
		for (Integer user_id : user_ids) {
			userDao.delete(user_id);
		}
		
	}
	
	@Override
	public User getById(int user_id) {
		return userDao.getById(user_id);
		
	}
	
	@Override
	public User login(User user) {
		DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
		dCriteria.add(Restrictions.eq("codeName", user.getCodeName()));
		List<User> list = userDao.getByCriteria(dCriteria);
		if(list.size() > 0) {
			if(user.getPassword().equals(list.get(0).getPassword()))
				return list.get(0);
		}
		return null;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


}
