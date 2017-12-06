package com.qhit.sbms.account.service.impl;

import java.util.List;

import com.qhit.sbms.account.dao.impl.AccountDaoImpl;
import com.qhit.sbms.account.service.AccountService;
import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.goods.bean.Goods;

public class AccountServiceImpl implements AccountService {

	@Override
	public PageBean getPageBean(PageBean pageBean) {

		return new AccountDaoImpl().getPageBean(pageBean);
	}

	@Override
	public int addAccount(Goods goods, int businessNum, int providerId,
			int isPayed) {

		return new AccountDaoImpl().addAccount(goods, businessNum, providerId, isPayed);
	}

	@Override
	public PageBean getPageBeanByParam(List<String> wheres, List<String> values) {

		return new AccountDaoImpl().getPageBeanByParam(wheres, values);
	}

	@Override
	public int deleteAccountById(int accountId) {

		return new AccountDaoImpl().deleteAccountById(accountId);
	}

	@Override
	public int upDateAccountById(int accountId, int providerId, int isPayed) {

		return new AccountServiceImpl().upDateAccountById(accountId, providerId, isPayed);
	}

}
