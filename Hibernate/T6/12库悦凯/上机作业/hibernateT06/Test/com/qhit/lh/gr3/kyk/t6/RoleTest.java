/**
 * 
 */
package com.qhit.lh.gr3.kyk.t6;

import org.junit.Test;

import com.qhit.lh.gr3.kyk.t6.bean.Role;
import com.qhit.lh.gr3.kyk.t6.bean.User;
import com.qhit.lh.gr3.kyk.t6.service.BaseService;
import com.qhit.lh.gr3.kyk.t6.service.impl.BaseServiceImpl;

/**
 * @author 库悦凯
 *TODO
 *2017年12月20日上午9:37:34
 */
public class RoleTest {
	private BaseService bs = new BaseServiceImpl();

	@Test
	public void add(){
		//添加角色
		Role role = new Role();
		role.setRname("kyk");
		role.setMemo("高级会员");
		//加载账号
		User user1 = (User) bs.getObjectById(User.class, 1);
		User user2 = (User) bs.getObjectById(User.class, 2);
		//角色和账号添加联系
		role.getUsers().add(user1);
		role.getUsers().add(user2);
		
		bs.add(role);
	}
	@Test
	public void delete(){
		//加载账号
		Role role = (Role) bs.getObjectById(User.class, 1);
		
		bs.delete(role);
	}
	@Test
	public void update(){
		//加载角色并修改
		Role role = (Role) bs.getObjectById(Role.class, 1);
		role.setMemo("黄金会员");
		//加载账号
		User user = (User) bs.getObjectById(User.class, 2);
		//建立联系
		role.getUsers().add(user);
		
		bs.update(role);
	}
	@Test
	public void query(){
		//加载角色信息
		Role role = (Role) bs.getObjectById(Role.class, 1);
		System.out.println(role);
		System.out.println("分配的账号");
		for (Object obj : role.getUsers()) {
			System.out.println(obj);
		}
	}
}
