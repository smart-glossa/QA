database name:qa
tables: 1.user
        2.question
        3.answer
        4.qa
1.USER:
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `uName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `uName` (`uName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |

2.QUESTION:
question | CREATE TABLE `question` (
  `qusId` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(100) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `qdate` date DEFAULT NULL,
  PRIMARY KEY (`qusId`),
  KEY `fk_question` (`userName`),
  CONSTRAINT `fk_question` FOREIGN KEY (`userName`) REFERENCES `user` (`uName`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |

3.ANSWER:
answer | CREATE TABLE `answer` (
  `answerId` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(200) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `adate` date DEFAULT NULL,
  PRIMARY KEY (`answerId`),
  KEY `userName` (`userName`),
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`userName`) REFERENCES `user` (`uName`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |

4.QA:
qa    | CREATE TABLE `qa` (
  `questionId` int(11) DEFAULT NULL,
  `answerId` int(11) DEFAULT NULL,
  KEY `answerId` (`answerId`),
  KEY `questionId` (`questionId`),
  CONSTRAINT `qa_ibfk_1` FOREIGN KEY (`answerId`) REFERENCES `answer` (`answerId`) ON DELETE CASCADE,
  CONSTRAINT `qa_ibfk_2` FOREIGN KEY (`questionId`) REFERENCES `question` (`qusId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |

      
