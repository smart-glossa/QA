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
			int quesId = Integer.parseInt(request.getParameter("qId"));
			JSONObject obj = new JSONObject();
			try {
				QuestionClass ques = new QuestionClass();
				obj = ques.getOne(quesId);
					}
			 catch (Exception e) {
				obj.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().print(obj);
			
		}else if(operation.equals("addAnswer")){
			String answer = request.getParameter("ans");
			String uName = request.getParameter("uName");
			String adate = request.getParameter("date");
			JSONObject obj = new JSONObject();
			
				try {
				    QuestionClass ques = new QuestionClass();
				    ques.addAnswer(answer, uName, adate);
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
				res = ques.getAllanswer();
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.getWriter().print(res);
		}else if(operation.equals("delete")){
			JSONObject obj = new JSONObject();
			int ansId = Integer.parseInt(request.getParameter("ansId"));
			try {
				QuestionClass ques = new QuestionClass();
				ques.deleteAnswer(ansId);
				obj.put("status", 1);
			} catch (Exception e) {
				// TODO: handle exception
				obj.put("status", 0);
				e.printStackTrace();
		     }
			response.getWriter().println(obj);
		}else if(operation.equals("getOneAnswer")){
			JSONObject obj = new JSONObject();
			int quesId = Integer.parseInt(request.getParameter("qusId"));
			try {
				QuestionClass ques = new QuestionClass();
				obj = ques.getOne(quesId);
			} catch (Exception e) {
				// TODO: handle exception
				obj.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().println(obj);
		}else if(operation.equals("addQA")){
			String questionId = request.getParameter("qId");
			String answerId = request.getParameter("aId");
			JSONObject obj = new JSONObject();
			
				try {
				    QuestionClass ques = new QuestionClass();
				    ques.add(questionId, answerId);
					obj.put("status", 1);
				} catch (Exception e) { 
					obj.put("status",0);
					e.printStackTrace();
				}
				response.getWriter().print(obj);
			}else if(operation.equals("getAllQA")){
				JSONArray res = new JSONArray(); 
				try {
					QuestionClass ques = new QuestionClass();
					res = ques.getAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
				response.getWriter().println(res);				
			}
		}
	}

