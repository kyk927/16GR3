/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.lh.gr3.kyk.exam.common.bean.PageBean;
import com.qhit.lh.gr3.kyk.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion;

/**
 * @author 库悦凯 TODO 2018年1月4日下午5:22:13
 */
public class QuestionDaoImpl extends BaseDao implements QuestionDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDao#getCourseInfo(java.util
	 * .Map)
	 */
	@Override
	public List<Course> getCourseInfo(Map parameter) {
		StringBuffer hql = new StringBuffer();
		hql.append("select course from Course course where 1 = 1");
		// 拼接HQL
		if (parameter.get("major") != null
				&& !"".equals(parameter.get("major"))) {
			hql.append(" and course.major = :major");
		}
		if (parameter.get("stage") != null
				&& !"".equals(parameter.get("stage"))) {
			hql.append(" and course.stage = :stage");
		}
		// 获取查询器
		Query query = getSession().createQuery(hql.toString());
		// 设置参数
		if (parameter.get("major") != null
				&& !"".equals(parameter.get("major"))) {
			query.setString("major", (String) parameter.get("major"));
		}
		if (parameter.get("stage") != null
				&& !"".equals(parameter.get("stage"))) {
			query.setString("stage", (String) parameter.get("stage"));
		}
		// 执行查询
		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDao#getQuestionsMax(int,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public int getQuestionsMax(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(WrittenQuestion.class)
				.add(Restrictions.eq("csId", csId))
				.add(Restrictions.eq("qtype", qtype))
				.add(Restrictions.eq("degree", degree));

		ProjectionList projectionList = Projections.projectionList().add(
				Projections.count("qid"));
		criteria.setProjection(projectionList);
		long num = (long) criteria.list().get(0);
		return (int) num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDao#getWrittenList(com.qhit
	 * .lh.gr3.kyk.exam.common.bean.PageBean,
	 * com.qhit.lh.gr3.kyk.exam.kmgl.bean.Course, int)
	 */
	@Override
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean, Course course, int pageIndex) {
		// TODO Auto-generated method stub
		//HQL语句
		StringBuffer hql = new StringBuffer();
		hql.append("select w from WrittenQuestion w where w.csId = :csId");
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置分页查询参数
		query.setInteger("csId", course.getCsId());
		//总记录数
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//当前页数据
		List<WrittenQuestion> items = query
				.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//设置pagebean的数据集合
		pageBean.setItems(items);
		return pageBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDao#addWrittenQuestion(com.
	 * qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public void addWrittenQuestion(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		//开启事务
		Transaction ts = getSession().beginTransaction();
		//执行添加，返回新纪录的主键
		long id = (Long) getSession().save(writtenQuestion);
		//提交事务
		ts.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDao#getWrittenQuestionById(
	 * com.qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public WrittenQuestion getWrittenQuestionById(
			WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		return (WrittenQuestion) getSession().get(WrittenQuestion.class, writtenQuestion.getQid());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDao#updateWrittenQuestion(com
	 * .qhit.lh.gr3.kyk.exam.tkgl.bean.WrittenQuestion)
	 */
	@Override
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion) {
		//清除session中缓存对象
		getSession().clear();
		//开启事务
		Transaction ts = getSession().beginTransaction();
		getSession().update(writtenQuestion);
		//提交事务
		ts.commit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qhit.lh.gr3.kyk.exam.tkgl.dao.QuestionDao#inportWrittenQuestions(
	 * java.util.List)
	 */
	@Override
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestion) {
		//开启事务
		Transaction ts = getSession().beginTransaction();
		for (WrittenQuestion writtenQuestion : listWQuestion) {
			//执行添加，返回新纪录的主键
			getSession().save(writtenQuestion);
		}
		//提交事务
		ts.commit();
	}

}
