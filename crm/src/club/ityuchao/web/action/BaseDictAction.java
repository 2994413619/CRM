package club.ityuchao.web.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import club.ityuchao.domain.BaseDict;
import club.ityuchao.service.BaseDictService;

public class BaseDictAction extends ActionSupport {

	private BaseDictService baseDictService;
	private String dict_type_code;
	
	@Override
	public String execute() throws Exception {
		//1、获得访问的数据
		List<BaseDict> list = baseDictService.getByDictTypeCode(dict_type_code);
		//2、将list转换为json
		Gson gson = new Gson();
		String json = gson.toJson(list);
		//3、响应到客户端
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
		return null;
	}

	public BaseDictService getBaseDictService() {
		return baseDictService;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

}
