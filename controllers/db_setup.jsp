<%@ page import="java.sql.*" %>

<%
  if (application.getAttribute ("db") == null)
  {

    try {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/schoodle?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

    application.setAttribute ("db", conn);

    }
    catch(ClassNotFoundException e)
    {
      application.setAttribute ("db", null);
    }
  }

%>