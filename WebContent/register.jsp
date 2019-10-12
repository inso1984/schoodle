<%@page import="ch.schoodle.controller.AuthController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<%
	AuthController auth = new AuthController(request);
	auth.register(request,response);
%>