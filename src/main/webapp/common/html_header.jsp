<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<c:set var="base" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<base href="${base}">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>

<meta name="viewport" content="width=device-width, initial-scale=1">

<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=9" />
  
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<%@include file="/common/include/jquery.jsp"%>
<%@include file="/common/include/bootstrap.jsp"%>
<%@include file="/common/include/bootstrap_datetimepicker.jsp"%>
<%@include file="/common/include/artDialog.jsp"%>
<%@include file="/common/include/ueditor.jsp"%>

<link href="common/css/reset.css" rel="stylesheet">
<link href="common/css/dashboard.css" rel="stylesheet">
<link href="common/css/main.css" rel="stylesheet">

</head>
<body>
	<%@include file="/common/plugins/toastMsg/msg.jsp"%>
<%@include file="/common/head.jsp"%>

<div class="container-fluid" style="margin-top: 60px;">
	<div class="row">
		<%@include file="/common/menu.jsp"%>
		<div class="col-sm-9 col-sm-offset-2 col-md-10 main">
		
		