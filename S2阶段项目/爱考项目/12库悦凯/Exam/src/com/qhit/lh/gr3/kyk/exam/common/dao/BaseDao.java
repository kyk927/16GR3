/**
 * 
 */
package com.qhit.lh.gr3.kyk.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.gr3.kyk.exam.common.utils.HibernateSessionFactory;

/**
 * @author 库悦凯
 *TODO
 *2018年1月3日上午11:35:17
 */
public class BaseDao {
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
