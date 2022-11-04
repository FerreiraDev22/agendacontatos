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
			<div class="card mt-3">
				<div class="card-body">
					
					<div class="text-center">
						<h1>Agenda de Contatos</h1>
						<h4>Criação de conta de usuário.</h4>
						<p>Preencha o formulário para realizar o seu cadastro.</p>
					</div>
					
					<hr/>
					
					<form id="form_cadastro" method="post" action="cadastrar-usuario">
					
						<div class="mb-3">
							<label>Nome do usuário:</label>
							<input type="text" name="nome" id="nome" class="form-control" placeholder="Digite aqui"/>
						</div>
						
						<div class="mb-3">
							<label>Email de acesso:</label>
							<input type="text" name="email" id="email" class="form-control" placeholder="Digite aqui"/>
						</div>
						
						<div class="mb-3">
							<label>Senha de acesso:</label>
							<input type="password" name="senha" id="senha" class="form-control" placeholder="Digite aqui"/>
						</div>
						
						<div class="mb-3">
							<label>Confirme sua senha:</label>
							<input type="password" name="senhaConfirmacao" id="senhaConfirmacao" class="form-control" placeholder="Digite aqui"/>
						</div>
						
						<div class="mb-3">
							<div class="d-grid">
								<input type="submit" class="btn btn-primary" value="Realizar Cadastro"/>
							</div>
						</div>
						
						<div class="mb-3">
							<div class="d-grid">
								<a href="/projetoweb01/" class="btn btn-light">
									Já possui conta? <strong>Acesse aqui!</strong>
								</a>
							</div>
						</div>
					
					</form>
					
					<div class="text-center">
						<strong>${mensagem}</strong>
					</div>
					
				</div>
			</div>
		</div>
	</div>

	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
		
	<!-- JavaScript JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	
	<!-- JavaScript JQuery Validation -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/localization/messages_pt_BR.min.js"></script>

	<script>
	
		$(document).ready(function(){
			
			//validação no formulário
			$("#form_cadastro").validate({
				rules: {
					"nome" : { required : true, minlength: 6, maxlength: 150 },
					"email" : { required : true, email : true },
					"senha" : { required : true, minlength: 8, maxlength: 20 },
					"senhaConfirmacao" : { required : true, equalTo : "#senha" }
				}
			});
			
		});
	
	</script>

</body>
</html>












