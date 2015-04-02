<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/include/taglib.jsp"%>




<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">${empty user.id ? '添加' : '编辑'}用户</h4>
			</div>
			<form class="form-horizontal" action="app/user/${empty user.id ? 'save' : 'update'}" method="post" data-remote="true">
				<div class="modal-body">
					<input type="hidden" name="id" value="${user.id}">

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-3">
							<input type="text" name="name" class="form-control" value="${user.name}" autocomplete="off">
						</div>
					</div>

					<div class="form-group ${!empty telephoneError ? 'has-error' : '' }">
						<label for="inputEmail3" class="col-sm-2 control-label">手机号</label>
						<div class="col-sm-5 form-inline">
							<input type="text" name="telephone" class="form-control" value="${user.telephone}" autocomplete="off">
							<span class="help-inline text-error">${telephoneError}</span>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="submit" class="btn btn-primary">确定</button>
				</div>
			</form>
		</div>
	</div>
</div>