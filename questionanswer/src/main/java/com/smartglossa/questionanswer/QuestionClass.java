package com.smartglossa.questionanswer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class QuestionClass {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	public QuestionClass() throws ClassNotFoundException, SQLException {
		openConnection();
	}
 public void add(String question,String uname,String date) throws SQLException{
	 try {
		String query="insert into question(question,userName,qdate)values('"+question+"','"+uname+"','"+date+"')";
		stmt.execute(query);
	 }
			 finally {
		// TODO: handle finally clause
				 closeConnection();
	}
 }
 public JSONArray getAll()throws ClassNotFoundException, SQLException{
 JSONArray array = new JSONArray();
 try {
	 String query = "Select *from question";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			JSONObject obj = new JSONObject();
			obj.put("qusId", rs.getInt("qusId"));
			obj.put("question", rs.getString("question"));
			obj.put("userName", rs.getString("userName"));
			obj.put("qdate",rs.getString("qdate"));
		}
} finally {
	// TODO: handle finally clause
	closeConnection();
}
return array;
 }
 public void delete(int quesId) throws SQLException{
	 try {
		 String query = "Delete from question where qusId="+ quesId;
			stmt.execute(query);
	} finally {
		// TODO: handle finally clause
		closeConnection();
	}
 }
public void openConnection() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection(
			"jdbc:mysql://" + questionanswerConstants.MYSQL_SERVER + "/" + questionanswerConstants.DATABASE,
			questionanswerConstants.USERNAME, questionanswerConstants.PASSWORD);
	stmt = conn.createStatement();
}
public void closeConnection() throws SQLException {
	if (conn != null) {
		conn.close();
	}
	if (stmt != null) {
		stmt.close();
	}
	if (ps != null) {
		ps.close();
	}
	if (rs != null) {
		rs.close();
	}
}
}