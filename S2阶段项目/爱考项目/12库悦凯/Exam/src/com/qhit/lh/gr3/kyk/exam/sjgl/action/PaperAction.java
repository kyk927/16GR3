/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.sjgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.kyk.exam.common.bean.PageBean;
import com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.kyk.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.kyk.exam.sjgl.service.PaperService;
import com.qhit.lh.gr3.kyk.exam.sjgl.service.PaperServiceImpl;
import com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDaoImpl;
import com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService;
import com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.gr3.kyk.exam.tkgl.utils.RandomQuestionsUtils;

/**
 * @author 库悦凯
 *TODO
 *2018年1月10日上午11:46:21
 */
public class PaperAction extends ActionSupport{
	private PaperService ps = new PaperServiceImpl();
	private QuestionService qs = new QuestionServiceImpl();
	private List<Course> listCourse = new ArrayList<>();
	private List<Paper> listPaper = new ArrayList<>();
	//试题列表分页数据
	private PageBean<Paper> pageBean = new PageBean<>();
	private int pageIndex = 1;
	//条件参数
	private Course course;
	private Paper paper;
	private List<WrittenQuestion> listRE,listRN,listRD,listCE,listCN,listCD;
	private int radioEasy,radioNormal,radioDiff,cbEasy,cbNormal,cbDiff;
	
	/**
	 * @return
	 * 获取试卷列表
	 */
	public String getPaperList(){
		//设置参数
		Map<String, Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("csId", course.getCsId());
		}
		if(paper != null){
			parameter.put("pType", paper.getPtype());
			parameter.put("pState", paper.getPstate());
		}
		//查询题库列表数据
		pageBean = ps.getPaperList(pageBean, parameter, pageIndex);
		return "listPaper";
	}
	/**
	 * @return
	 * 随机组卷
	 */
	public String createByRandom(){
		System.out.println("1,查询所有类型的试题");
		//1,查询所有类型的试题
		listRE = qs.getQuestionsByType(course.getCsId(), "单选", "简单");
		listRN = qs.getQuestionsByType(course.getCsId(), "单选", "一般");
		listRD = qs.getQuestionsByType(course.getCsId(), "单选", "困难");
		listCN = qs.getQuestionsByType(course.getCsId(), "多选", "一般");
		listCE = qs.getQuestionsByType(course.getCsId(), "多选", "简单");
		listCD = qs.getQuestionsByType(course.getCsId(), "多选", "困难");
		//2,随机获取试题集合
		System.out.println("2,随机获取试题集合");
		Set<WrittenQuestion> lisQuestions = RandomQuestionsUtils.randomAllQuestions(
				listRE, listRN, listRD, listCE, listCN, listCD,
				radioEasy, radioNormal, radioDiff, cbEasy, cbNormal, cbDiff);
		System.out.println("试题数量："+lisQuestions.size());
		return "";
	}
	public PaperService getPs() {
		return ps;
	}
	public void setPs(PaperService ps) {
		this.ps = ps;
	}
	public List<Course> getListCourse() {
		return listCourse;
	}
	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}
	public List<Paper> getListPaper() {
		return listPaper;
	}
	public void setListPaper(List<Paper> listPaper) {
		this.listPaper = listPaper;
	}
	public PageBean<Paper> getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean<Paper> pageBean) {
		this.pageBean = pageBean;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
}
