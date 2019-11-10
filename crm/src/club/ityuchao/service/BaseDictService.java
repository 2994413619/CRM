package club.ityuchao.service;

import java.util.List;

import club.ityuchao.domain.BaseDict;

public interface BaseDictService {

	//通过dict_type_code获得数据字典list
	List<BaseDict> getByDictTypeCode(String dict_type_code);
	
}
