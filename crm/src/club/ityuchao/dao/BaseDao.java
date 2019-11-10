package club.ityuchao.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao <T>{

	//�������
	void saveOrUpdate(T t);
	
	//ɾ
	void delete(T t);
	
	//ɾ
	void delete(Serializable id);
	
	//�� ����id��ѯ
	T getById(Serializable id);
	
	//�� �����������ܼ�¼��
	Integer getTotalCount(DetachedCriteria dCriteria);
	
	//�� ��ѯ��ҳ�б�����
	List<T> getPageList(DetachedCriteria dCriteria, Integer start, Integer pageSize);
	
	//����detachCriteria��ö��󼯺�
	List<T> getByCriteria(DetachedCriteria dCriteria);
	
}
