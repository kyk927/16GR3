/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course;

/**
 * @author 库悦凯
 *TODO
 *2018年3月8日下午2:43:51
 */
public interface CourseDao {
	/**
	 * @param parameter
	 * @return
	 */
	public List<Course> getCourseList(Map<String, Object> parameter);
}
