package club.ityuchao.service;

import java.util.List;

import club.ityuchao.domain.BaseDict;

public interface BaseDictService {

	//ͨ��dict_type_code��������ֵ�list
	List<BaseDict> getByDictTypeCode(String dict_type_code);
	
}
