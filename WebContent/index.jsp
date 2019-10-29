<%@page import="ch.schoodle.controller.AuthController"%>
<%@page import="ch.schoodle.model.Lehrer"%>
<%@page import="java.util.List"%>
<%@page import="ch.schoodle.data.LehrerDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
AuthController auth = new AuthController(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Schoodle</title>
<%@ include file="htmlHead.html"%>

<body>
	<%@ include file="header.jsp"%>


	<main> 
	<%@ include file="indexTemplate.jsp"%>
	<%@ include file="dashboard.jsp"%>


</body>

</html>