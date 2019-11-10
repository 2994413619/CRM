package club.ityuchao.dao;

import java.util.List;

import club.ityuchao.domain.BaseDict;
import club.ityuchao.domain.User;

public interface BaseDictDao extends BaseDao<BaseDict> {

	//通过dict_type_code获得数据字典list
	List<BaseDict> getByDictTypeCode(String dict_type_code);

}
