package club.ityuchao.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import club.ityuchao.dao.UserDao;
import club.ityuchao.domain.User;
import club.ityuchao.service.UserService;
import club.ityuchao.web.action.UserAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {

	@Resource(name="userAction")
	private UserAction userAction;
	
	//����ͨ��Spring����action
	@Test
	public void test() {
		System.out.println(userAction);
	}
	
	//����ʹ��Spring����sessionFactory
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Test
	public void test2() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		User user = new User();
		user.setCodeName("tom");
		user.setName("��ķ");
		user.setPassword("1234");
		session.save(user);
		//----------------------------------------------------
		tx.commit();
		session.close();
	}
	
	//����HibernateTemplate
	@Resource(name="userDao")
	private UserDao userDao;
	@Test
	public void test3() {
		User user = userDao.getBuyUserCode("rose");
		System.out.println(user);
	}
	
	//����aop����
	@Resource(name="userService")
	private UserService userService;
	@Test
	public void test4() {
		User user = new User();
		user.setCodeName("lily");
		user.setName("����");
		user.setPassword("4321");
		userService.saveOrUpdate(user);
	}
	
	@Test
	public void test5() {
		/*User user = userService.getBuyUserCode("tom");
		System.out.println(user);*/
		/*User user = userDao.getById(2);
		System.out.println(user);*/
		/*DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
		Integer count = userDao.getTotalCount(dCriteria);
		System.out.println(count);*/
		DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
		List<User> list = userDao.getPageList(dCriteria, 0, 4);
		System.out.println(list);
	}
	
}
