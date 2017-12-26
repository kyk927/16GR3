/**
 * 
 */
package com.qhit.lh.gr3.kyk.t8.dao;

import java.util.List;

/**
 * @author 库悦凯
 *TODO
 *2017年12月11日上午9:54:42
 */
public interface BaseDao {
	/**
	 * @param obj
	 * 增
	 */
	public void add(Object obj);
	/**
	 * @param obj
	 * 删
	 */
	public void delete(Object obj);
	/**
	 * @param obj
	 * 改
	 */
	public void update(Object obj);
	/**
	 * @param fromObject
	 * 查
	 * @return
	 */
	public List<Object> getAll(String fromObject);
	/**
	 * @param object
	 * @param id
	 * 根据id查询
	 * @return
	 */
	public Object getObjectById(Object object,int id);
}
