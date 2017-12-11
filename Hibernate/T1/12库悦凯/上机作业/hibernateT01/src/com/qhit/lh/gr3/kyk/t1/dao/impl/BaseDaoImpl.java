/**
 * 
 */
package com.qhit.lh.gr3.kyk.t1.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.kyk.t1.dao.BaseDao;
import com.qhit.lh.gr3.kyk.t1.utils.HibernateSessionFactory;

/**
 * @author 库悦凯
 * TODO 
 * 2017年12月11日上午9:55:06
 */
public class BaseDaoImpl implements BaseDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.t1.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object obj) {
		// 获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 开启事务
		Transaction ta = session.beginTransaction();
		// 插入数据
		session.save(obj);
		// 提交事务
		ta.commit();
		// 释放资源
		HibernateSessionFactory.closeSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.t1.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object obj) {
		// 获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 开启事务
		Transaction ta = session.beginTransaction();
		// 插入数据
		session.delete(obj);
		// 提交事务
		ta.commit();
		// 释放资源
		HibernateSessionFactory.closeSession();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.t1.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object obj) {
		// 获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 开启事务
		Transaction ta = session.beginTransaction();
		// 插入数据
		session.update(obj);
		// 提交事务
		ta.commit();
		// 释放资源
		HibernateSessionFactory.closeSession();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.t1.dao.BaseDao#getAll(java.lang.String)
	 */
	@Override
	public List<Object> getAll(String fromObject) {
		// 获取session对象
		Session session = HibernateSessionFactory.getSession();
		// 开启事务
		Transaction ta = session.beginTransaction();
		// 获取查询器对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		// 提交事务
		ta.commit();
		// 释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}

}
