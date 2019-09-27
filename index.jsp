<%@ page session="true" trimDirectiveWhitespaces="true" %>

<%@  include file="/controllers/db_setup.jsp" %>
<%@  include file="/controllers/preload_data.jsp" %>

<ul>
<%
out.print(request.getParameter("index"));
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


