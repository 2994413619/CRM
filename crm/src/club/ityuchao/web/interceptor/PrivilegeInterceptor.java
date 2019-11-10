package club.ityuchao.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import club.ityuchao.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user == null) {
			//Î´µÇÂ¼
			return "toLogin";
		} else {
			//ÒÑµÇÂ¼£¬·ÅÐÐ
			return invocation.invoke();
		}
	}

}
