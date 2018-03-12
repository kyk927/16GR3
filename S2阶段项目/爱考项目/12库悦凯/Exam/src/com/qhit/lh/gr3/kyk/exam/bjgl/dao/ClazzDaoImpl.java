/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.bjgl.dao;

import java.util.List;

import com.qhit.lh.gr3.kyk.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.gr3.kyk.exam.common.dao.BaseDao;

/**
 * @author 库悦凯
 *TODO
 *2018年3月8日上午9:39:35
 */
public class ClazzDaoImpl extends BaseDao implements ClazzDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.bjgl.dao.ClazzDao#getClazzList()
	 */
	@Override
	public List<ClassInfo> getClazzList() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from ClassInfo").list();
	}

}
