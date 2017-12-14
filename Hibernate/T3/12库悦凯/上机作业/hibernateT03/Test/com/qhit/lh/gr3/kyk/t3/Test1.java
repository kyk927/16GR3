/**
 * 
 */
package com.qhit.lh.gr3.kyk.t3;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.kyk.t3.bean.Dept;
import com.qhit.lh.gr3.kyk.t3.bean.Emp;
import com.qhit.lh.gr3.kyk.t3.bean.User;
import com.qhit.lh.gr3.kyk.t3.service.BaseService;
import com.qhit.lh.gr3.kyk.t3.service.impl.BaseServiceImpl;

/**
 * @author ���ÿ� TODO 2017��12��11������10:23:30
 */
public class Test1 {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * ���
	 * */
	@Test
	public void add() {
		// ����Ա������
		Emp emp = new Emp();
		emp.setEname("asd");
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
		emp = (Emp) baseService.getObjectById(emp, 2);
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
	 * ��ѯ
	 * */
	@Test
	public void query() {
		// ������ʵ��������
		List<Object> list = baseService.getAll("from Emp");
		// ���ݲ���
		for (Object object : list) {
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}

	}

}
