<%@ page session="true" trimDirectiveWhitespaces="true" %>

<%@  include file="/controllers/db_setup.jsp" %>
<%@  include file="/controllers/preload_data.jsp" %>

<%
  if (application.getAttribute ("db") != null)
  {
    out.println("Datenbank verbunden");
  } else {
    out.println("Datenbank Fehler");
  }

%>


