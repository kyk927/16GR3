/**
 * 
 */
package com.qhit.lh.gr3.kyk.t6.service;

import java.util.List;

/**
 * @author 库悦凯
 *TODO
 *2017年12月11日上午9:55:39
 */
public interface BaseService {
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
	public Object getObjectById(Class clas,int id);
}
