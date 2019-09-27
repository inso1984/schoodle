<%

  if (application.lehrerliste ("db") != null)
  {
    Statement lehrerliste = conn.createStatement("select * from lehrer");
    lehrerliste.executeQuery( lehrerliste);
    out.println()
  } else {

  }


 %>