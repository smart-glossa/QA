
function qa(){
	var ques="";
	ques += "<table>";
	ques += "<tr><td>QuestionId*:<\/td><td><input type=\"text\"id=\"qusId\"placeholder=\"QuestionId!..\"><\/td><\/tr>";
	ques += "<tr><td>Question*:<\/td><td><textarea type=\"text\"id=\"ques\"placeholder=\"Question!..\"><\/textarea><\/td><\/tr>";
	ques += "<tr><td>UserName*:<\/td><td><input type=\"text\"id=\"uname\"placeholder=\"UserName!..\"><\/td><\/tr>";
	ques += "<tr><td>Date*:<\/td><td><input type=\"text\"id=\"date\"placeholder=\"DateTime!..\"><\/td><\/tr>";
	ques += "<tr><td><button id=\"submit\">Submit<\/button><\/td><\/tr>";
	ques += "<\/table>";
   $('.question')[0].innerHTML=ques;
}

function answer(){
	var ans="";
	ans += "<table>";
	ans += "<tr><td>AnswerId*:<\/td><td><input id=\"id\"placeholder=\"AnswerId!..\"><\/td><\/tr>";
	ans += "<tr><td>Answer*:<\/td><td><input id=\"ans\"placeholder=\"Answer!..\"><\/td><\/tr>";
	ans += "<tr><td>UserName*:<\/td><td><input id=\"uname\"placeholder=\"UserName!..\"><\/td><\/tr>";
	ans += "<tr><td>Answerdate*:<\/td><td><input id=\"adate\"placeholder=\"adate!..\"><\/td><\/tr>";
	ans += "<tr><td><button id=\"sub\">Submit<\/button><\/td><\/tr>";
	ans += "<\/table>";
$('.answ')[0].innerHTML=ans;
}
function quest(){
	var strVar="";
	strVar += "<label>What is a HTML:<\/label>";
	strVar += "	<input type=\"text\" id=\"na\"  \/>";
	strVar += "	<input type=\"button\" value=\"enter\" onclick=\"diname()\"><br>";
	strVar += "<p id=\"paraid\"><\/p>";
	$('.anss')[0].innerHTML=strVar;
}
function diname(){
	text = na.value;
	document.getElementById("paraid").innerHTML+= '<p>'+text+'<hr>'; 
document.getElementById("na").value;
}


function myfunction(){
	var quesans="";
	quesans += "<table>";
	quesans += "<tr><td>QuestionId*:<\/td><td><input type=\"text\"id=\"qId\"placeholder=\"QuestionId!..\"><\/td><\/tr>";
	quesans += "<tr><td>AnswerId*:<\/td><td><input type=\"text\"id=\"aId\"placeholder=\"AnswerId!..\"><\/td><\/tr>";
	quesans += "<tr><td>Answer*:<\/td><td><input type=\"text\"id=\"answ\"placeholder=\"Answer!..\"><\/td><\/tr>";
	quesans += "<tr><td><button id=\"sub\">Submit<\/button><\/td><\/tr>";
	quesans += "<\/table>";
$('.answer')[0].innerHTML=quesans;
}


