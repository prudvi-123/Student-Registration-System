<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ page import="java.sql.Connection"%> 
    <%@ page import="java.sql.DriverManager" %> 
    <%@ page import ="java.sql.PreparedStatement" %> 
    <%@ page import ="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<%  
try{   
	Class.forName("com.mysql.jdbc.Driver");
	 
	 String url="jdbc:mysql://localhost:3306/root";
       String username="root";
       String password="9866";
       Connection c =DriverManager.getConnection(url,username,password); 
       String users=request.getParameter("use");
       String passs=request.getParameter("ps");  
       
       String ss="insert into regis values(?,?)";
       PreparedStatement pt =c.prepareStatement(ss);  
       
       pt.setString(1, users);   
       pt.setString(2,passs); 
       pt.executeUpdate();
	
       response.sendRedirect("destination.jsp");
} 
catch(Exception e ){ 
	e.printStackTrace();  
	 response.sendRedirect("retry.jsp");
	
	
}
 
  
   
   %>

</body>
</html>