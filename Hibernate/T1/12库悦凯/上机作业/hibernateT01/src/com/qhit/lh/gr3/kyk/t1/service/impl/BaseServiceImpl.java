/**
 * 
 */
package com.qhit.lh.gr3.kyk.t1.service.impl;

import java.util.List;

import com.qhit.lh.gr3.kyk.t1.dao.BaseDao;
import com.qhit.lh.gr3.kyk.t1.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.kyk.t1.service.BaseService;

/**
 * @author 库悦凯
 *TODO
 *2017年12月11日上午9:56:44
 */
public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao = new BaseDaoImpl();

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.t1.service.BaseService#add(java.lang.Object)
	 */
	@Override
	public void add(Object obj) {
		baseDao.add(obj);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.t1.service.BaseService#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object obj) {
		baseDao.delete(obj);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.t1.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(Object obj) {
		baseDao.update(obj);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.t1.service.BaseService#getAll(java.lang.String)
	 */
	@Override
	public List<Object> getAll(String fromObject) {
		return baseDao.getAll(fromObject);
	}

}
