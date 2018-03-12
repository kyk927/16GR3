/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.sjgl.service;

import java.util.Map;

import com.qhit.lh.gr3.kyk.exam.common.bean.PageBean;
import com.qhit.lh.gr3.kyk.exam.sjgl.bean.Paper;

/**
 * @author 库悦凯
 *TODO
 *2018年1月10日上午10:44:37
 */
public interface PaperService {
	/**
	 * @param pageBean
	 * @param parameter
	 * @param pageIndex
	 * @return
	 * 查询试卷列表
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean,
			Map<String,Object> parameter,int pageIndex);

}
