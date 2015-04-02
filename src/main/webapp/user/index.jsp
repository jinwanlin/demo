<%@page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@include file="/common/include/taglib.jsp"%>
<%@include file="/common/html_header.jsp"%>

<div class="bs-example pull-right">
	<a class="btn btn-success" href="app/user/add" data-remote="true">添加</a>
</div>
<h2 class="sub-header">用户</h2>
	<div class="input-group">
		<form class="form-horizontal" action="app/user/list" data-remote="true">
			<input type="text" placeholder="姓名" class="form-control" name="name">
			<span class="input-group-btn">
				<button type="submit" class="btn btn-default">查询</button>
			</span>
		</form>
	</div>
	
<div class="table-responsive">
	<script type="text/javascript" src="app/user/list"></script>
</div>

<div id="target"></div>

<%@include file="/common/html_footer.jsp"%>

