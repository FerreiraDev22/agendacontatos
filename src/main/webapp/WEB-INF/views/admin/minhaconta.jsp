<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Minha Conta</title>

<!-- CSS (folhas de estilos) -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
<style>
	label.error { color: #df4759 }
	input.error { border: 2px solid #df4759 }
</style>

</head>
<body>

	<jsp:include page="/WEB-INF/views/components/navbar.jsp"></jsp:include>

	<div class="container mt-4">
	
		<div class="card">
			<div class="card-body">
				<h4>Dados da conta do usuário:</h4>
				<hr/>				
				<div class="mb-2">
					Nome do usuário: <strong>${auth_usuario.nome}</strong>
				</div>
				<div class="mb-2">
					Email de acesso: <strong>${auth_usuario.email}</strong>
				</div>
											
			</div>
		</div>
		
		<br/>
		
		<div class="card">
			<div class="card-body">
				<h4>Alterar Senha de acesso:</h4>
				<hr/>	
				
				<form id="form_alterarsenha" action="atualizar_senha" method="post">
				
					<div class="row mb-2">
						<div class="col-md-4">
							<label>Informe a nova senha:</label>
							<input type="password" name="novaSenha" id="novaSenha" class="form-control"/>
						</div>
						<div class="col-md-4">
							<label>Confirme a nova senha:</label>
							<input type="password" name="novaSenhaConfirmacao" id="novaSenhaConfirmacao" class="form-control"/>
						</div>
					</div>
					
					<div class="row mb-2">
						<div class="col-md-12">
							<input type="submit" class="btn btn-success" value="Salvar nova senha"/>
						</div>
					</div>
				
				</form>
				
				<div class="mb-2">
					<strong>${mensagem}</strong>
				</div>
				
			</div>
		</div>
		
	</div>

	<!-- JavaScript -->
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
			$("#form_alterarsenha").validate({
				rules: {
					"novaSenha" : { required : true, minlength: 8, maxlength: 20 },
					"novaSenhaConfirmacao" : { required : true, equalTo : "#novaSenha" }
				}
			});
			
		});
	
	</script>

</body>
</html>