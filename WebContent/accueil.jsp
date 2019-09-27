<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="utf-8" />
<title>Bibliotheque</title>
<header>
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<h1 class="my-0 mr-md-auto font-weight-normal">Accueil</h1>
		<h2 class="my-0 mr-md-auto font-weight-normal">Bonjour ${login}</h2>
		<c:if test='${empty login}'>
		<nav>
			<a class="btn btn-outline-primary" data-toggle="modal"
				data-target="#exampleModal">Connexion Client</a>
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="padding: 20px">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Connexion</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form Action="LoginClient">
							<div class="form-group">
								<label for="login">Nom d'utilisateur</label> <input type="text"
									class="form-control" placeholder="Nom d'utilisateur" name="login">
							</div>
							<div class="form-group">
								<label for="Password">Mot de passe</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Mot de passe" name="password">
							</div>
							<button class="btn btn-primary">Connexion</button>
						</form>
					</div>
				</div>
			</div>
			<a class="btn btn-outline-primary" data-toggle="modal"
				data-target="#exampleModal2">Connexion Admin</a>
			<div class="modal fade" id="exampleModal2" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="padding: 20px">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Connexion
								Admin</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form Action="LoginAdmin">
							<div class="form-group">
								<label for="login">Nom d'utilisateur</label> <input type="text"
									class="form-control" placeholder="Nom d'utilisateur"
									name="login">
							</div>
							<div class="form-group">
								<label for="Password">Mot de passe</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Mot de passe" name="password">
							</div>
							<button type="submit" class="btn btn-primary">Connexion</button>
						</form>
					</div>
				</div>
			</div>
		</nav>
		</c:if>
	</div>

</header>
<body>
	<h2>Livres :</h2>
	<table class="table">
		<c:forEach items="${livres}" var="li">

			<tr>
				<td>${li.id}</td>
				<td>${li.titre}</td>
				<td>${li.auteur}</td>
				<td>${li.edition}</td>
				<c:if test="${role == 'client'}">
				<td><button type="button" class="btn btn-primary">Reserver</button></td>
				</c:if>
				<c:if test="${role == 'admin'}">
				<td><a type="button" class="btn btn-danger" href="http://localhost:8080/TpBiblio/RemoveLivre?id=${li.id}">Supprimer</button></a>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
<footer>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</footer>
</html>