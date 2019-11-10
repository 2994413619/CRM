package club.ityuchao.dao;

import java.util.List;

import club.ityuchao.domain.BaseDict;
import club.ityuchao.domain.User;

public interface BaseDictDao extends BaseDao<BaseDict> {

	//ͨ��dict_type_code��������ֵ�list
	List<BaseDict> getByDictTypeCode(String dict_type_code);

}
