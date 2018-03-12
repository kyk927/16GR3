/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.common.dao;

import java.util.List;

import org.hibernate.Query;

import com.qhit.lh.gr3.kyk.exam.common.bean.User;

/**
 * @author 库悦凯
 *TODO
 *2018年1月3日上午11:36:56
 */
public class UserDaoImpl extends BaseDao implements UserDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.common.dao.UserDao#login(com.qhit.lh.gr3.kyk.exam.common.bean.User)
	 */
	@Override
	public User login(User user) {
		String hql = "select user from User user where user.name = ? and user.pwd = ? and user.role = ?";
		Query query = getSession().createQuery(hql);
		query.setString(0, user.getName());
		query.setString(1, user.getPwd());
		query.setInteger(2, user.getRole());
		
		List<User> list = query.list();
		
		if(list != null && list.size() == 1){
			//登陆成功
			return list.get(0);
		}
		return null;
	}

}
