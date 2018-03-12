/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.bjgl.service;

import java.util.List;

import com.qhit.lh.gr3.kyk.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.gr3.kyk.exam.bjgl.dao.ClazzDao;
import com.qhit.lh.gr3.kyk.exam.bjgl.dao.ClazzDaoImpl;

/**
 * @author 库悦凯
 *TODO
 *2018年3月8日上午9:39:57
 */
public class ClazzServiceImpl implements ClazzService {
	private ClazzDao clazzDao = new ClazzDaoImpl();

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.bjgl.service.ClazzService#getClazzList()
	 */
	@Override
	public List<ClassInfo> getClazzList() {
		// TODO Auto-generated method stub
		return clazzDao.getClazzList();
	}

}
