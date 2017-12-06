package com.qhit.sbms.provider.service.impl;

import com.qhit.sbms.common.bean.PageBean;
import com.qhit.sbms.provider.bean.Provider;
import com.qhit.sbms.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	@Override
	public PageBean getPageBeanS(PageBean pageBean) {
		// TODO Auto-generated method stub
		return new ProviderServiceImpl().getPageBeanS(pageBean);
	}

	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderServiceImpl().addProvider(provider);
	}

	@Override
	public int deleteProviderById(int providerId) {
		// TODO Auto-generated method stub
		return new ProviderServiceImpl().deleteProviderById(providerId);
	}

}
