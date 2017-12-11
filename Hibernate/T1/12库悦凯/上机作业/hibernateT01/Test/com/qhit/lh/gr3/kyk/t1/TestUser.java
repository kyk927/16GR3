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
 * @author ���ÿ�
 *TODO
 *2017��12��11������10:23:30
 */
public class TestUser {
	private BaseService baseService = new BaseServiceImpl();

	/**
	 * ���
	 * */
	@Test
	public void addUser() {
		//������ʵ��������
		User user = new User();
		user.setUname("kyk");
		user.setUpwd("123456");
		user.setBirthday("1997-10-27");
		user.setSex("m");
		user.setEnable(1);
		//���ݲ���
		baseService.add(user);
	}
	/**
	 * ɾ��
	 * */
	@Test
	public void deleteUser() {
		//������ʵ��������
		User user = new User();
		user.setId(14);
		//���ݲ���
		baseService.delete(user);
	}
	/**
	 * �޸�
	 * */
	@Test
	public void updateUser() {
		//������ʵ��������
		User user = new User();
		user.setId(12);
		user.setUname("ljt");
		user.setUpwd("654321");
		user.setBirthday("2020-05-29");
		user.setSex("f");
		user.setEnable(1);
		//���ݲ���
		baseService.update(user);
	}
	/**
	 * ��ѯ
	 * */
	@Test
	public void getAllUser() {
		//������ʵ��������
		List<Object> list = baseService.getAll("from User");
		//���ݲ���
		for (Object object : list) {
			User user = (User) object;
			System.out.println(user.toString());
		}
		
	}

}
