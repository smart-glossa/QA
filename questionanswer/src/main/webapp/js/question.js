$(document).ready(function(){
	$(document).on("click","#submit",function(){
		var ques=$('#ques').val();
		var uname=$('#uname').val();
		var date=$('#date').val();
		if(ques==""){
        alert("please enter Question");
        return;
		}
		if(uname==""){
			alert("please enter your UserName");
			return;
		}
		
		if(date==""){
			alert("please enter your Date");
			return;
		}
		var url="/questionanswer/question?operation=add&ques="+ques+"&uName="+uname+"&date="+date;
		$('input[type=text]').val();
		$.ajax({
			url: url,
			type:'post'
		})
		.done(function(result){
				alert("Successfully Added");
			})
		.fail(function(result){
			alert("Error Occurs");
		});
	});
	

	$(document).on('keyup','#qusId',function(){
		var id=$('#qusId').val();
		if(id!=""){
		var url="http://localhost:8080/questionanswer/question?operation=getOne&qusId="+id;
		$.ajax({
			url:url,
			type:'post'
		})
		.done(function(result){
			result=JSON.parse(result);
			$("#ques").val(result.question);
			$("#uname").val(result.userName);
			$("#date").val(result.qdate);

		});
		}
	});
	$(document).on('click','#getall',function(){
		var url="/questionanswer/question?operation=getAll";
		$.ajax({
			url:url,
			type:'post'
		})
		.done(function(result){
			var array=JSON.parse(result);
			var table="<table border=2px>"
				table+="<tr><th>Question</th><th>UserName</th><th>QuestionDate</th></tr>";
			for(i=0;i<array.length;i++){
				table+="<tr>"
				table+="<td>"+array[i].question+"</td>";
				table+="<td>"+array[i].userName+"</td>";
				table+="<td>"+array[i].qdate+"</td>";
				table+="</tr>";
			} 
			table+="</table>";
			$(".qus")[0].innerHTML=table;
		});
	});
	
	
	
	$(document).on("click","#sub",function(){
		var answer=$('#ans').val();
		var uname=$('#uname').val();
		var date=$('#adate').val();
		if(answer==""){
        alert("please enter your Answer");
        return;
		}
		if(uname==""){
			alert("please enter your UserName");
			return;
		}
		
		if(date==""){
			alert("please enter your Date");
			return;
		}
		var url="/questionanswer/question?operation=addAns&ans="+answer+"&uname="+uname+"&adate="+date;
		$('input[type=text]').val();
		$.ajax({
			url: url,
			type:'post'
		})
		.done(function(result){
				alert("Successfully Added");
			})
		.fail(function(result){
			alert("Error Occurs");
		});
	});
	

	$(document).on('keyup','#id',function(){
		var id=$('#id').val();
		if(id!=""){
		var url="http://localhost:8080/questionanswer/question?operation=getOne&id="+id;
		$.ajax({
			url:url,
			type:'post'
		})
		.done(function(result){
			result=JSON.parse(result);
			$("#ans").val(result.answer);
			$("#uname").val(result.userName);
			$("#adate").val(result.adate);

		});
		}
	});
	$(document).on('click','#getallans',function(){
		var url="/questionanswer/question?operation=getAll";
		$.ajax({
			url:url,
			type:'post'
		})
		.done(function(result){
			var array=JSON.parse(result);
			var table="<table border=2px>"
				table+="<tr><th>Answer</th><th>UserName</th><th>AnswerDate</th></tr>";
			for(i=0;i<array.length;i++){
				table+="<tr>"
				table+="<td>"+array[i].Answer+"</td>";
				table+="<td>"+array[i].userName+"</td>";
				table+="<td>"+array[i].adate+"</td>";
				table+="</tr>";
			}
			table+="</table>";
			$(".anss")[0].innerHTML=table;
		});
	});
	$(document).on("click","#sub",function(){
		var questionId=$('#qId').val();
		var answerId=$('#aId').val();
		if(questionId==""){
        alert("please enter your QuestionId");
        return;
		}
		if(answerId==""){
			alert("please enter your AnswerId");
			return;
		}
		
		var url="/questionanswer/question?operation=addQA&qId="+questionId+"&aId="+answerId;
		$('input[type=text]').val();
		$.ajax({
			url: url,
			type:'post'
		})
		.done(function(result){
				alert("Successfully Added");
			})
		.fail(function(result){
			alert("Error Occurs");
		});
	});
	

	$(document).on('keyup','#qId',function(){
		var id=$('#qId').val();
		if(id!=""){
		var url="http://localhost:8080/questionanswer/question?operation=getOneAns&qId="+id;
		$.ajax({
			url:url,
			type:'post'
		})
		.done(function(result){
			result=JSON.parse(result);
			$("#qId").val(result.questionId);
			$("#aId").val(result.answerId);
		});
		}
	});

	$(document).on('keyup','#aId',function(){
		var ansid=$('#aId').val();
		if(ansid!=""){
		var url="http://localhost:8080/questionanswer/question?operation=getOneques&aId="+ansid;
		$.ajax({
			url:url,
			type:'post'
		})
		.done(function(result){
			result=JSON.parse(result);
			$("#aid").val(result.answerId);
			$("#answ").val(result.answer);
		});
		}
	});
	
	
	 $(document).on('click','#login',function(){
	       $('#log').show();
	    });
	    $(document).on('click','.close',function(){
	    	$('#log').hide();
	    });
	    
	    $(document).on('click','#here')
	
});

