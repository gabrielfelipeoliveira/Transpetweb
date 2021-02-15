<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deletar Endereço</title>
</head>
<body>
	
	<%@ include file="cabecalho-tutor.jsp"%>

<h1>Escolha algum dos Tutores cadastrados!</h1>

	<c:if test="${tutores!=null }">
	<form action="<%=request.getContextPath()%>/deletar-endereco-tutor"
		method="post">
		<label>Tutor</label> <select name="idTutor">
			<c:forEach var="tutor" items="${tutores}">
				<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
					${tutor.sobreNomeUsuario}</option>
			</c:forEach>
		</select><br> <input type="submit" value="selecionar">
	</form>
	</c:if>
	
	<c:if test="${enderecos!=null }">
	<form action="<%=request.getContextPath()%>/deletar-endereco-tutor-del" >
		<h3>Selecione um endereço para Deletar</h3>
		<table>

			<tr>
				<th>Rua</th>
				<th>CEP</th>
				<th>Numero</th>
				<th>Deletar</th>
			</tr>
			
			<tbody>
					<c:forEach var="endereco" items="${enderecos}">
						<tr>
							<td><c:out value="${endereco.ruaEndereco}" /></td>
							<td><c:out value="${endereco.cepEndereco}" /></td>
							<td><c:out value="${endereco.numeroEndereco}" /></td>
							<td><a
							href="<%=request.getContextPath()%>/deletar-endereco-tutor-del?idEnderecoTutorDel=<c:out value='${endereco.idEndereco}'/>">Selecionar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</form>
</c:if>
</body>
</html>