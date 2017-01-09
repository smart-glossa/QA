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
		String uname = request.getParameter("uName");
		String date=request.getParameter("date");
		JSONObject obj = new JSONObject();
		
			try {
			    QuestionClass ques = new QuestionClass();
			    ques.add(question, uname, date);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status",0);
				e.printStackTrace();
			}
			response.getWriter().print(obj);
		}else if(operation.equals("getAll")){
			JSONArray res = new JSONArray(); 
			try {
				QuestionClass ques = new QuestionClass();
				res = ques.getAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.getWriter().print(res);
		}else if(operation.equals("delete")){
			JSONObject obj = new JSONObject();
			int quesId = Integer.parseInt(request.getParameter("quesId"));
			try {
				QuestionClass ques = new QuestionClass();
				ques.delete(quesId);
				obj.put("status", 1);
				} catch (Exception e) {
				obj.put("Status", 0);
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
				String query = "Select *from question where qusId="+qid;
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next()){
					obj.put("quesId", rs.getInt(1));
					obj.put("question", rs.getString(2));
					obj.put("userName", rs.getString(3));
					obj.put("qdate",rs.getString(4));
				}
			} catch (Exception e) {
				
				obj.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(obj);
			
		}
		
	}

}
