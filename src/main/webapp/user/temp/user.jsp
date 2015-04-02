<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/include/taglib.jsp"%>

评论:
<% 
    request.setAttribute("l", "<");   
    request.setAttribute("l2", "&lt");
    
    request.setAttribute("g", ">");   
    request.setAttribute("g2", "&gt");
%>

<c:set var="content" value="${param.content}" /> 
<c:set var="content" value="${fn:replace(content,l,l2)}" /> 
<c:set var="content" value="${fn:replace(content,g,g2)}" /> 

<p>${content}</p>