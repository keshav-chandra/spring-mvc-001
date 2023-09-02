<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="update" modelAttribute="emp">
	ID : <form:input path="id"/>
   NAME : <form:input path="name"/>
	SAL : <form:input path="sal"/>
	 <form:button>UPDATE</form:button>
	</form:form>

</body>
</html>