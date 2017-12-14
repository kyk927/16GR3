/**
 * 
 */
package com.qhit.lh.gr3.kyk.t2;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.kyk.t2.bean.Emp;
import com.qhit.lh.gr3.kyk.t2.bean.User;
import com.qhit.lh.gr3.kyk.t2.service.BaseService;
import com.qhit.lh.gr3.kyk.t2.service.impl.BaseServiceImpl;

/**
 * @author 库悦凯 TODO 2017年12月11日上午10:23:30
 */
public class TestUser {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * 添加
	 * */
	@Test
	public void add() {
		// 声明员工对象
		Emp emp = new Emp();
		emp.setEname("qwe");
		emp.setBirthday("2017-10-10");
		emp.setSex("f");
		emp.setDeptid(0);
		// 分配一个账户
		User user = new User();
		user.setUname("kyk");
		user.setUpwd("123456");
		// 建立一对一关系
		emp.setUser(user);// 指定当前员工的账户
		user.setEmp(emp);// 指定当前账户所属员工
		// 数据操作
		baseService.add(emp);
	}

	/**
	 * 删除
	 * */
	@Test
	public void delete() {
		// 声明并实例化对象
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 1);
		// 数据操作
		baseService.delete(emp);
	}

	/**
	 * 修改
	 * */
	@Test
	public void update() {
		// 声明员工对象
		Emp emp = new Emp();
		emp.setEid(1);
		emp.setEname("qwe");
		emp.setBirthday("2017-10-10");
		emp.setSex("f");
		emp.setDeptid(1);
		// 分配一个账户
		User user = new User();
		user.setUid(1);
		user.setUname("kyk");
		user.setUpwd("123456");
		// 建立一对一关系
		emp.setUser(user);// 指定当前员工的账户
		user.setEmp(emp);// 指定当前账户所属员工
		// 数据操作
		baseService.update(emp);
	}

	/**
	 * 查询
	 * */
	@Test
	public void query() {
		// 声明并实例化对象
		List<Object> list = baseService.getAll("from Emp");
		// 数据操作
		for (Object object : list) {
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}

	}

}
