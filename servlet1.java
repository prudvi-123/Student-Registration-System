package com.jdbc;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class servlet1
 */
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();  
	
	//pw.print(name); 
	 
	try {   
		Class.forName("com.mysql.jdbc.Driver");
		 
		 String url="jdbc:mysql://localhost:3306/root";
	        String username="root";
	        String password="9866";
	        Connection c =DriverManager.getConnection(url,username,password); 
	        String users=request.getParameter("username");
	        String passs=request.getParameter("password"); 
	        String ss="select * from regis where user=?  and pass=?";
	        PreparedStatement pt =c.prepareStatement(ss); 
	        pt.setString(1, users);   
	        pt.setString(2,passs);
	        ResultSet set = pt.executeQuery(); 
	        if(set.next()) { 
	        	RequestDispatcher rd= request.getRequestDispatcher("success.html"); 
	        	rd.forward(request, response);
 
	        	
	        } 
	        else {  
	        	RequestDispatcher rd= request.getRequestDispatcher("retry.html"); 
	        	rd.forward(request, response);
	        	
	        }
	        
		
		
	} 
	catch(Exception e ) {  
		e.printStackTrace();  
		pw.print("insertion failed ");
		
	}
		
	}

	

}
