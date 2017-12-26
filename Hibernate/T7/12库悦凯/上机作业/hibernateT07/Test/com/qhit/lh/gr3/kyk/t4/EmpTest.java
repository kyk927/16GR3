/**
 * 
 */
package com.qhit.lh.gr3.kyk.t4;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.qhit.lh.gr3.kyk.t7.bean.Dept;
import com.qhit.lh.gr3.kyk.t7.bean.Emp;
import com.qhit.lh.gr3.kyk.t7.bean.User;
import com.qhit.lh.gr3.kyk.t7.service.BaseService;
import com.qhit.lh.gr3.kyk.t7.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.kyk.t7.utils.HibernateSessionFactory;

/**
 * @author 库悦凯 TODO 2017年12月11日上午10:23:30
 */
public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * 添加
	 * */
	@Test
	public void add() {
		// 声明员工对象
		Emp emp = new Emp();
		emp.setEname("xncvkjx");
		emp.setBirthday("2017-10-10");
		emp.setSex("m");
		// 分配一个账户
		User user = new User();
		user.setUname("aya");
		user.setUpwd("123456");
		// 建立一对一关系
		emp.setUser(user);// 指定当前员工的账户
		user.setEmp(emp);// 指定当前账户所属员工
		//分配所属部门
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 2);
		//建立多对一关系
		emp.setDept(dept);
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
		emp = (Emp) baseService.getObjectById(emp, 6);
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
		emp = (Emp) baseService.getObjectById(emp, 5);
		emp.setEname("123");
		User user = emp.getUser();
		user.setUname("456");
		// 建立一对一关系
		emp.setUser(user);// 指定当前员工的账户
		user.setEmp(emp);// 指定当前账户所属员工
		//修改所属部门
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 1);
		// 数据操作
		baseService.update(emp);
	}

	/**
	 * 查询
	 * */
	@Test
	public void query() {
		String hql = "select e from Emp e where e.ename like ?";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%g%");
		
		List<Emp> result = query.list();
		for (Emp emp : result) {
			System.out.println("结果"+":"+emp.getEname()+"/"+emp.getSex());
		}

	}

}
