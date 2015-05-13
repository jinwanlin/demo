<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/include/taglib.jsp"%>
<c:set var="url" value="${pageContext.request.requestURL}" />
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="<c:if test='${fn:contains(url, "/user/")}'>active</c:if>"><a href="admin/user/list">用户</a></li>
		<li class="<c:if test='${fn:contains(url, "/order/")}'>active</c:if>"><a href="admin/order/list">订单</a></li>
		<li class="<c:if test='${fn:contains(url, "/bill/")}'>active</c:if>"><a href="admin/bill/list">账单</a></li>
	</ul>
	
	<ul class="nav nav-sidebar">
		<li class="<c:if test='${fn:contains(url, "/subject/")}'>active</c:if>"><a href="admin/subject/list">学科</a></li>
		<li class="<c:if test='${fn:contains(url, "/price/")}'>active</c:if>"><a href="admin/price/list">价格</a></li>
		<li class="<c:if test='${fn:contains(url, "/tag/")}'>active</c:if>"><a href="admin/tag/list">TAG</a></li>
	</ul>
	
	<ul class="nav nav-sidebar">
		<li class="<c:if test='${fn:contains(url, "/article/list/msgTemp")}'>active</c:if>"><a href="admin/article/list/msgTemp">系统消息模板</a></li>
		<li class="<c:if test='${fn:contains(url, "/article/list/pact")}'>active</c:if>"><a href="admin/article/list/pact">协议</a></li>
		<li class="<c:if test='${fn:contains(url, "/article/list/aboutUs")}'>active</c:if>"><a href="admin/article/list/aboutUs">公司信息</a></li>
	</ul>
	
	<ul class="nav nav-sidebar">
		<li class="<c:if test='${fn:contains(url, "/help/")}'>active</c:if>"><a href="admin/help/list">帮助</a></li>
		<li class="<c:if test='${fn:contains(url, "/news/listByType/news")}'>active</c:if>"><a href="admin/news/listByType/news">新闻</a></li>
		<li class="<c:if test='${fn:contains(url, "/news/listByType/mediaReport")}'>active</c:if>"><a href="admin/news/listByType/mediaReport">媒体报道</a></li>
	</ul>
</div>
