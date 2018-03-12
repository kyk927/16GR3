/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.kyk.exam.common.bean.PageBean;
import com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion;

/**
 * @author 库悦凯
 *TODO
 *2018年1月4日下午5:21:53
 */
public interface QuestionDao {
	/**
	 * @param mjId
	 * @param stage
	 * @return
	 * 题库列表
	 */
	public List<Course> getCourseInfo(Map parameter);
	/**
	 * @param csId
	 * @param qtype
	 * @param degree
	 * @return
	 * 获取题目数
	 */
	public int getQuestionsMax(int csId,String qtype,String degree);
	/**
	 * @param pageBean
	 * @param course
	 * @param pageIndex
	 * @return
	 * 笔试题列表分页数据
	 */
	public PageBean<WrittenQuestion> getWrittenList(PageBean<WrittenQuestion> pageBean,Course course,int pageIndex);
	/**
	 * @param writtenQuestion
	 * 添加笔试题
	 */
	public void addWrittenQuestion(WrittenQuestion writtenQuestion);
	/**
	 * @param writtenQuestion
	 * @return
	 * 根据id查询试题
	 */
	public WrittenQuestion getWrittenQuestionById(WrittenQuestion writtenQuestion);
	/**
	 * @param writtenQuestion
	 * 更新数据
	 */
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion);
	/**
	 * @param listWQuestion
	 * 批量导入笔试题
	 */
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestion);
}
