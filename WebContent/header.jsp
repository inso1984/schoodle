<header>
	<div class="container-fluid p-0">
		<nav class="navbar navbar-expand-sm bg-dark justify-content-between">
			<h1 class="schoodle">Schoodle</h1>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Aufgaben</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Stundenplan</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Noten</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Fächer</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Lehrer</a></li>
			</ul>
			<%
					if(!auth.checkAuth()){
				%>
			<button type="button"
				class="btn btn-primary m-5 pl-4 pr-4 loginModal" data-toggle="modal"
				data-target="#loginModal">Login</button>
				<%}%>
		</nav>
	</div>
</header>

<!-- Login Modal -->
<div class="modal" id="loginModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">Login</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<form action="/Schoodle/login.jsp">
				<!-- Modal body -->
				<div class="modal-body">

					<div class="form-group">
						<label for="email">E-Mail:</label> <input type="email"
							class="form-control" name="email">
					</div>
					<div class="form-group">
						<label for="pw">Passwort:</label> <input type="password"
							class="form-control" name="pw">
					</div>
					<div class="form-group form-check">
						<label class="form-check-label"> <input
							class="form-check-input" type="checkbox"> Passwort
							vergessen
						</label>
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
								<button type="submit" class="btn btn-primary">einloggen</button>
							</div>
						</div>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>