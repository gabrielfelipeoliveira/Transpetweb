<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="cabecalho-tutor.jsp"%>
	<h1>Insira os dados para Atualizar seu Pet!</h1>

	<c:if test="${tutores!=null }">
	<form action="<%=request.getContextPath()%>/atualizar-endereco-tutor"
		method="post">
		<label>Tutor</label> <select name="idTutor">
			<c:forEach var="tutor" items="${tutores}">
				<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
					${tutor.sobreNomeUsuario}</option>
			</c:forEach>
		</select><br> <input type="submit" value="selecionar">
	</form>
	</c:if>
	<c:if test="${enderecos !=null}">
		<table>

			<tr>
				<th>Rua</th>
				<th>Cep</th>
				<th>Numero</th>
				<th>Selecionar</th>
			</tr>

			<tbody>
				<c:forEach var="endereco" items="${enderecos}">
					<tr>
						<td><c:out value="${endereco.ruaEndereco}" /></td>
						<td><c:out value="${endereco.cepEndereco}" /></td>
						<td><c:out value="${endereco.numeroEndereco}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/atualizar-endereco-tabela?idEnderecoTabela=<c:out value='${endereco.idEndereco}'/>">Selecionar</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
</c:if>

<c:if test="${endereco!= null }">
		<h3>Endereço</h3>
	
		<form
			action="<%=request.getContextPath()%>/atualizar-endereco-tutor-dados"
			method="post">

			<input type = "text" id = "idEnderecoDados" name="idEnderecoDados" value="${endereco.idEndereco}" hidden>
			
			<fieldset>
				<label >Rua</label><br> <input
					type="text" id="ruaEnderecoTutor" name="ruaEnderecoTutor"
					value="${endereco.ruaEndereco}" maxlength="25" required><br>
			

			
				<label>CEP</label><br> <input
					type="text" id="cepEnderecoTutor" name="cepEnderecoTutor"
					value="${endereco.cepEndereco}" maxlength="5" required><br> 
			
				<label >Numero</label><br> <input
					type="text" id="numeroEnderecoTutor" name="numeroEnderecoTutor"
					value="${endereco.numeroEndereco}" maxlength="25" required><br>
			

			
			</fieldset>

			<input type="submit" value="Atualizar endereco" id="botaoAtuaEnderecoTutor">

		</form>
	</c:if>

</body>
</html>