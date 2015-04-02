<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/include/taglib.jsp"%>

<link href="common/plugins/toastMsg/msg.css" rel="stylesheet">
<script type="text/javascript">
	var msg =  '${empty msg ? param.msg : msg }';
	var msg_type = '${empty msg_type ? param.msg_type : msg_type }';
</script>

<script type="text/javascript" src="common/plugins/toastMsg/msg.js"></script>