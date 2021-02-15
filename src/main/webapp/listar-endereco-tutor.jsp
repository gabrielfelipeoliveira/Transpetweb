<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de endereços</title>
</head>
<body>


	<%@ include file="cabecalho-tutor.jsp"%>

	<c:if test="${tutores != null}">
		<h1>Endereços</h1>

		<form action="<%=request.getContextPath()%>/listar-endereco-tutor"
			method="post">
			<label>Selecione o tutor</label> <br> <select name="idTutor">
				<c:forEach var="tutor" items="${tutores}">
					<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
						${tutor.sobreNomeUsuario}</option>
				</c:forEach>

			</select><br> <input type="submit" value="Selecionar Tutor"
				id="selecionarTutor">
		</form>
	</c:if>

	<c:if test="${enderecos!=null }">
		<div>
			<h3>Lista</h3>
			<table>

				<tr>
					<th>Rua</th>
					<th>CEP</th>
					<th>Numero</th>
				</tr>

				<tbody>
					<c:forEach var="endereco" items="${enderecos}">
						<tr>
							<td><c:out value="${endereco.ruaEndereco}" /></td>
							<td><c:out value="${endereco.cepEndereco}" /></td>
							<td><c:out value="${endereco.numeroEndereco}" /></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</c:if>



</body>
</html>