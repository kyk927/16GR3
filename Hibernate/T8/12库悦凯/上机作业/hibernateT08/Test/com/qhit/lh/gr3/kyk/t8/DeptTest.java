/**
 * 
 */
package com.qhit.lh.gr3.kyk.t8;

import org.junit.Test;

import com.qhit.lh.gr3.kyk.t8.bean.Dept;
import com.qhit.lh.gr3.kyk.t8.bean.Emp;
import com.qhit.lh.gr3.kyk.t8.service.BaseService;
import com.qhit.lh.gr3.kyk.t8.service.impl.BaseServiceImpl;

/**
 * @author ���ÿ�
 *TODO
 *2017��12��14������4:32:13
 */
public class DeptTest {
	private BaseService bs = new BaseServiceImpl();

	@Test
	public void add(){
		//�½�����
		Dept dept = new Dept();
		dept.setDname("������");
		//���Ա��
		Emp emp1 = new Emp();
		emp1.setEname("asd");
		emp1.setBirthday("2017-10-10");
		emp1.setSex("m");
		
		Emp emp2 = new Emp();
		emp2.setEname("asdfg");
		emp2.setBirthday("2027-10-10");
		emp2.setSex("f");
		
		dept.getEmps().add(emp1);
		dept.getEmps().add(emp2);
		
		bs.add(dept);
	}
	
	@Test
	public void delete(){
		Dept dept = new Dept();
		dept = (Dept) bs.getObjectById(dept, 2);
		
		bs.delete(dept);
	}
	
	@Test
	public void update(){
		Dept dept = new Dept();
		dept = (Dept) bs.getObjectById(dept, 3);
		dept.setDname("�⽻��");
		
		bs.update(dept);
	}
	
	@Test
	public void query(){
		Dept dept = new Dept();
		dept = (Dept) bs.getObjectById(dept, 1);
		
		for(Emp emp:dept.getEmps()){
			System.out.println(dept.getDname()+":"+emp.getEname());
		}
	}
}
