$(document).ready(function() {
   
    $(document).on('click', '#send', function() {
        var qus = $("#que").val();
        var ans = $("#ans").val();
        if (qus == "") {
            alert("please enter the  question");
            $("#que").focus().css("outline-color", "#e53935");
            return;
        }
        if (ans == "") {
            alert("please enter the answer");
            $("#ans").focus().css("outline-color", "#e53935");
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
        qa += "<table>";
        qa += "<tr><td>question:<\/td><td><textarea id=\"que\"><\/textarea><\/td><\/tr>";
        qa += "<tr><td>Answer:<\/td><td><textarea id=\"ans\"><\/textarea><\/td><\/tr>";
        qa += "<tr colspan=\"2\"><td><button id=\"send\">AddNow<\/button><\/td><\/tr>";
        qa += "<\/table>";
        qa += "<\/center>";
        $('#qaAddForm')[0].innerHTML = qa;
    });
});
 $(document).on('click','.home',function(){
    var url = "/questionanswer/qa?operation=getAll";
    $.ajax({
            url: url,
            type: 'POST'
        })
        .done(function(result) {
            var res = JSON.parse(result);
            var table = "<div>"
                for (var i = 0; i < res.length; i++) {
                table += "<div class='qa'>";
                table += "<span>" + res[i].id + "<span>";
                table += "<b id='question'>" + res[i].question + "</b>";
                table += "<p id='answer'>" + res[i].answer + "<p>";
                table += "</div>";
                
            }
            table += "</div>";
            $("#getAll")[0].innerHTML = table;
        });
});
