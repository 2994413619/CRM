package club.ityuchao.dao;

import club.ityuchao.domain.User;

public interface UserDao extends BaseDao<User> {

	//根据登录名获得
	User getBuyUserCode(String userCode);
	
}
