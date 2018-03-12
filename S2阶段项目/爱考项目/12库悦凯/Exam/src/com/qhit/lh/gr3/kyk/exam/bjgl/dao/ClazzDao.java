/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.bjgl.dao;

import java.util.List;

import com.qhit.lh.gr3.kyk.exam.bjgl.bean.ClassInfo;

/**
 * @author 库悦凯
 *TODO
 *2018年3月8日上午9:38:46
 */
public interface ClazzDao {

	/**
	 * @return
	 * 获取班级集合
	 */
	public List<ClassInfo> getClazzList();
}
