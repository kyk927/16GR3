package com.qhit.sbms.account.dao;

import java.util.List;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.goods.bean.Goods;

public interface AccountDao {
	/**
	 * @param pageBean
	 * @return
	 * 分页的数据访问
	 */
	public PageBean getPageBean(PageBean pageBean);
	/**
	 * @param goods
	 * @param businessNum
	 * @param providerId
	 * @param isPayed
	 * @return
	 * 添加账单
	 */
	public int addAccount(Goods goods,int businessNum,int providerId,int isPayed);
	/**
	 * @param wheres
	 * @param values
	 * @return
	 * 根据参数查询
	 */
	public PageBean getPageBeanByParam(List<String> wheres,List<String> values);
	/**
	 * @param accountId
	 * @return
	 * 删除
	 */
	public int deleteAccountById(int accountId);
	/**
	 * @param accountId
	 * @param providerId
	 * @param isPayed
	 * 更新
	 * @return
	 */
	public int upDateAccountById(int accountId,int providerId,int isPayed);
}
