<%

   PreparedStatement lehrerliste = null;
   String query = "SELECT * from lehrer";
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