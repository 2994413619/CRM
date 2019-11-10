package club.ityuchao.service.impl;

import java.util.List;

import club.ityuchao.dao.BaseDictDao;
import club.ityuchao.domain.BaseDict;
import club.ityuchao.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao baseDicdao;
	
	@Override
	public List<BaseDict> getByDictTypeCode(String dict_type_code) {
		return baseDicdao.getByDictTypeCode(dict_type_code);
	}

	public BaseDictDao getBaseDicdao() {
		return baseDicdao;
	}

	public void setBaseDicdao(BaseDictDao baseDicdao) {
		this.baseDicdao = baseDicdao;
	}

}
