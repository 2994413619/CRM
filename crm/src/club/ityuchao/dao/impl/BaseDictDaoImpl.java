package club.ityuchao.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import club.ityuchao.dao.BaseDictDao;
import club.ityuchao.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@Override
	public List<BaseDict> getByDictTypeCode(String dict_type_code) {
		//1������criteria����
		DetachedCriteria dCriteria = DetachedCriteria.forClass(BaseDict.class);
		//2����ӹ���
		dCriteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		//3����ѯ
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dCriteria);
		return list;
	}

}
