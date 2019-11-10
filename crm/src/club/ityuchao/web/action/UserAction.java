package club.ityuchao.web.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import club.ityuchao.domain.User;
import club.ityuchao.service.UserService;
import club.ityuchao.utils.PageBean;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private UserService userService;
	
	private User user = new User();
	private Integer[] user_ids;
	private Integer page;//easyUI���ݵĵ�ǰҳ�ı�����
	private Integer rows;//easyUI���ݵ�ÿҳ��ʾ�����ı�����

	//���user��ҳ����
	public String userList() {
		//1��ͨ��service���÷�ҳ����
		DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
		PageBean pageBean = userService.getUserList(dCriteria,page,rows);
		
		//2������ҳ����ת��Ϊjson����
		//easyUI��Ҫ�����ݸ�ʽ��{total:xx,rows:[{},{},{]]}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", pageBean.getTotalCount());
		map.put("rows", pageBean.getList());
		
		//ʹ��gson��mapת��Ϊjson��ʽ���ַ���
		Gson gson = new Gson();
		String json = gson.toJson(map);

		//3����json���ظ�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//������޸�user
	public String saveOrUpdate() {
		userService.saveOrUpdate(user);
		return "toUserList";
	}
	
	//ͨ��user_id���user����
	public String getById() {
		//1��ͨ��service���user����
		User returnUser = userService.getById(user.getUser_id());
		
		//2����user����ת��Ϊjson�ַ���
		Gson gson = new Gson();
		String json = gson.toJson(returnUser);
		
		//3����json���ظ�ǰ̨
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//����ɾ���û�
	public String deleteUsers() {
		userService.deleteUsers(user_ids);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//�û���¼
	public String login() {
		//1��ͨ��service�ж��Ƿ���ڸ��û��������ظ�user����
		User userReturn = userService.login(user);
		String retrunStr = "defeated";
		
		//2����user����session��
		if(userReturn!=null) {
			ActionContext.getContext().getSession().put("user", userReturn);
			retrunStr = "success";
		}
		
		//3�������Ƿ�ɹ���¼��message
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/text;charset=utf-8");
		try {
			response.getWriter().write(retrunStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public Integer[] getUser_ids() {
		return user_ids;
	}

	public void setUser_ids(Integer[] user_ids) {
		this.user_ids = user_ids;
	}

	@Override
	public User getModel() {
		return user;
	}
	
}
