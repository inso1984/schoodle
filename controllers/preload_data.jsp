<%@ page import="java.sql.*" %>
<%
   PreparedStatement lehrerliste = null;
   String query = "SELECT * from lehrer";
   Connection conn = (Connection)application.getAttribute("db");
   if(conn == null){
     out.print("h1");
   }

   lehrerliste = conn.prepareStatement();
   ResultSet rs = lehrerliste.executeQuery(query);

   out.print("[");
   rs.next();
   while (true){
    %>
      "user_id" : "<%=rs.getInt("idLehrer")%>" , "username" : "<%=rs.getString("nameLehrer")%>"
    <%
    if(rs.next())
      {
    %>
      ,
    <%
    }
      else break;
  }
  out.print("]");


 %>