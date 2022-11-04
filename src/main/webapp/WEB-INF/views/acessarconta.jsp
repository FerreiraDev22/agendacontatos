<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body class="bg-secondary">

	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card mt-5">
				<div class="card-body">
					
					<div class="text-center">
						<h1>Agenda de Contatos</h1>
						<h4>Seja bem vindo!</h4>
						<p>Entre com suas credenciais de acesso.</p>
					</div>
					
					<hr/>
					
					<form>
						
						<div class="mb-3">
							<label>Email de acesso:</label>
							<input type="text" name="email" class="form-control" placeholder="Digite aqui"/>
						</div>
						
						<div class="mb-3">
							<label>Senha de acesso:</label>
							<input type="password" name="senha" class="form-control" placeholder="Digite aqui"/>
							<div class="text-end">
								<a href="/projetoweb01/recuperarsenha">
									Esqueci minha senha?
								</a>
							</div>
						</div>
						
						<div class="mb-3">
							<div class="d-grid">
								<input type="submit" class="btn btn-primary" value="Acessar Conta"/>
							</div>
						</div>
						
						<div class="mb-3">
							<div class="d-grid">
								<a href="/projetoweb01/criarconta" class="btn btn-light">
									Não possui conta? <strong>Cadastre-se aqui!</strong>
								</a>
							</div>
						</div>
					
					</form>
					
					<div class="text-center mb-2">
						<small>Java WebDeveloper - COTI Informática 2022</small>
					</div>
					
				</div>
			</div>
		</div>
	</div>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>