/**
 * 
 */
package com.qhit.lh.gr3.kyk.t8;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.kyk.t8.bean.Dept;
import com.qhit.lh.gr3.kyk.t8.bean.Emp;
import com.qhit.lh.gr3.kyk.t8.bean.User;
import com.qhit.lh.gr3.kyk.t8.service.BaseService;
import com.qhit.lh.gr3.kyk.t8.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.kyk.t8.utils.HibernateSessionFactory;

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
	 * hql模糊查询
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
	/**
	 * QBC基本查询和投影查询
	 * */
	@Test
	public void query1(){
		Session session = HibernateSessionFactory.getSession();
		//基本查询
		Criteria criteria = session.createCriteria(Emp.class)
				.add(Restrictions.like("emp", "%g%"));
		//投影查询
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.property("ename"))
				.add(Projections.property("sex"))
				.add(Projections.property("birthday"));
		criteria.setProjection(projectionList);
		for (Object[] o : (List<Object[]>)criteria.list()) {
			System.out.println(o[0]+","+o[1]+","+o[2]);
		}
	}
	/**
	 * QBC统计查询
	 * */
	@Test
	public void query2(){
		Session session = HibernateSessionFactory.getSession();
		//基本查询
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emps", FetchMode.JOIN)
				.createAlias("emps", "e");
		//投影查询
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.property("deptid"))
				.add(Projections.property("dname"))
				.add(Projections.property("address"))
				.add(Projections.count("e.deptid"));
		criteria.setProjection(projectionList);
		for (Object[] o : (List<Object[]>)criteria.list()) {
			System.out.println(o[0]+","+o[1]+","+o[2]+","+o[3]);
		}
	}
}
