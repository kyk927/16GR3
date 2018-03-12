/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.tkgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.kyk.exam.common.bean.PageBean;
import com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDao;
import com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDaoImpl;

/**
 * @author 库悦凯
 *TODO
 *2018年1月4日下午5:22:47
 */
public class QuestionServiceImpl implements QuestionService {
	private QuestionDao qtDao = new QuestionDaoImpl();

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService#getCourseInfo(java.util.Map)
	 */
	@Override
	public List<Course> getCourseInfo(Map parameter) {
		// TODO Auto-generated method stub
		return qtDao.getCourseInfo(parameter);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService#getQuestionsMax(int, java.lang.String, java.lang.String)
	 */
	@Override
	public int getQuestionsMax(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		return qtDao.getQuestionsMax(csId, qtype, degree);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService#getWrittenList(com.qhit.lh.gr3.kyk.exam.common.bean.PageBean, com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course, int)
	 */
	@Override
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean, Course course, int pageIndex) {
		// TODO Auto-generated method stub
		return qtDao.getWrittenList(pageBean, course, pageIndex);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService#addWrittenQuestion(com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public void addWrittenQuestion(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		qtDao.addWrittenQuestion(writtenQuestion);
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService#getWrittenQuestionById(com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public WrittenQuestion getWrittenQuestionById(
			WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		return qtDao.getWrittenQuestionById(writtenQuestion);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService#updateWrittenQuestion(com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		qtDao.updateWrittenQuestion(writtenQuestion);
		
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService#inportWrittenQuestions(java.util.List)
	 */
	@Override
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestion) {
		// TODO Auto-generated method stub
		qtDao.inportWrittenQuestions(listWQuestion);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.service.QuestionService#getQuestionsByType(int, java.lang.String, java.lang.String)
	 */
	@Override
	public List<WrittenQuestion> getQuestionsByType(int csId, String qtype,
			String degree) {
		// TODO Auto-generated method stub
		return null;
	}

}
