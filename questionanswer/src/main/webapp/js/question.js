$(document).on("click","#submit",function(){
	var ques = $("#ques").val();
	var ans = $("#ans").val();
	var url = "http://localhost:8080/questionanswer/question?operation=add&ques="+ ques +"&ans="+ ans;
	$.ajax({
		url:url,
		type:'POST'
	}).done(function(result){
		alert(result);
	});
	fail(function(){
		alert(result);
	})
});