<%@page import="ch.schoodle.model.Lehrer"%>
<%@page import="java.util.List"%>
<%@page import="ch.schoodle.data.LehrerDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	LehrerDAO lehrerDAO = new LehrerDAO();

	List<Lehrer> lehrerList = lehrerDAO.getLehrerList();
%>

<div class="container-fluid p-0">
	<div class="container pt-5">
		<div class="row">
			<div class="col-12">
				<div class="d-flex justify-content-center">
					<div class="shadow p-4 mb-4 bg-white w-95">Meine Aufgaben</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<div class="d-flex justify-content-around">
					<div class="shadow p-4 mb-4 bg-white w-45">Mein Stundenplan</div>
					<div class="shadow p-4 mb-4 bg-white w-45">Meine Noten</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<div class="d-flex justify-content-around">
					<div class="shadow p-4 mb-4 bg-white w-45">
						<h4>
							Meine Lehrer (<%
							out.print(lehrerList.size());
						%>)
						</h4>
						<%
							for (Lehrer lehrer : lehrerList) {
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