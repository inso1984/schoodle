<%@page import="ch.schoodle.controller.HomeController"%>
<%@ page session="true" trimDirectiveWhitespaces="true" %>

<%@  include file="/controllers/db_setup.jsp" %>
<%@  include file="/controllers/preload_data.jsp" %>

<ul>
<%
  HomeController hc = new HomeController(request);
  if (application.getAttribute ("db") != null)
  {
    out.print(lehrer);
  } else {
    out.println("Datenbank Fehler");
  }

%>
</ul>


<%
if (application.getAttribute ("db") != null)
  {
       out.print("conn open");
  }
%>


