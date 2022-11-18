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
	
<style>
	label.error { color: #df4759 }
	input.error { border: 2px solid #df4759 }
</style>

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
					
					<form id="form_login" method="post" action="autenticar_usuario">
						
						<div class="mb-3">
							<label>Email de acesso:</label>
							<input type="text" name="email" id="email" class="form-control" placeholder="Digite aqui"/>
						</div>
						
						<div class="mb-3">
							<label>Senha de acesso:</label>
							<input type="password" name="senha" id="senha" class="form-control" placeholder="Digite aqui"/>
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
					
					<div class="text-center">
						<strong>${mensagem}</strong>
					</div>
					
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

	<!-- JavaScript JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	
	<!-- JavaScript JQuery Validation -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/localization/messages_pt_BR.min.js"></script>

	<script>
	
		$(document).ready(function(){
			
			//validação no formulário
			$("#form_login").validate({
				rules: {
					"email" : { required : true, email : true },
					"senha" : { required : true, minlength: 8, maxlength: 20 }
				}
			});			
		});
	
	</script>

</body>
</html>