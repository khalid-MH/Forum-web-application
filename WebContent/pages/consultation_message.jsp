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
<table border=1>
<tr> <td> Themes </td>
<td>
<select name="theme">
<option value=""> </option>
</select>
</td>
</tr>
</table>
<table border=1>
<tr> <td> id</td><td>titre</td><td>Message</td><td>user</td></tr>
<%
String driver = "com.mysql.jdbc.Driver";
String con = "jdbc:mysql://localhost:3306/forum";
String req = "select * from messages";
try {
Class.forName(driver);
Connection conn=DriverManager.getConnection(con, "root" ,"");
PreparedStatement st=conn.prepareStatement(req);
ResultSet res=st.executeQuery();
while(res.next()) {
int id=res.getInt(1);
String titre=res.getString(2);
String message=res.getString(3);
String user=res.getString(6);

out.println("<tr><td>" +id+"</td><td>"+titre+"</td><td>"+message+"</td><td>"+user+"</td></tr>");
	}
}
catch(Exception e){ 
	System.out.println(e.getMessage());
}
%>

</table>
</body>
</html>