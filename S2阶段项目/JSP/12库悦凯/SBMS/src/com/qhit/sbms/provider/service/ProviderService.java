package com.qhit.sbms.provider.service;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.provider.bean.Provider;

public interface ProviderService {
	/**
	 * @param provider
	 * @return
	 * 分页的数据访问
	 */
	public PageBean getPageBeanS(PageBean pageBean);
	/**
	 * @param provider
	 * @return
	 * 添加供应商
	 */
	public int addProvider(Provider provider);
	/**
	 * @param providerId
	 * @return
	 * 删除
	 */
	public int deleteProviderById(int providerId);
}
