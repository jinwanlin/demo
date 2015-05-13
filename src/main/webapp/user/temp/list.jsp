<%@page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@include file="/common/include/taglib.jsp"%>

	<display:table name="list" id="user" class="table table-striped" pagesize="20" sort="external"  partialList="true" keepStatus="true" size="${total}" requestURI="user/list">
		<display:column title="姓名" class="${user.id}"><a href="admin/user/show/${user.id}">${user.name}</a></display:column>
		<display:column title="手机号">${user.telephone}</display:column>
		<display:column title="">
			<div class="btn-group">
		      <a class="btn btn-primary" href="user/edit?id=${user.id}" data-remote="true" >编辑</a>
		      <a class="btn btn-primary"  href="user/delete/${user.id}" data-remote="true" data-confirm="are you sure?">删除</a>
		    </div>
		</display:column>
	</display:table>
	
