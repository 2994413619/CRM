package club.ityuchao.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao <T>{

	//增或更新
	void saveOrUpdate(T t);
	
	//删
	void delete(T t);
	
	//删
	void delete(Serializable id);
	
	//查 根据id查询
	T getById(Serializable id);
	
	//查 符合条件的总记录数
	Integer getTotalCount(DetachedCriteria dCriteria);
	
	//查 查询分页列表数据
	List<T> getPageList(DetachedCriteria dCriteria, Integer start, Integer pageSize);
	
	//根据detachCriteria获得对象集合
	List<T> getByCriteria(DetachedCriteria dCriteria);
	
}
