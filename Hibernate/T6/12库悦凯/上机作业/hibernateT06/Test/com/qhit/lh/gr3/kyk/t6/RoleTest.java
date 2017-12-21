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
 * @author ���ÿ�
 *TODO
 *2017��12��20������9:37:34
 */
public class RoleTest {
	private BaseService bs = new BaseServiceImpl();

	@Test
	public void add(){
		//��ӽ�ɫ
		Role role = new Role();
		role.setRname("kyk");
		role.setMemo("�߼���Ա");
		//�����˺�
		User user1 = (User) bs.getObjectById(User.class, 1);
		User user2 = (User) bs.getObjectById(User.class, 2);
		//��ɫ���˺������ϵ
		role.getUsers().add(user1);
		role.getUsers().add(user2);
		
		bs.add(role);
	}
	@Test
	public void delete(){
		//�����˺�
		Role role = (Role) bs.getObjectById(User.class, 1);
		
		bs.delete(role);
	}
	@Test
	public void update(){
		//���ؽ�ɫ���޸�
		Role role = (Role) bs.getObjectById(Role.class, 1);
		role.setMemo("�ƽ��Ա");
		//�����˺�
		User user = (User) bs.getObjectById(User.class, 2);
		//������ϵ
		role.getUsers().add(user);
		
		bs.update(role);
	}
	@Test
	public void query(){
		//���ؽ�ɫ��Ϣ
		Role role = (Role) bs.getObjectById(Role.class, 1);
		System.out.println(role);
		System.out.println("������˺�");
		for (Object obj : role.getUsers()) {
			System.out.println(obj);
		}
	}
}
