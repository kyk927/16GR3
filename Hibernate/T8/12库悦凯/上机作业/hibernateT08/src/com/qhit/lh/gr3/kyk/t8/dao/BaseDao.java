/**
 * 
 */
package com.qhit.lh.gr3.kyk.t8.dao;

import java.util.List;

/**
 * @author ���ÿ�
 *TODO
 *2017��12��11������9:54:42
 */
public interface BaseDao {
	/**
	 * @param obj
	 * ��
	 */
	public void add(Object obj);
	/**
	 * @param obj
	 * ɾ
	 */
	public void delete(Object obj);
	/**
	 * @param obj
	 * ��
	 */
	public void update(Object obj);
	/**
	 * @param fromObject
	 * ��
	 * @return
	 */
	public List<Object> getAll(String fromObject);
	/**
	 * @param object
	 * @param id
	 * ����id��ѯ
	 * @return
	 */
	public Object getObjectById(Object object,int id);
}
