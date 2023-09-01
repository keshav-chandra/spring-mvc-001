<%@page import="com.org.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${msg}</h1>
<table border=2px>
<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>SALARY</th>
	<th>EDIT</th>
	<th>DELETE</th>
</tr>

   <%
      List<Employee> emps=(List<Employee>) request.getAttribute("emps");
      for(Employee e : emps){    
   %>
   <tr>
   		<td><%= e.getId() %></td>
   		<td><%= e.getName() %></td>
   		<td><%= e.getSal() %></td>
   		<td><a href="edit?id=<%= e.getId() %>">edit</a></td>
   		<td><a href="delete?id=<%= e.getId() %>">delete</a></td>
   		
   		</tr>
   		<% }
   		%>
  </table>
</body>
</html>