package com.qhit.sbms.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.user.bean.User;
import com.qhit.sbms.user.dao.UserDao;
import com.qhit.sbms.utils.DBManager;

/**
 * @author ø‚‘√ø≠
 *
 */
public class UserDaoImpl implements UserDao {
	private Connection con = null;
	private PreparedStatement ps = null;

	@Override
	public User doLogin(String userName, String userPassword) {
		con = DBManager.getConnection();
		User user = null;
		String sql = "select * from tb_user where userName =? and userPassword =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User(
						rs.getInt("userId"), 
						rs.getString("userName"), 
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"),
						rs.getInt("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps,con);
		}
		return user;
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql ="insert into tb_user values(?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getType());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public PageBean getPageBeanU(PageBean pagebean) {
		User user2 = null;
		con = DBManager.getConnection();
		String sql = " select top "
				+ pagebean.getPagesize()
				+" u.userId,u.userName,u.userSex,u.userAge,"
				+" u.telephone,u.address,u.type,u.pic"
				+" from tb_user u"
				+" where u.userId"
				+" not in ( "
				+" select top "
				+ pagebean.getPagesize() * (pagebean.getP() - 1)
				+" u.userId "
				+" from tb_user u ) ; ";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user2 = new User(
						rs.getInt("userId"), 
						rs.getString("userName"),  
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"),
						rs.getInt("type"));
				pagebean.addData(user2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return pagebean;
	}

}
