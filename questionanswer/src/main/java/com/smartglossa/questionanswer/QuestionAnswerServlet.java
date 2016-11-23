package com.smartglossa.questionanswer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String question = request.getParameter("ques");
		String answer = request.getParameter("ans");
		if(operation.equals("add")){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qa", "root", "root");
				Statement stmt = conn.createStatement();
				String query = "insert into question(question,answer) values('" + question + "','" + answer + "')";
				stmt.execute(query);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
