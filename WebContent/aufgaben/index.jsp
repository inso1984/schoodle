<%@page import="ch.schoodle.controller.AuthController"%>
<%@page import="ch.schoodle.model.Lehrer"%>
<%@page import="java.util.List"%>
<%@page import="ch.schoodle.data.LehrerDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
AuthController auth = new AuthController(request);
if(!auth.checkAuth()){
	
	auth.redirectToHome(response);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schoodle - Aufgaben</title>
<%@ include file="../htmlHead.html"%>
</head>

<body>
	<%@ include file="../header.jsp"%>
	<main>
	<%@ include	file="./aufgaben.jsp"%> </main>
</body>

</html>