$(document).ready(function(){
	 getAll();
	$(document).on('click','#send',function(){
		var qus = $("#que").val();
		var ans = $("#ans").val();
		if(qus == "")
			{
			alert("please enter the  question");
			$("#que").focus().css("outline-color","#e53935");
			return;
			}
		if(ans == "")
		{
		alert("please enter the answer");
		$("#ans").focus().css("outline-color","#e53935");
		return;
		}
		var url = "http://localhost:8080/questionanswer/question?operation=queansAdd&question="+qus+"&answer="+ans;
		$.ajax({
			url: url,
			type: 'POST'
		})
		.done(function(result){
			alert("successfully added");
		})
		.fail(function(result){
			alert("Error occurs");
		});
	});
});
