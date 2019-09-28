<%@page import="ch.scoodle.model.Lehrer"%>
<%@page import="java.util.List"%>
<%@page import="ch.scoodle.data.LehrerDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 	
    LehrerDAO lehrerDAO = new LehrerDAO();
	
	List<Lehrer> lehrerList = lehrerDAO.getLehrerList();
%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Schoodle</title>
    <title>Schoodle</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans|Schoolbell&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="schoddle.css" media="screen" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>

    <header>
        <div class="container-fluid p-0">
            <nav class="navbar navbar-expand-sm bg-dark justify-content-between">
                <h1 class="schoodle">Schoodle</h1>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Aufgaben</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Stundenplan</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Noten</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Meine Fächer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Meine Lehrer</a>
                    </li>
                </ul>
                <a href="#" class="btn btn-primary m-5 pl-4 pr-4">Login</a>
            </nav>
        </div>
    </header>

    <main>
        <div class="container-fluid p-0">
            <div class="container pt-5">
                <div class="row">
                    <div class="col-12">
                        <div class="d-flex justify-content-center">
                            <div class="shadow p-4 mb-4 bg-white w-95">Aufgaben</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="d-flex justify-content-around">
                            <div class="shadow p-4 mb-4 bg-white w-45">Stundenplan</div>
                            <div class="shadow p-4 mb-4 bg-white w-45">Noten</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="d-flex justify-content-around">
                            <div class="shadow p-4 mb-4 bg-white w-45"><h4>Meine Lehrer (<%out.print(lehrerList.size());%>)</h4>
                            <%
                            	for(Lehrer lehrer: lehrerList){
                            		out.print("<div>" + lehrer.getIdLehrer() + " - " + lehrer.getNameLehrer() + "</div>");
                            	}
                            %>
                            </div>
                            <div class="shadow p-4 mb-4 bg-white w-45">Meine Fächer</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>


</body>

</html>