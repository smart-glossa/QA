package com.smartglossa.questionanswer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class QuestionAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionAnswerServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("add")){
		String question = request.getParameter("ques");
		String answer = request.getParameter("ans");
		JSONObject result = new JSONObject();
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "root");
				Statement stmt = conn.createStatement();
				String query = "insert into question(question,answer) values('" + question + "','" + answer + "')";
				stmt.execute(query);
				result.put("status", "success");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result.put("message", e.getMessage());
				result.put("status","internal error occur");
				e.printStackTrace();
			}
			response.getWriter().print(result);

		}else if(operation.equals("getAll")){
			JSONArray res = new JSONArray(); 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "root");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select *from question");
				while(rs.next()){
					JSONObject obj = new JSONObject();
					obj.put("id", rs.getInt(1));
					obj.put("question", rs.getString(2));
					obj.put("answer", rs.getString(3));
					res.put(obj);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().print(res);
			
		}else if(operation.equals("delete")){
			JSONObject obj = new JSONObject();
			int qid = Integer.parseInt(request.getParameter("qid"));
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "root");
				Statement stmt = conn.createStatement();
				String query = "Delete from question where qid="+ qid;
				stmt.execute(query);
				obj.put("Status", "success");
			} catch (Exception e) {
				obj.put("Status", "Failure");
				e.printStackTrace();
			}
			response.getWriter().print(obj);
			
		}else if(operation.equals("getOne")){
			JSONObject obj = new JSONObject();
			int qid = Integer.parseInt(request.getParameter("qid"));
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "root");
				Statement stmt = conn.createStatement();
				String query = "Select *from question where qid="+qid;
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()){
					obj.put("qid", rs.getInt(1));
					obj.put("question", rs.getString(2));
					obj.put("answer", rs.getString(3));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				obj.put("status", "failure");
				e.printStackTrace();
			}
			response.getWriter().print(obj);
			
		}
		
	}

}
