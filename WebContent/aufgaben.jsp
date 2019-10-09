<%@page import="ch.schoodle.model.Lehrer"%>
<%@page import="java.util.List"%>
<%@page import="ch.schoodle.data.LehrerDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div class="container-fluid p-0">
	<div class="container pt-5">
		<div class="shadow p-4 bg-white text-center">
			<div class="row">
				<div class="container">
					<h3 class="mb-4">Meine Aufgaben</h3>
					<div id="accordion">
						<div class="card">
							<div class="card-header">
								<a class="card-link" data-toggle="collapse" href="#collapseOne">Aufgabe
									1</a>
							</div>
							<div id="collapseOne" class="collapse show"
								data-parent="#accordion">
								<div class="card-body">
									<form action="/action_page.php">
										<div class="row">
											<div class="col-6">
												<div class="form-group">
													<label for="fach">Fach:</label> <select
														class="form-control" id="fach">
														<option value="">Mathe</option>
														<option value="">Deutsch</option>
														<option value="">Englisch</option>
														<option value="">Französisch</option>
													</select>
												</div>
											</div>
											<div class="col-6">
												<div class="form-group">
													<label for="titel">Titel:</label> <input type="text"
														class="form-control" id="titel">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-12">
												<div class="form-group">
													<label for="beschreibung">Aufgabe:</label>
													<textarea class="form-control" rows="5" id="beschreibung"></textarea>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-6">
												<div class="form-group">
													<label for="beschreibung">geplante Zeit in Minuten:</label>
													<input type="text" class="form-control" id="geplanteZeit">
												</div>
											</div>
											<div class="col-6">
												<div class="form-group form-check">
													<label class="form-check-label"> <input
														class="form-check-input" type="checkbox">
														wiederholend
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
						<div class="card">
							<div class="card-header">
								<a class="collapsed card-link" data-toggle="collapse"
									href="#collapseTwo">Aufgabe 2</a>
							</div>
							<div id="collapseTwo" class="collapse" data-parent="#accordion">
								<div class="card-body"></div>
							</div>
						</div>
						<div class="card">
							<div class="card-header">
								<a class="collapsed card-link" data-toggle="collapse"
									href="#collapseThree">Aufgabe 3</a>
							</div>
							<div id="collapseThree" class="collapse" data-parent="#accordion">
								<div class="card-body"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>