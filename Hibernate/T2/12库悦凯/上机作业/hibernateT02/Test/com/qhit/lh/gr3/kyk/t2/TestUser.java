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
 * @author ���ÿ� TODO 2017��12��11������10:23:30
 */
public class TestUser {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * ���
	 * */
	@Test
	public void add() {
		// ����Ա������
		Emp emp = new Emp();
		emp.setEname("qwe");
		emp.setBirthday("2017-10-10");
		emp.setSex("f");
		emp.setDeptid(0);
		// ����һ���˻�
		User user = new User();
		user.setUname("kyk");
		user.setUpwd("123456");
		// ����һ��һ��ϵ
		emp.setUser(user);// ָ����ǰԱ�����˻�
		user.setEmp(emp);// ָ����ǰ�˻�����Ա��
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
		emp = (Emp) baseService.getObjectById(emp, 1);
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
		emp.setEid(1);
		emp.setEname("qwe");
		emp.setBirthday("2017-10-10");
		emp.setSex("f");
		emp.setDeptid(1);
		// ����һ���˻�
		User user = new User();
		user.setUid(1);
		user.setUname("kyk");
		user.setUpwd("123456");
		// ����һ��һ��ϵ
		emp.setUser(user);// ָ����ǰԱ�����˻�
		user.setEmp(emp);// ָ����ǰ�˻�����Ա��
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
