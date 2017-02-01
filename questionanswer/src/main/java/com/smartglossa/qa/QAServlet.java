package com.smartglossa.qa;

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
            String answer = request.getParameter("answer");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionanswer", "root",
                        QAConstants.PASSWORD);
                Statement state = conn.createStatement();
                String query =
                        "insert into questionanswer(question,answer) values('" + question + "','" + answer + "')";
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionanswer", "root",
                        QAConstants.PASSWORD);
                Statement statement = conn.createStatement();
                String query = "select * from questionanswer";
                ResultSet result = statement.executeQuery(query);
                while (result.next()) {
                    JSONObject object = new JSONObject();
                    object.put("id", result.getInt(1));
                    object.put("question", result.getString(2));
                    object.put("answer", result.getString(3));
                    all.put(object);
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
            response.getWriter().println(all);
        } else if (operation.equals("update")) {
            JSONObject up = new JSONObject();
            int id = Integer.parseInt(request.getParameter("id"));
            String question = request.getParameter("question");
            String answer = request.getParameter("answer");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionanswer", "root",
                        QAConstants.PASSWORD);
                Statement statement = conn.createStatement();
                String query =
                        "update questionanswer set question='" + question + "',answer='" + answer + "' where id= " + id;
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
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionanswer", "root",
                        QAConstants.PASSWORD);
                Statement sta = conn.createStatement();
                String query = "delete from questionanswer where id=" + id;
                sta.execute(query);
                delete.put("status", "1");
            } catch (Exception e) {
                delete.put("status", "0");
                e.printStackTrace();
            }
            response.getWriter().println(delete);
        }
    }

}
