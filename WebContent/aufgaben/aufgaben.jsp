<%@page import="ch.schoodle.model.Fach"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ch.schoodle.applicationdata.Faecher"%>
<%@page import="ch.schoodle.model.Aufgabe"%>
<%@page import="ch.schoodle.controller.AufgabenController"%>
<%@page import="ch.schoodle.model.Lehrer"%>
<%@page import="java.util.List"%>
<%@page import="ch.schoodle.data.LehrerDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container-fluid p-0">
	<div class="container pt-5">
		<div class="shadow p-4 bg-white">
			<div class="row">
				<div class="container">
					<h3 class="mb-4 text-center">Meine Aufgaben</h3>
					<div class="card">
						<div class="card-header">
							<div class="row">
								<div class="col-2">Fach</div>
								<div class="col-5">Aufgabe</div>
								<div class="col-3">geplante Zeit</div>
								<div class="col-2">zu erledigen bis</div>
							</div>
						</div>
					</div>
					
					<div id="accordion">
						
						<%
						AufgabenController controller = new AufgabenController(request);
						controller.chkSave();
						List<Aufgabe> aufgabenList = controller.getMeineAufgaben(auth.getUser());
						SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
						List<Fach> faecher = Faecher.INSTANCE.getFaecher();
						String selected = "";
						for(Aufgabe aufgabe : aufgabenList ){
						%>
						
						<div class="card">
							<div class="card-header">
								<a class="card-link" data-toggle="collapse" href="#collapseOne">
									<div class="row">
										<div class="col-2"><%out.print(Faecher.INSTANCE.getFachById(aufgabe.getFach()).getFach());%></div>
										<div class="col-5"><%out.print(aufgabe.getTitel());%></div>
										<div class="col-3"><%out.print(aufgabe.getGeplanteZeit()); %> Minuten</div>
										<div class="col-2"><%
										out.print(aufgabe.getZuErledigenBis()!=null?formater.format(aufgabe.getZuErledigenBis()) : ""); 
										%></div>
									</div>
								</a>
							</div>
							
							<div id="collapseOne" class="collapse show"
								data-parent="#accordion">
								<div class="card-body">
									<form action="index.jsp" method="post">
									<input type="hidden" name="idAufgaben" value="<%out.print(aufgabe.getIdAufgaben()); %>"
										<div class="row">
											<div class="col-6">
												<div class="form-group">
													<label for="fach">Fach:</label> <select
														class="form-control" name="fach" id="fach">
														<%
															;
															for(Fach fach : faecher){
																selected = "";
																if(aufgabe.getFach() == fach.getIdFach()){
																	selected = " selected=\"selected\"";
																}
														%>
														<option<%out.print(selected); %> value="<%out.print(fach.getIdFach());%>"><%out.print(fach.getFach());%></option>
														<%} %>
													</select>
												</div>
											</div>
											<div class="col-6">
												<div class="form-group">
													<label for="titel">Titel:</label> <input type="text"
														class="form-control" id="titel" name="titel" placeholder="Titel" value="<%out.print(aufgabe.getTitel());%>">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-12">
												<div class="form-group">
													<label for="beschreibung">Aufgabe:</label>
													<textarea class="form-control" rows="5" name="beschreibung" id="beschreibung"><%out.print(aufgabe.getBeschreibung());%></textarea>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-6">
												<div class="form-group">
													<label for="geplanteZeit">geplante Zeit in Minuten:</label>
													<input type="text" class="form-control" name="geplanteZeit" id="geplanteZeit" value="<%out.print(aufgabe.getGeplanteZeit());%>">
												</div>
											</div>
											<div class="col-6">
												<div class="form-group">
													<label for="zuErledigenBis<%out.print(aufgabe.getIdAufgaben());%>">zu erledigen bis:</label> 
													<input
														type="text" class="form-control" name="zuErledigenBis" id="zuErledigenBis<%out.print(aufgabe.getIdAufgaben());%>" value="<%
														out.print(aufgabe.getZuErledigenBis() != null? formater.format(aufgabe.getZuErledigenBis()) : "");
														%>">
														<script>
														$(function() {
															initDatePicker('zuErledigenBis<%out.print(aufgabe.getIdAufgaben());%>')
														});
													</script>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-6">
												<div class="form-group form-check">
													<label class="form-check-label"> <input
														class="form-check-input" value="1" name="wiederholend" type="checkbox"<%out.print(aufgabe.isWiederholend()?" checked=\"checked\"":""); %>>
														wiederholend
													</label>
												</div>
											</div>
											<div class="col-6">
												<div class="form-group form-check">
													<label class="form-check-label"> <input
														class="form-check-input" type="checkbox" name="erledigt" value="1"<%out.print(aufgabe.isErledigt()?" checked=\"checked\"":""); %>>
														erledigt
													</label>
												</div>
											</div>
										</div>
										<div class="d-flex justify-content-between">
											<div class="">
												<button type="button" class="btn btn-danger"
													data-dismiss="modal">abbrechen</button>
											</div>
											<div class="">
												<button type="submit" class="btn btn-primary">speichern</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							
						</div>
						<%} %>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
function initDatePicker(id){
	$('#'+id).datepicker({
		dateFormat : 'dd.mm.yy',
		startDate : '-3d'
	});
}
</script>
