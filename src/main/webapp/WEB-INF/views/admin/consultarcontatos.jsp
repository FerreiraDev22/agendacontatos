<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!-- Importando as bibliotecas do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Contatos</title>

<!-- CSS (folhas de estilos) -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
	
<link 
	href="//cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css"
	rel="stylesheet" />

</head>
<body>

	<jsp:include page="/WEB-INF/views/components/navbar.jsp"></jsp:include>

	<div class="container mt-4">
		<div class="card">
			<div class="card-body">
				
				<h4>Consulta de Contatos</h4>
				<p>Listagem de contatos cadastrados em sua agenda.</p>
				<hr/>	
				
				<div class="mb-2">
					<strong>${mensagem}</strong>
				</div>				
								
				<table id="tabela-contatos" class="table table-sm">
					<thead>
						<tr>
							<th>Nome do Contato</th>
							<th>Email</th>
							<th>Telefone</th>
							<th>Data de Nascimento</th>
							<th>Tipo</th>
							<th>Operações</th>
						</tr>
					</thead>
					<tbody>
					
						<c:forEach items="${contatos}" var="contato">
							
							<tr>
								<td>${contato.nome}</td>
								<td>${contato.email}</td>
								<td>${contato.telefone}</td>
								<td><fmt:formatDate value="${contato.dataNascimento}" pattern="dd/MM/yyyy"/> </td>
								<td>${contato.tipo}</td>
								<td>
									<a href="/projetoweb01/admin/atualizarcontatos?id=${contato.idContato}" 
										class="btn btn-sm btn-primary">
										Editar
									</a>
									
									<a href="/projetoweb01/admin/excluircontatos?id=${contato.idContato}" 
										class="btn btn-sm btn-danger"
										onclick="return confirm('Deseja realmente excluir o contato ${contato.nome}?')">
										Excluir
									</a>
								</td>
							</tr>
							
						</c:forEach>	
						
					</tbody>
				</table>
				
			</div>
		</div>
	</div>

	<!-- JavaScript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
		
	<!-- JavaScript JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	
	<!-- JavaScript DataTables -->
	<script src="//cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	
	<script>
		$(document).ready( function () {
	    	$('#tabela-contatos').DataTable({
	    		language: {
	    			url : '//cdn.datatables.net/plug-ins/1.13.1/i18n/pt-BR.json'
	    		}
	    	});
		});
	</script>

</body>
</html>




