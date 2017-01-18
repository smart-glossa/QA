function question(){
	var user="";
user += "<table>";
user += "<tr><td>UserId*:<\/td><td><input type=\"text\"id=\"userid\"placeholder=\"UserId!..\"><\/td><\/tr>";
user += "<tr><td>Name*:<\/td><td><input type=\"text\"id=\"name\"placeholder=\"Name!..\"><\/td><\/tr>";
user += "<tr><td>UserName*:<\/td><td><input type=\"text\"id=\"uname\"placeholder=\"UserName!..\"><\/td><\/tr>";
user += "<tr><td>Password*:<\/td><td><input type=\"password\"id=\"pass\"placeholder=\"Password!..\"><\/td><\/tr>";
user += "<tr><td><button id=\"submit\">Submit<\/button><\/td><td><button id=\"update\">Update<\/button><\/td><\/tr>";
user += "<\/table>";
$('.use')[0].innerHTML=user;
}
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


