package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcPro
 */
@WebServlet("/JdbcPro")
public class JdbcPro1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JdbcPro1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String us = request.getParameter("user");
		String pas = request.getParameter("pass");
		
		String id=null;
		String pass=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection co = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","bharath");
	    String s="select * from employees where userid='"+us+"' and password='"+pas+"'";
	    PreparedStatement st = co.prepareStatement(s);
	    ResultSet Qu = st.executeQuery();
	    while (Qu.next()) {
	         id = Qu.getString("userid");
	         pas = Qu.getString("password");
		}
	    PrintWriter w = response.getWriter();
	    if (us.equals(id)) {
			w.println("welcome to facebook");
		}
	    else {
	    w.println("invalid");
    }
	    co.close();
		} catch (ClassNotFoundException| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}


	}


