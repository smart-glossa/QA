$(document).ready(function() {
   
    $(document).on('click', '#send', function() {
        var qus = $("#que").val();
        var ans = $("#ans").val();
        if (qus == "") {
            alert("please enter the  question");
            $("#que").focus().css("outline-color", "#e53935");
            return;
        }
        var url = "/questionanswer/qa?operation=add&question=" + qus + "&answer=" + ans;
        $.ajax({
                url: url,
                type: 'POST'
            })
            .done(function(result) {
                alert("successfully added");
            })
            .fail(function(result) {
                alert("Error occurs");
            });
    });
		$(document).on('click', '#here', function() {
        var qa = "";
        qa += "<center>"
       qa += "<div>";
        qa += "<textarea id=\'que\' placeholder=\'enter the question here\'></textarea>";
        qa += "<div class=\'post\'>";
        qa += "<button id=\'send\'>POST<\/button>";
        qa += "<\/div>";
        qa += "<\/div>";
 
        
        $('#qaAddForm')[0].innerHTML = qa;  
        
    });
		$(document).on('click','.aans',function(){
			var qa = "";
			qa += "<div class=\'textarea\'>";
	        qa += "<textarea id=\'ans\' placeholder=\'enter the answer here\'><\/textarea>";
	        qa += "<div class=\'post\'>";
	        qa += "<button id=\'update\'>POST<\/button>";
	        qa += "<\/div>";
	        qa += "<\/div>";
	        qa += "<\/center>";
	     
	        $('#typeans')[0].innerHTML=qa;
		});

 $(document).on('click','.home',function(){
    var url = "/questionanswer/qa?operation=getAll";
    $.ajax({
            url: url,
            type: 'POST'
        })
        .done(function(result) {
            var res = JSON.parse(result);
            var table = "<div>";
                for (var i = 0; i < res.length; i++) {
                table += "<div class='qa'>";
                table += "<span>" + res[i].id + "<span>";
                table += "<b id='question'>" + res[i].question + "</b>";
                table += "<p>" +res[i].answer+ "</p>";
                table += "<div class=\'textarea\'>";
    	        table += "<textarea id=\'ans\' placeholder=\'enter the answer here\'><\/textarea>";
    	        table += "<div class=\'post\'>";
    	        table += "<button id=\'update\'>POST<\/button>";
    	        table += "<\/div>";
    	        table += "<\/div>";
    	        table += "</div>";
                
            }
            table += "</div>"
            	
            $("#getAll")[0].innerHTML = table;
        });
});
   
	    $(document).on('click', '#update', function() {
		   var answer=$(this).parent().parent().children().text();
		   
		   
		   
		    		if (ans == "") {
	            alert("please enter the  answer");
	            $("#que").focus().css("outline-color", "#e53935");
	            return;
	        }
	        var url = "/questionanswer/qa?operation=update&&answer=" + answer;
	        $.ajax({
	                url: url,
	                type: 'POST'
	            })
	            .done(function(result) {
	                alert("successfully updated");
	            })
	            .fail(function(result) {
	                alert("Error occurs");
	            });
	    });
});
