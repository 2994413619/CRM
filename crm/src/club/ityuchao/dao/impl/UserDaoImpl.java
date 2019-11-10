package club.ityuchao.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import club.ityuchao.dao.UserDao;
import club.ityuchao.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	//hql
	/*public User getBuyUserCode(final String userCode) {
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql = "from User where codeName=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, userCode);
				User user = (User)query.uniqueResult();
				return user;
			}
		});
	}*/
	
	//criteria
	public User getBuyUserCode(final String codeName) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("codeName", codeName));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}
	
}
