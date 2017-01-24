package com.smartglossa.questionanswer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

import com.smartglossa.questionanswer.questionanswerConstants;

public class userClass {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	public userClass() throws ClassNotFoundException, SQLException {    
		openConnection();
	}

	public void addUser(String name, String uName, String password,int contactNo,String emailId) throws SQLException {
		try {
			String query = "insert into user(name,uName,password,contactNo,emailId) values('" + name + "','" + uName + "','" + password
					+ "',"+contactNo+",'"+emailId+"')";
			stmt.execute(query);
		} finally {
			// TODO: handle finally clause
			closeConnection();
		}
	}
	public JSONObject login(String uName,String pass)throws SQLException{
		JSONObject obj = new JSONObject();
		try {
			String query = "select * from user where uName='" +uName+ "' AND password=" +pass;
			rs=stmt.executeQuery(query);
			if(rs.next()){
				obj.put("uName", rs.getString("uName"));
			}
		} finally {
			closeConnection();
		}
		return obj;		
	}
	public JSONObject getName(String uName) throws ClassNotFoundException, SQLException{
		JSONObject obj = new JSONObject(); 
		try {
			String query = "select name from user where uName='"+uName+"'";
			rs=stmt.executeQuery(query);
	       if(rs.next()){
	    	   obj.put("name", rs.getString("name"));
	       }
		} finally {
			// TODO: handle finally clause
			closeConnection();
		}
		return obj;
		
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
