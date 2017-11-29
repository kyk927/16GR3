package com.jay.to1.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("我开始拦截。。。");
		String result = arg0.invoke();
		System.out.println("返回代码:"+result);
		return result;
	}

}
