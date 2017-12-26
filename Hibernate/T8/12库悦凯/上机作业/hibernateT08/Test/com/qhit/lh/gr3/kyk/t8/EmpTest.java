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
 * @author ���ÿ� TODO 2017��12��11������10:23:30
 */
public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * ���
	 * */
	@Test
	public void add() {
		// ����Ա������
		Emp emp = new Emp();
		emp.setEname("xncvkjx");
		emp.setBirthday("2017-10-10");
		emp.setSex("m");
		// ����һ���˻�
		User user = new User();
		user.setUname("aya");
		user.setUpwd("123456");
		// ����һ��һ��ϵ
		emp.setUser(user);// ָ����ǰԱ�����˻�
		user.setEmp(emp);// ָ����ǰ�˻�����Ա��
		//������������
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 2);
		//�������һ��ϵ
		emp.setDept(dept);
		// ���ݲ���
		baseService.add(emp);
	}

	/**
	 * ɾ��
	 * */
	@Test
	public void delete() {
		// ������ʵ��������
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 6);
		// ���ݲ���
		baseService.delete(emp);
	}

	/**
	 * �޸�
	 * */
	@Test
	public void update() {
		// ����Ա������
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 5);
		emp.setEname("123");
		User user = emp.getUser();
		user.setUname("456");
		// ����һ��һ��ϵ
		emp.setUser(user);// ָ����ǰԱ�����˻�
		user.setEmp(emp);// ָ����ǰ�˻�����Ա��
		//�޸���������
		Dept dept = new Dept();
		dept = (Dept) baseService.getObjectById(dept, 1);
		// ���ݲ���
		baseService.update(emp);
	}

	/**
	 * hqlģ����ѯ
	 * */
	@Test
	public void query() {
		String hql = "select e from Emp e where e.ename like ?";
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%g%");
		
		List<Emp> result = query.list();
		for (Emp emp : result) {
			System.out.println("���"+":"+emp.getEname()+"/"+emp.getSex());
		}

	}
	/**
	 * QBC������ѯ��ͶӰ��ѯ
	 * */
	@Test
	public void query1(){
		Session session = HibernateSessionFactory.getSession();
		//������ѯ
		Criteria criteria = session.createCriteria(Emp.class)
				.add(Restrictions.like("emp", "%g%"));
		//ͶӰ��ѯ
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
	 * QBCͳ�Ʋ�ѯ
	 * */
	@Test
	public void query2(){
		Session session = HibernateSessionFactory.getSession();
		//������ѯ
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emps", FetchMode.JOIN)
				.createAlias("emps", "e");
		//ͶӰ��ѯ
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
