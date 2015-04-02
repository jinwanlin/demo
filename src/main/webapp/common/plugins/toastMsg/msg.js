$(function() {
	if (msg != "") {
		message(msg, msg_type);
	}
})

function message(msg, msg_type) {
	var d = dialog({
		content : msg,
		padding : 10
	});

	var ui_dialog_content = $(".ui-dialog-content").parent();
	ui_dialog_content.addClass("msg_"+msg_type);
	d.show();
	
	$("div[role='dialog']").append(getWhiteIfram());
	
	setTimeout(function() {
		d.close().remove();
	}, 2000);
}
