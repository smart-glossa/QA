$(document).ready(function(){
	getAll();
	$(document).on("click","#submit",function(){
		var ques = $("#qus").val();
		var ans = $("#an").val();
		var url = "http://localhost:8080/questionanswer/question?operation=add&ques="+ ques +"&ans="+ ans;
		$.ajax({
			url:url,
			type:'POST'
		}).done(function(result){
			
			getAll();
		})
		.fail(function(){
			alert(result);
		})
	});
	$(document).on('click','.delete',function(){
		var tr = $(this).parent().parent();
		var qid = tr.children(".qid")[0].innerHTML;
		var url = "http://localhost:8080/questionanswer/question?operation=delete&qid="+ qid;
		$.ajax({
			url:url,
			type:'POST'
		})
		.done(function(result){
		   getAll();
		   
		})
	});
	$(document).on('keyup','#qid',function(){
		var qid = $("#qid").val();
		var url = "http://localhost:8080/questionanswer/question?operation=getOne&qid="+ qid;
		$.ajax({
			url:url,
			type:'POST'
		})
		.done(function(result){
			result = JSON.parse(result);
			$("qus").val(result.question);
			$("an").val(result.answer);
		})
	})
	
});
