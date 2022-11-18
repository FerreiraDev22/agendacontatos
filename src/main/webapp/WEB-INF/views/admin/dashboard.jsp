<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>

<!-- CSS (folhas de estilos) -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>

	<jsp:include page="/WEB-INF/views/components/navbar.jsp"></jsp:include>

	<div class="container mt-4">
		
		<div class="card">
			<div class="card-body">
			
				<h4>Seja bem vindo a Agenda de Contatos!</h4>
				<p>Dashboard principal.</p>
				<hr/>		
								
				<div class="row">
					<div class="col-md-4">
						<table class="table table-sm">
							<thead>
								<tr>
									<th>Tipo do Contato</th>
									<th>Quantidade</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dados}" var="item">
									<tr>
										<td>${item.tipo}</td>
										<td>${item.quantidade}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="col-md-8">
						<div id="grafico"></div>
					</div>
				</div>
			
			</div>
		</div>
		
	</div>

	<!-- JavaScript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
		
	<!-- JavaScript JQuery -->
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	
	<!-- Biblioteca do Highcharts -->
	<script src="https://code.highcharts.com/highcharts.js"></script>

	<script>
		var dados = [];
		
		<c:forEach items="${dados}" var="item">
			dados.push(['${item.tipo}', ${item.quantidade}]);
		</c:forEach>
				
		new Highcharts.Chart({
			chart: {
				type : 'pie',
				renderTo: 'grafico'
			},
			plotOptions: {
				pie: {
					innerSize: '60%'
				}
			},
			title: {
				text: 'Quantidade de contatos por tipo.'
			},
			credits: {
				enabled: false
			},
			series: [{
				data: dados
			}]
		});
		
	</script>

</body>
</html>












