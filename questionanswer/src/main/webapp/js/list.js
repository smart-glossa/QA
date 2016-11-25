function getAll(){
	 var url = "http://localhost:8080/questionanswer/question?operation=getAll";
	 $.ajax({
		 url:url,
		 type:'POST'
	 })
	 .done(function(result){
		 var res = JSON.parse(result);
		 var table = "<table style='border: 1px solid black'>"
			 table +="<tr><th>SERIAL NO.</th><th>QUESTION</th><th>ANSWER</th><th>DELETE</th></tr>"
				 for(var i=0;i<res.length;i++){
					 table +="<tr class='qarow'><td class='qid'>"+ res[i].id +"</td>"
					 table +="<td>"+ res[i].question +"</td>"
					 table +="<td>"+ res[i].answer +"</td>"
					 table +="<td><img src='images/delete.jpg' class='delete' width='35px' height='35px'></td></tr>";
				 }
		 table +="</table>";
		 $(".getAll")[0].innerHTML = table;
	 })
}
