package club.ityuchao.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import club.ityuchao.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	private Class clazz;//用于接受运行时期的泛型
	
	public BaseDaoImpl() {
		//Type接口是反射类型的最顶层接口，class也是该接口的实现类，就像所有对象顶层对象Object一样
		ParameterizedType ptClass = (ParameterizedType)this.getClass().getGenericSuperclass();//获得带有泛型类型的父类
		clazz = (Class) ptClass.getActualTypeArguments()[0];//该方法获得的是一个泛型类型的数组
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}
	
	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);
		this.delete(t);
	}

	@Override
	public T getById(Serializable id) {
		return (T)getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dCriteria) {
		//设置聚合函数
		dCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dCriteria);
		//清除聚合函数
		dCriteria.setProjection(null);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	public List<T> getPageList(DetachedCriteria dCriteria, Integer start, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dCriteria, start, pageSize);
		return list;
	}

	@Override
	public List<T> getByCriteria(DetachedCriteria dCriteria) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dCriteria);
		return list;
	}

}
