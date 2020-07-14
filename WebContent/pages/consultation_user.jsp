<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
<%@ include file="menu_admin.jsp" %>
<table>
<tr> <th colspan="4"> Consultation des utilisateurs </th></tr>
<tr> <td> login </td> <td> password </td> <td> Email </td>
<td>Actions </td></tr>
<%
String driver = "com.mysql.jdbc.Driver";
String con = "jdbc:mysql://localhost:3306/forum";
String req = "select * from users";
try {
Class.forName(driver);
Connection conn=DriverManager.getConnection(con, "root" ,"");
PreparedStatement st=conn.prepareStatement(req);
ResultSet res=st.executeQuery();
	while(res.next()) {
		String login=res.getString(1);
		String pwd=res.getString(2);
		String email=res.getString(3);
		
		out.println("<tr><td>"+login+"</td><td>"+pwd+"</td><td>"+email+"</td></td>"
		); //supression= page de servlet ?v=donner à la variable v, la valeur+ncompte+ 
	}
}
catch(Exception e){ 
	System.out.println(e.getMessage());
}
%>
</table>


</body>
</html>