<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Contatos</title>

<!-- CSS (folhas de estilos) -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
<style>
	label.error { color: #df4759 }
	input.error { border: 2px solid #df4759 }
	select.error { border: 2px solid #df4759 }
</style>

</head>
<body>

	<jsp:include page="/WEB-INF/views/components/navbar.jsp"></jsp:include>

	<div class="container mt-4">
		<div class="card">
			<div class="card-body">
			
				<h4>Cadastro de Contatos</h4>
				<p>Preencha os campos para incluir um contato em sua agenda.</p>
				<hr/>		
				
				<form id="form_cadastro" action="cadastrar-contato" method="post">
					
					<div class="row mb-2">
						<div class="col-md-6">
							<label>Nome do contato:</label>
							<input type="text" name="nome" id="nome" class="form-control"/>
						</div>
						<div class="col-md-3">
							<label>Email:</label>
							<input type="text" name="email" id="email" class="form-control"/>
						</div>
						<div class="col-md-3">
							<label>Telefone:</label>
							<input type="text" name="telefone" id="telefone" class="form-control"/>
						</div>
					</div>
					
					<div class="row mb-2">
						<div class="col-md-3">
							<label>Data de nascimento:</label>
							<input type="text" name="datanascimento" id="datanascimento" class="form-control"/>
						</div>
						<div class="col-md-3">
							<label>Tipo do contato:</label>
							<select name="tipo" id="tipo" class="form-select">
								<option value="">Escolha uma opção</option>
								<option value="1">Família</option>
								<option value="2">Amigos</option>
								<option value="3">Trabalho</option>
								<option value="4">Outros</option>
							</select>
						</div>
					</div>
					
					<div class="row mb-2">
						<div class="col-md-12">
							<input type="submit" class="btn btn-success" value="Realizar Cadastro"/>
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
	
	<!-- JavaScript JQuery Masked Input -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>

	<script>
	
		$(document).ready(function(){
			
			//validação no formulário
			$("#form_cadastro").validate({
				rules: {
					"nome" : { required : true, minlength: 6, maxlength: 150 },
					"email" : { required : true, email : true },
					"telefone" : { required : true },
					"datanascimento" : { required : true },
					"tipo" : { required : true },
				}
			});	
			
			//máscara de campos
			$("#telefone").mask("(99) 99999-9999");
			$("#datanascimento").mask("99/99/9999");
		});
	
	</script>

</body>
</html>