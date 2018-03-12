/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.tkgl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.POIReadOnlyDocument;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.kyk.exam.common.bean.PageBean;
import com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService;
import com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.gr3.kyk.exam.tkgl.utils.PoiReaderExcel;

/**
 * @author 库悦凯
 *TODO
 *2018年1月4日下午5:37:45
 */
public class QuestionAction extends ActionSupport {
	private QuestionService qs = new QuestionServiceImpl();
	private Course course;//课程
	private String major;//专业方向
	private String stage;//阶段
	private WrittenQuestion writtenQuestion;//笔试题对象
	private List<Course> listCourse = new ArrayList<>();
	//试题列表分页数据
	private PageBean<WrittenQuestion> pageBean = new PageBean<>();
	private int pageIndex = 1;//指定页，初始化为1
	//导入试题集合
	private List<WrittenQuestion> listWQuestions = new ArrayList<>();
	//导入文件对象
	private File questionfile;
	private int radioEasyMax,radioNormalMax,radioDiffMax,cbEasyMax,cbNormalMax,cbDiffMax;
	/**
	 * @return
	 * 题库列表
	 */
	public String getCourseInfo(){
		//设置参数
		Map<String, String> parameter = new HashMap<>();
		if(major != null && !"".equals(major)){
			parameter.put("major", major);
		}
		if(stage != null && !"".equals(stage)){
			parameter.put("stage", stage);
		}
		//查询题库列表数据
		listCourse = qs.getCourseInfo(parameter);
		return "listCourse";
	}
	
	public String getQuestionMax(){
		radioEasyMax = qs.getQuestionsMax(writtenQuestion.getCsId(), "单选", "简单");
		radioNormalMax = qs.getQuestionsMax(writtenQuestion.getCsId(), "单选", "一般");
		radioDiffMax = qs.getQuestionsMax(writtenQuestion.getCsId(), "单选", "困难");
		cbEasyMax = qs.getQuestionsMax(writtenQuestion.getCsId(), "多选", "简单");
		cbNormalMax = qs.getQuestionsMax(writtenQuestion.getCsId(), "多选", "一般");
		cbDiffMax = qs.getQuestionsMax(writtenQuestion.getCsId(), "多选", "困难");
		
		return "getQuestionMax";
	}
	
	/**
	 * @return
	 * 获取试题列表
	 */
	public String getWrittenList(){
		pageBean = qs.getWrittenList(pageBean, course, pageIndex);
		return "listWritten";
	}
	
	/**
	 * @return
	 * 添加笔试题
	 */
	public String addWrittenQuestion(){
		//设置课程试题的关联
		writtenQuestion.setCourse(course);
		qs.addWrittenQuestion(writtenQuestion);
		return "addWrittenQuestion";
	}
	
	/**
	 * @return
	 * 根据试题编号查询试题对象
	 */
	public String getWrittenQuestionById(){
		writtenQuestion = qs.getWrittenQuestionById(writtenQuestion);
		return "getWrittenQuestionById";
	}
	
	/**
	 * @return
	 * 更新
	 */
	public String updateWrittenQuestion(){
		//设置关联
		writtenQuestion.setCourse(course);
		qs.updateWrittenQuestion(writtenQuestion);
		return "updateWrittenQuestion";
	}
	
	public String inportWrittenQuestions() throws FileNotFoundException{
		if(questionfile != null){
			//上传到服务器
			FileInputStream fis = new FileInputStream(questionfile);
			//读取excel文件中的数据，获取试题对象集合
			listWQuestions = PoiReaderExcel.readerExcel(fis, course);
			//批量添加到数据库
			qs.inportWrittenQuestions(listWQuestions);
		}else{
			
		}
		return "inportWrittenQuestions";
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public List<Course> getListCourse() {
		return listCourse;
	}
	public void setListCourse(List<Course> listCourse) {
		this.listCourse = listCourse;
	}

	public QuestionService getQs() {
		return qs;
	}

	public void setQs(QuestionService qs) {
		this.qs = qs;
	}

	public WrittenQuestion getWrittenQuestion() {
		return writtenQuestion;
	}

	public void setWrittenQuestion(WrittenQuestion writtenQuestion) {
		this.writtenQuestion = writtenQuestion;
	}

	public PageBean<WrittenQuestion> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<WrittenQuestion> pageBean) {
		this.pageBean = pageBean;
	}

	public int getRadioEasyMax() {
		return radioEasyMax;
	}

	public void setRadioEasyMax(int radioEasyMax) {
		this.radioEasyMax = radioEasyMax;
	}

	public int getRadioNormalMax() {
		return radioNormalMax;
	}

	public void setRadioNormalMax(int radioNormalMax) {
		this.radioNormalMax = radioNormalMax;
	}

	public int getRadioDiffMax() {
		return radioDiffMax;
	}

	public void setRadioDiffMax(int radioDiffMax) {
		this.radioDiffMax = radioDiffMax;
	}

	public int getCbEasyMax() {
		return cbEasyMax;
	}

	public void setCbEasyMax(int cbEasyMax) {
		this.cbEasyMax = cbEasyMax;
	}

	public int getCbNormalMax() {
		return cbNormalMax;
	}

	public void setCbNormalMax(int cbNormalMax) {
		this.cbNormalMax = cbNormalMax;
	}

	public int getCbDiffMax() {
		return cbDiffMax;
	}

	public void setCbDiffMax(int cbDiffMax) {
		this.cbDiffMax = cbDiffMax;
	}

}
