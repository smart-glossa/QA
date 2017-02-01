package com.smartglossa.answer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class questionAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public questionAnswerServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");
		if (operation.equals("queansAdd")) {
			JSONObject ob = new JSONObject();
			String question = request.getParameter("question");
			String answer = request.getParameter("answer");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionanswer", "root",
						"root");
				Statement state = conn.createStatement();
				String query = "insert into questionanswer(question,answer) values('" + question + "','" + answer + "')";
				state.execute(query);
				ob.put("status", "1");
			} catch (Exception e) {
				ob.put("status", "0");
				e.printStackTrace();
			}
			response.getWriter().println(ob);
		}
		else if(operation.equals("queansAll")){
			JSONArray all = new JSONArray();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionanswer", "root",
						"root");
				Statement statement = conn.createStatement();
				String query="select * from questionanswer";
				ResultSet result = statement.executeQuery(query);
				while(result.next()){
					JSONObject object = new JSONObject();
					object.put("question", result.getString(1));
					object.put("answer", result.getString(2));
					all.put(object);
				}
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			response.getWriter().println(all);
		}
	}

}
