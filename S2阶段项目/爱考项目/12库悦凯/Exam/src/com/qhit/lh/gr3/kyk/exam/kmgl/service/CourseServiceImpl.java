/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.kmgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.kyk.exam.kmgl.dao.CourseDao;
import com.qhit.lh.gr3.kyk.exam.kmgl.dao.CourseDaoImpl;

/**
 * @author 库悦凯
 *TODO
 *2018年3月8日下午2:44:56
 */
public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao = new CourseDaoImpl();

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.kmgl.service.CourseService#getCourseList(java.util.Map)
	 */
	@Override
	public List<Course> getCourseList(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return courseDao.getCourseList(parameter);
	}

}
