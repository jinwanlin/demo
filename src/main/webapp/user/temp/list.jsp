<%@page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@include file="/common/include/taglib.jsp"%>

<table>
	<c:forEach items="${list}" var="user">
		<tr>
			<td><a href="admin/user/show/${user.id}">${user.name}</a></td>
			<td>${user.telephone}</td>
			<td>
				<div class="btn-group">
					<a class="btn btn-primary" href="user/edit?id=${user.id}" data-remote="true">编辑</a> <a class="btn btn-primary" href="user/delete/${user.id}" data-remote="true" data-confirm="are you sure?">删除</a>
				</div>
			</td>
		</tr>
	</c:forEach>
</table>

<pager:pager url="user2/list"></pager:pager>