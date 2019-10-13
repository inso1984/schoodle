<%@page import="ch.schoodle.controller.AuthController"%><%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="utf-8"%>{"success":<%
	AuthController auth = new AuthController(request);
	out.print(auth.doLogin(request,response));
%>}