$(document).ready(function(){
	$(document).on('click','#here',function(){
		var qa = "";
		qa += "<h6>question:<\/h6>";
		qa += "<textarea id=\"que\"><\/textararea>";
		qa += "<textarea id=\"ans\"><\/textarea>";
		qa += "<button id=\"send\"><\/button>";
	});
});