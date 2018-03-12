/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.bjgl.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.kyk.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.gr3.kyk.exam.bjgl.service.ClazzService;
import com.qhit.lh.gr3.kyk.exam.bjgl.service.ClazzServiceImpl;

/**
 * @author 库悦凯
 *TODO
 *2018年3月8日上午9:34:15
 */
public class ClazzAction extends ActionSupport{
	private ClazzService clazzService = new ClazzServiceImpl();
	private List<ClassInfo> listClazz;

	public String getClazzList(){
		listClazz = clazzService.getClazzList();
		return "getClazzList";
	}

	public ClazzService getClazzService() {
		return clazzService;
	}

	public void setClazzService(ClazzService clazzService) {
		this.clazzService = clazzService;
	}

	public List<ClassInfo> getListClazz() {
		return listClazz;
	}

	public void setListClazz(List<ClassInfo> listClazz) {
		this.listClazz = listClazz;
	}
}
