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
			int contactNo =Integer.parseInt(request.getParameter("conNo"));
			String emailId = request.getParameter("email");
			JSONObject obj = new JSONObject();
			try {
				userClass user = new userClass();
				user.addUser(name, uName, password, contactNo, emailId);
				obj.put("status", 1);
			} catch (Exception e) {
				obj.put("status", 0);
				// TODO: handle exception
				e.printStackTrace();
			}
			response.getWriter().println(obj);		
		}else if(operation.equals("login")){
			JSONObject result=new JSONObject();
			String uName=request.getParameter("uName");
			String pass=request.getParameter("pass");
			try {
				userClass user=new userClass();
				result=user.login(uName, pass);
			} catch (Exception e) {
				result.put("status", 0);
				e.printStackTrace();
			}
			response.getWriter().println(result);
		}else if(operation.equals("getName")){
			 String uname = request.getParameter("uName");
	            JSONObject obj = new JSONObject();
	            try {
	            	userClass user = new userClass();
	            	obj = user.getName(uname);
				} catch (Exception e) {
					obj.put("status", 0);
					e.printStackTrace();
				}
	            response.getWriter().println(obj);
		}
	}

}
