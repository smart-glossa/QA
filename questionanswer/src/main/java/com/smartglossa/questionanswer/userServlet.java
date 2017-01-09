package com.smartglossa.questionanswer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	public userServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("addUser")){
			String name = request.getParameter("name");
			String uName = request.getParameter("uname");
			String password = request.getParameter("psw");
			JSONObject obj = new JSONObject();
			try {
				userClass user = new userClass();
				user.addUser(name, uName, password);
			} catch (Exception e) {
				obj.put("status", 0);
				// TODO: handle exception
				e.printStackTrace();
			}
			response.getWriter().println(obj);		
		}else if(operation.equals("getOne")){
			 int userId = Integer.parseInt(request.getParameter("userId"));
	            JSONObject obj = new JSONObject();
	            try {
	            	userClass user = new userClass();
	            	obj = user.getOne(userId);
				} catch (Exception e) {
					// TODO: handle exception
					obj.put("status", 0);
					e.printStackTrace();
				}
	            response.getWriter().println(obj);
		}else if(operation.equals("delete")){
			int userId = Integer.parseInt(request.getParameter("userId"));
			JSONObject obj = new JSONObject();
			try {
				userClass user = new userClass();
				user.delete(userId);
				obj.put("status", 1);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			response.getWriter().println(obj);
		}
	}

}
