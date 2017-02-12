package com.smartglossa.qa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

public class QAServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QAServlet() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");
        if (operation.equals("add")) {
            JSONObject ob = new JSONObject();
   
            String question = request.getParameter("question");
       
    
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + QAConstants.MYSQL_SERVER + "/" + QAConstants.DATABASE, QAConstants.USERNAME,
                        QAConstants.PASSWORD);
                Statement state = conn.createStatement();
                String query =
                        "insert into question(question,qdate) values('" + question + "',NOW())";
                
                state.execute(query);
                ob.put("status", "1");
            } catch (Exception e) {
                ob.put("status", "0");
                e.printStackTrace();
            }
            response.getWriter().println(ob);
        } else if (operation.equals("getAll")) {
            JSONArray all = new JSONArray();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + QAConstants.MYSQL_SERVER + "/" + QAConstants.DATABASE, QAConstants.USERNAME,
                        QAConstants.PASSWORD);
                Statement statement = conn.createStatement();
                String query = "select * from question";
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    JSONObject object = new JSONObject();
                     object.put("question", result.getString(2));
                    object.put("qdate", result.getString(3));
                    all.put(object);
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            response.getWriter().println(all);
        } else if (operation.equals("update")) {
            JSONObject up = new JSONObject();
            int id = Integer.parseInt(request.getParameter("qid"));
            String question = request.getParameter("question");  
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + QAConstants.MYSQL_SERVER + "/" + QAConstants.DATABASE, QAConstants.USERNAME,
                        QAConstants.PASSWORD);
                Statement statement = conn.createStatement();
                String query =
                        "update question set question='" + question +  "' where id= " + id;
                statement.execute(query);
                up.put("status", "1");
            } catch (Exception e) {
                up.put("status", "0");
                e.printStackTrace();
            }
            response.getWriter().println(up);

        } else if (operation.equals("delete")) {
            JSONObject delete = new JSONObject();
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://" + QAConstants.MYSQL_SERVER + "/" + QAConstants.DATABASE, QAConstants.USERNAME,
                        QAConstants.PASSWORD);
                Statement sta = conn.createStatement();
                String query = "delete from question where id=" + id;
                sta.execute(query);
                delete.put("status", "1");
            } catch (Exception e) {
                delete.put("status", "0");
                e.printStackTrace();
            }
            response.getWriter().println(delete);
        } else if(operation.equals("ansAdd")){
        	
        	JSONObject ansAdd = new JSONObject();
        	String answer = request.getParameter("answer");
        	int qid = Integer.parseInt(request.getParameter("qid"));
        	
            
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
				        "jdbc:mysql://" + QAConstants.MYSQL_SERVER + "/" + QAConstants.DATABASE, QAConstants.USERNAME,
				        QAConstants.PASSWORD);
	            Statement sta = conn.createStatement();
	            String query="insert into answer(answer,ansDate,qid)values('" + answer + "',NOW()," + qid + ")";
	            sta.execute(query);
	            ansAdd.put("status", "1");
			} catch (Exception e) {
			          ansAdd.put("status", "0");
				e.printStackTrace();
			}
	        response.getWriter().println(ansAdd);
        } 
        else if(operation.equals("ansAll")){
        	JSONArray anall = new JSONArray();
        	 try {
				Class.forName("com.mysql.jdbc.Driver");
				 Connection conn = DriverManager.getConnection(
	                     "jdbc:mysql://" + QAConstants.MYSQL_SERVER + "/" + QAConstants.DATABASE, QAConstants.USERNAME,
	                     QAConstants.PASSWORD);
	             Statement statement = conn.createStatement();
	             String query = "select * from answer";
	             ResultSet re = statement.executeQuery(query);
	             while(re.next())
	             {
	            	 JSONObject getAll = new JSONObject();
	            	 getAll.put("answer", re.getString("answer"));
	            	 getAll.put("ansDate", re.getTimestamp("ansDate"));
	            	 getAll.put("qid",re.getInt("qid"));
	            	 anall.put(getAll);
	             }
			} catch (Exception e) {
			
				e.printStackTrace();
			}
 	        response.getWriter().println(anall);
        }
        
        else if(operation.equals("getAns"))
        {
        	int qid = Integer.parseInt(request.getParameter("qid"));
        	JSONArray getone = new JSONArray();
        	try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
	                    "jdbc:mysql://" + QAConstants.MYSQL_SERVER + "/" + QAConstants.DATABASE, QAConstants.USERNAME,
	                    QAConstants.PASSWORD);
	            Statement statement = conn.createStatement();
	            String query = "select * from answer where qid ="+qid;
	            ResultSet one = statement.executeQuery(query);
	            while(one.next()){
	            	JSONObject get = new JSONObject();
	            	get.put("ansId",one.getInt("ansId"));
	            	get.put("answer", one.getString("answer"));
	            	get.put("ansDate", one.getString("ansDate"));
	            	getone.put(get);
	            }
			} catch (Exception e) {
			
				e.printStackTrace();
			}
	        response.getWriter().println(getone);
  
        }
    }
   

}
