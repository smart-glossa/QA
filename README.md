<p> <b>Model </b></p> 
<p>
1.questionAnswer:
CREATE TABLE questionAnswer (
  id int(11) NOT NULL AUTO_INCREMENT,
  question varchar(100),
  answer varchar(500),
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
</p>
<p><b> View </b></p>
<p> Form1: </p>
<p> 1. Two TextArea and One Submit button </p>
<p> Form2: </p>
<p> Should display all the question and answers in the table view </p>

<p> <b>Controller </b></p>
<p> Case1: Add Question and answer: </p>
Insert into questionAnswer(question, answer) values ("What is HTML?", "HTML stands for Hyper Text Markup Language"); </br>
<p> Case 2: View Question and Answers: </p>
select * from questionAnswer </br>


      
