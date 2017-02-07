$(document).ready(function() {
   
    $(document).on('click', '#send', function() {
        var qus = $("#que").val();
   
        if (qus == "") {
            alert("please enter the  question");
            $("#que").focus().css("outline-color", "#e53935");
            return;
        }
       
        var url = "/questionanswer/qa?operation=add&question=" + qus ;
        $("input[type=text],textarea").val("");
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
       qa += "<div class=\'textarea\' >";
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
            var table = "<div class='all'>";
                for (var i = 0; i < res.length; i++) {
                	var a = i+1;
                table += "<div class='qa'>";
                table += "<b id='question'>" + a +"."+ res[i].question + "</b>";
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
           $(document).on('click', '#update', function() {
                        var id= $(this).parent().parent().children().text();
                       
        if(ans == "")
     	{
     alert("please enter the  answer");
     $("#ans").focus().css("outline-color", "#e53935");
     return;
     	}
     
     var url = "/questionanswer/qa?operation=update&answer=" + ans + " where id=" + id;
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
	 $(document).on('click','.home',function(){
		 $('#qaAddForm').hide();
			 });
	    $(document).on('click','.home',function(){
    	$('#getAll').show();
    }); 
    $(document).on('click','#here', function(){
      $('#qaAddForm').show();	
    });
    $(document).on('click','#here',function(){
    	$('#getAll').hide();
    });
});
