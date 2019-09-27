<%@ page import="java.sql.*" %>
<%
   PreparedStatement lehrerliste = null;
   String query = "SELECT * from lehrer";
   Connection conn = (Connection)application.getAttribute("db");

   lehrerliste = conn.prepareStatement(query);
   ResultSet rs = lehrerliste.executeQuery();
   int count = 0;
   String lehrer = "";
   while ( rs.next()){
     if(count > 0){
       out.print(",");
     }
     count++;
     lehrer += "<li>" + rs.getInt("idLehrer") + " - " + rs.getString("nameLehrer") + "</li>";
  }
  lehrerliste.close();


 %>