var target;
function backupTarget() {
	target = $("#sone\\:target").val();	
}

function restoreTarget() {
	updateWatermark();
	$("#sone\\:target").val(target);	
}

function oncomplete() {
	console.log('complete');
}