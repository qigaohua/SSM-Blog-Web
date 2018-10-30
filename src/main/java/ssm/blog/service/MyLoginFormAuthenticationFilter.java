package ssm.blog.service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;


public class MyLoginFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		WebUtils.issueRedirect(request, response,getSuccessUrl(), null, true); 
	}
	
/*	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("------------------------------");
		WebUtils.issueRedirect(request, response, getSuccessUrl());
		return false;
	}*/
}
