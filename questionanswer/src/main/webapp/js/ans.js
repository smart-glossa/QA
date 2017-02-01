$(document).ready(function(){
	$(document).on('click','#here',function(){
		var qa = "";
		qa += "<center>"
		qa += "<table>";
		qa += "<tr><td>question:<\/td><td><textarea id=\"que\"><\/textarea><\/td><\/tr>";
		qa += "<tr><td>Answer:<\/td><td><textarea id=\"ans\"><\/textarea><\/td><\/tr>";
		qa += "<tr colspan=\"2\"><td><button id=\"send\">AddNow<\/button><\/td><\/tr>";
		qa += "<\/table>";
		qa += "<\/center>";
		
		$('#answer')[0].innerHTML = qa;
	});
});