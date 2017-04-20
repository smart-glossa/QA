<p> <b>Model </b></p> 
<p>
1.question:
CREATE TABLE question (
  qid int(11) NOT NULL AUTO_INCREMENT,
  question varchar(100),
  qdate date,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
</p>
<p>
2. CREATE TABLE answer (
  ansId int(11) NOT NULL AUTO_INCREMENT,
  answer mediumText,
  ansDate date,
  qid int(11) foreign key (question)
  )      --> please correct the syntact once you have created the table in database.
</p>
<p><b> View </b></p>
<p> Form1: </p>
<p> 1. One TextArea and One Submit button </p>
<p> Form2: </p>
<p> Should display all the question and mulitple answers (with date and time) in the table view </p>

<p> <b>Controller </b></p>
<p> Case1: Add Question and answer: </p>
Insert into question(question, qdate) values ("What is HTML?", "07/02/2017 5:00PM"); </br>
<p> Case 2: View Question and Answers: </p>
<p> JSONReponse: </p>
<p> { "qid": 1, </p>
<p>    "question" : {"content": "What is HTML", "qdate": "07/02/2017 5:00PM" }, </p>
<p>    "answers" : [{"ansId: 25", "content": "All is well", "ansDate": "07/02/2017 5:00PM"}, {"ansId: 26", "content": "All is well2", "ansDate": "08/02/2017 6:00PM"}], </p>
<p> } </p>
<p>
CREATE TABLE `answer` (
  `ansId` int(11) NOT NULL auto_increment,
  `answer` mediumtext,
  `qid` int(11) default NULL,
  `ansDate` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`ansId`),
  KEY `qid` (`qid`),
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`qid`) REFERENCES `question` (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1      
</p>
