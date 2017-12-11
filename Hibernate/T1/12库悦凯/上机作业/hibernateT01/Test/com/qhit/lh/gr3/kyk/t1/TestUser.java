/**
 * 
 */
package com.qhit.lh.gr3.kyk.t1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.kyk.t1.bean.User;
import com.qhit.lh.gr3.kyk.t1.service.BaseService;
import com.qhit.lh.gr3.kyk.t1.service.impl.BaseServiceImpl;

/**
 * @author 库悦凯
 *TODO
 *2017年12月11日上午10:23:30
 */
public class TestUser {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * 添加
	 * */
	@Test
	public void addUser() {
		//声明并实例化对象
		User user = new User();
		user.setUname("kyk");
		user.setUpwd("123456");
		user.setBirthday("1997-10-27");
		user.setSex("m");
		user.setEnable(1);
		//数据操作
		baseService.add(user);
	}
	/**
	 * 删除
	 * */
	@Test
	public void deleteUser() {
		//声明并实例化对象
		User user = new User();
		user.setId(14);
		//数据操作
		baseService.delete(user);
	}
	/**
	 * 修改
	 * */
	@Test
	public void updateUser() {
		//声明并实例化对象
		User user = new User();
		user.setId(12);
		user.setUname("ljt");
		user.setUpwd("654321");
		user.setBirthday("2020-05-29");
		user.setSex("f");
		user.setEnable(1);
		//数据操作
		baseService.update(user);
	}
	/**
	 * 查询
	 * */
	@Test
	public void getAllUser() {
		//声明并实例化对象
		List<Object> list = baseService.getAll("from User");
		//数据操作
		for (Object object : list) {
			User user = (User) object;
			System.out.println(user.toString());
		}
		
	}

}
