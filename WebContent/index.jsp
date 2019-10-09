<%@page import="ch.schoodle.model.Lehrer"%>
<%@page import="java.util.List"%>
<%@page import="ch.schoodle.data.LehrerDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Schoodle</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans|Schoolbell&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="schoodle.css" media="screen" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>


	<%@ include file="../header.html"%>


    <main>
	
	<%@ include file="../index.html"%>
	
	<%@ include file="../dashboard.jsp"%>
	
	<%@ include file="../aufgaben.jsp"%>
	
    </main>


</body>

</html>