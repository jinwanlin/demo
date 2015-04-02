package com.demo.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.web.bind.ServletRequestUtils;

public class BaseController {

	public static final int DEFAULT_PAGE_SIZE = 20;

	private String sessionUser;

	protected void setSessionUser(String sessionUser) {
		this.sessionUser = sessionUser;
	}

	/**
	 * 获取page值（抽象出来的公共方法）
	 * 
	 * @param request
	 * @param pageName
	 * @return
	 */
	protected Integer getPageIndex(HttpServletRequest request, String pageName) {
		String pageIndexName = new ParamEncoder(pageName).encodeParameterName(TableTagParameters.PARAMETER_PAGE);
		Integer pageIndex = ServletRequestUtils.getIntParameter(request, pageIndexName, 1);
		return pageIndex;
	}

	/**
	 * 获取request请求所有参数
	 * @param request
	 * @return
	 */
	protected Map<String, String[]> getAllParams(HttpServletRequest request) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			map.put(paramName, paramValues);
		}
		return map;
	}
}
