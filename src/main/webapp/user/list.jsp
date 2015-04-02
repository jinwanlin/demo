<%@ page language="java" contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/include/taglib.jsp"%>

$(".table-responsive").html('<xjgz:js><jsp:include page="/user/temp/list.jsp" /></xjgz:js>');

$('#myModal').modal('hide');