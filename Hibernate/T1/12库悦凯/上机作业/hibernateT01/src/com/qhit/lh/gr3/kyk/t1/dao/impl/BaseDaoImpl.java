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
 * @author ���ÿ�
 * TODO 
 * 2017��12��11������9:55:06
 */
public class BaseDaoImpl implements BaseDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.t1.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object obj) {
		// ��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		// ��������
		Transaction ta = session.beginTransaction();
		// ��������
		session.save(obj);
		// �ύ����
		ta.commit();
		// �ͷ���Դ
		HibernateSessionFactory.closeSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.t1.dao.BaseDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object obj) {
		// ��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		// ��������
		Transaction ta = session.beginTransaction();
		// ��������
		session.delete(obj);
		// �ύ����
		ta.commit();
		// �ͷ���Դ
		HibernateSessionFactory.closeSession();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.t1.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object obj) {
		// ��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		// ��������
		Transaction ta = session.beginTransaction();
		// ��������
		session.update(obj);
		// �ύ����
		ta.commit();
		// �ͷ���Դ
		HibernateSessionFactory.closeSession();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qhit.lh.gr3.kyk.t1.dao.BaseDao#getAll(java.lang.String)
	 */
	@Override
	public List<Object> getAll(String fromObject) {
		// ��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		// ��������
		Transaction ta = session.beginTransaction();
		// ��ȡ��ѯ������
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		// �ύ����
		ta.commit();
		// �ͷ���Դ
		HibernateSessionFactory.closeSession();
		return list;
	}

}
