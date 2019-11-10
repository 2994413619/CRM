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
	private Integer page;//easyUI传递的当前页的变量名
	private Integer rows;//easyUI传递的每页显示条数的变量名

	//获得user分页数据
	public String userList() {
		//1、通过service层获得分页数据
		DetachedCriteria dCriteria = DetachedCriteria.forClass(User.class);
		PageBean pageBean = userService.getUserList(dCriteria,page,rows);
		
		//2、将分页数据转换为json数据
		//easyUI需要的数据格式：{total:xx,rows:[{},{},{]]}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", pageBean.getTotalCount());
		map.put("rows", pageBean.getList());
		
		//使用gson将map转换为json格式的字符串
		Gson gson = new Gson();
		String json = gson.toJson(map);

		//3、将json返回给前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//保存或修改user
	public String saveOrUpdate() {
		userService.saveOrUpdate(user);
		return "toUserList";
	}
	
	//通过user_id获得user对象
	public String getById() {
		//1、通过service获得user对象
		User returnUser = userService.getById(user.getUser_id());
		
		//2、把user对象转换为json字符串
		Gson gson = new Gson();
		String json = gson.toJson(returnUser);
		
		//3、将json返回给前台
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//批量删除用户
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
	
	//用户登录
	public String login() {
		//1、通过service判断是否存在该用户，并返回该user对象
		User userReturn = userService.login(user);
		String retrunStr = "defeated";
		
		//2、把user放入session中
		if(userReturn!=null) {
			ActionContext.getContext().getSession().put("user", userReturn);
			retrunStr = "success";
		}
		
		//3、返回是否成功登录的message
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
