function getAll(){
	 var url = "http://localhost:8080/questionanswer/Question?operation=queansAll";
	 $.ajax({
		 url:url,
		 type:'POST'
	 })
	 .done(function(result){
		 var res = JSON.parse(result);
		 var table = "<table style='border: 1px solid black'>"
			 table +="<tr><th> NO.</th><th>QUESTION</th><th>ANSWER</th></tr>";
				 for(var i=0;i<res.length;i++){
					 table +="<tr>";
					 table += "<td>"+res[i].id+"</td>";
					 table +="<td>"+ res[i].question +"</td>";
					 table +="<td>" + res[i].answer +"</td>";
					 table +="</tr>";
				 }
		 table +="</table>";
		 $("#getAll")[0].innerHTML = table;
	 })
}
