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
<form method="post" action="../Ajout_message">
<table>
<tr> <th colspan="2"> Ajout de message</th></tr>
<tr> 
  <td> thème</td>
  <td> <select name="theme">
<%
String driver = "com.mysql.jdbc.Driver";
	String con = "jdbc:mysql://localhost:3306/forum";
	String req = "select * from themes";
	try {
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(con, "root" ,"");
	PreparedStatement st=conn.prepareStatement(req);
	ResultSet res=st.executeQuery();
	while(res.next()) {
	int id=res.getInt(1);
	String label=res.getString(2);
	
	out.println("<option value='"+id+"'>"+label+"</option>");
		}
	}
	catch(Exception e){ 
		System.out.println(e.getMessage());
	}
%>

  </select> </td>
</tr>
<tr>
<td> Titre </td> 
<td> <input type="text" name="titre"> </td>
</tr>
<tr>
<td> Message </td>
<td> <textarea name="message"></textarea> </td>
</tr>
<tr>
<td> <input type="submit" value="OK"> </td>
<td> <input type="reset" value="annuler"> </td>
 </tr>
</table>
</form>

</body>
</html>