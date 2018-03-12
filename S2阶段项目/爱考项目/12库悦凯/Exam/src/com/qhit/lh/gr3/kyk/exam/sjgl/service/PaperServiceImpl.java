/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.sjgl.service;

import java.util.Map;

import com.qhit.lh.gr3.kyk.exam.common.bean.PageBean;
import com.qhit.lh.gr3.kyk.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.kyk.exam.sjgl.dao.PaperDao;
import com.qhit.lh.gr3.kyk.exam.sjgl.dao.PaperDaoImpl;

/**
 * @author 库悦凯
 *TODO
 *2018年1月10日上午10:44:48
 */
public class PaperServiceImpl implements PaperService {
	private PaperDao pDao = new PaperDaoImpl();

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.sjgl.service.PaperService#getPaperList(com.qhit.lh.gr3.kyk.exam.common.bean.PageBean, java.util.Map, int)
	 */
	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean,
			Map<String, Object> parameter, int pageIndex) {
		// TODO Auto-generated method stub
		return pDao.getPaperList(pageBean, parameter, pageIndex);
	}

}
