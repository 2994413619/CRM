package club.ityuchao.dao;

import club.ityuchao.domain.User;

public interface UserDao extends BaseDao<User> {

	//���ݵ�¼�����
	User getBuyUserCode(String userCode);
	
}
