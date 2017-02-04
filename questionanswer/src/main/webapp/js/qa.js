$(document).ready(function() {
   
    $(document).on('click', '#send', function() {
        var qus = $("#que").val();
        var ans = $("#ans").val();
        if (qus == "") {
            alert("please enter the  question");
            $("#que").focus().css("outline-color", "#e53935");
            return;
        }
        if(ans == "")
        	{
        alert("please enter the  answer");
        $("#ans").focus().css("outline-color", "#e53935");
        	}
        return;
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
                table += "<b id='question'>" + parseInt(i)+"."+ res[i].question + "</b>";
                table += "<p id='answer'>" +res[i].answer+ "</p>";
                table += "<div class='textarea'>";
                table += "<textarea id='ans' placeholder='enter the answer here'></textarea>";
                table += "<div class='post'>";
                table += "<button id='update'>POST</button>";
                table += "</div>";
                table += "</div>";
                table += "</div>";
                
            }
            table += "</div>"
            	
            $("#getAll")[0].innerHTML = table;
        });
});
   
	 
});
