<body>
	<div class="container-fluid p-0">
		<div class="container pt-5 ">
			<div class="shadow p-4 bg-white text-center">
				<div class="row ">
					<div class="col-12">
						<h1 class="p-2">Willkommen bei Schoodle</h1>
						<h2 class="p-2">Dein digitales Hausaufgabenheft</h2>
					</div>
				</div>
				<div class="row text-center">
					<div class="col-2"></div>
					<div class="col-8">
						<p class="p-2">Hier hast du die Möglichkeit deine Hausaufgaben
							oder Lernaufträge zu managen, deinen Stundenplan zu hinterlegen
							oder deine Noten zu speichern und damit deinen Notenschnitt
							einzusehen.</p>
					</div>
					<div class="col-2"></div>
				</div>
				<%
					if(!auth.checkAuth()){
				%>
				<div class="row text-center">
					<div class="col-12">
						<button type="button" class="btn btn-primary m-5 pl-4 pr-4"
							data-toggle="modal" data-target="#registrierenModal">Hier
							kannst du dich kostenfrei registrieren</button>
					</div>
				</div>
				<%} %>
			</div>
		</div>
</body>

<!-- Registrieren Modal -->

<div class="modal" id="registrierenModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Registrieren</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form method="post" action="/Schoodle/register.jsp">
				<!-- Modal body -->
				<div class="modal-body">
					<div class="form-group">
						<label for="name">Dein Name:</label> <input type="text"
							class="form-control" name="name">
					</div>
					<div class="form-group">
						<label for="email">E-Mail:</label> <input type="email"
							class="form-control" name="email">
					</div>
					<div class="form-group">
						<label for="pw">Passwort:</label> <input type="password" name="pw"
							class="form-control" id="pw">
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="sex" value="f">
							Mädchen
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"><input
							class="form-check-input" type="radio" name="sex" value="m">
							Junge </label>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<div class="container">
						<div class="d-flex justify-content-between">
							<div class="">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">abbrechen</button>
							</div>
							<div class="">
								<button type="submit" class="btn btn-primary">Jetzt
									registrieren</button>
							</div>
						</div>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>