$(document).ready(function() {
    listAllQuestionAnswers();
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
function listAllQuestionAnswers() {
    var url = "/questionanswer/qa?operation=getAll";
    $.ajax({
            url: url,
            type: 'POST'
        })
        .done(function(result) {
            var res = JSON.parse(result);
            var table = "<table style='border: 1px solid black'>"
            table += "<tr><th> NO.</th><th>QUESTION</th><th>ANSWER</th></tr>";
            for (var i = 0; i < res.length; i++) {
                table += "<tr>";
                table += "<td>" + res[i].id + "</td>";
                table += "<td>" + res[i].question + "</td>";
                table += "<td>" + res[i].answer + "</td>";
                table += "</tr>";
            }
            table += "</table>";
            $("#getAll")[0].innerHTML = table;
        })
}
