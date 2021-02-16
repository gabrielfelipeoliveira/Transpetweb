<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de veiculos</title>
</head>
<body>

	<%@ include file="cabecalho-motorista.jsp"%>

	<c:if test="${motoristas != null}">
		<h3>Selecione o motorista</h3>

		<form action="<%=request.getContextPath()%>/listar-veiculo-motorista"
			method="get">
			<label>Selecione o tutor</label> <br> <select name="idMotoristaLis">
				<c:forEach var="motorista" items="${motoristas}">
					<option value="${motorista.idUsuario}">${motorista.nomeUsuario}
						${motorista.sobreNomeUsuario}</option>
				</c:forEach>

			</select><br> <input type="submit" value="Selecionar Tutor"
				id="selecionarTutor">
		</form>
	</c:if>

	<c:if test="${veiculos!=null }">
		<div>
			<h3>Lista de veiculos</h3>
			<table>

				<tr>
					<th>Marca</th>
					<th>Modelo</th>
					<th>Placa</th>
					<th>Ano</th>
				</tr>

				<tbody>
					<c:forEach var="veiculo" items="${veiculos}">
						<tr>
							<td><c:out value="${veiculo.marcaVeiculo}" /></td>
							<td><c:out value="${veiculo.modeloVeiculo}" /></td>
							<td><c:out value="${veiculo.placaVeiculo}" /></td>
							<td><c:out value="${veiculo.anoVeiculo}" /></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</c:if>
</body>
</html>