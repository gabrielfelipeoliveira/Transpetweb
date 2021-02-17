<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar endereço</title>
</head>
<body>
	<%@ include file="cabecalho-tutor.jsp"%>


	<c:if test="${tutores!=null }">
		<div class="formCadastro">
			<h3>Selecione o tutor</h3>
			<form action="<%=request.getContextPath()%>/atualizar-endereco-tutor"
				method="post">
				<select name="idTutor">
					<c:forEach var="tutor" items="${tutores}">
						<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
							${tutor.sobreNomeUsuario}</option>
					</c:forEach>
				</select><br> <input type="submit" value="selecionar">
			</form>
		</div>
	</c:if>
	<c:if test="${enderecos !=null}">
		<div class="formCadastro">
			<h3>Selecione o endereço para atualizar</h3>
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
							<td><a class="atualizarBotao"
								href="<%=request.getContextPath()%>/atualizar-endereco-tabela?idEnderecoTabela=<c:out value='${endereco.idEndereco}'/>">Selecionar</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</c:if>

	<c:if test="${endereco!= null }">
		<div class="formCadastro" >
		<h3>Atualize o endereço</h3>

		<form
			action="<%=request.getContextPath()%>/atualizar-endereco-tutor-dados"
			method="post">

			<input type="hidden" id="idEnderecoDados" name="idEnderecoDados"
				value="${endereco.idEndereco}">

			<fieldset>
				<label>Rua</label><br> <input type="text"
					id="ruaEnderecoTutor" name="ruaEnderecoTutor"
					value="${endereco.ruaEndereco}" maxlength="25" required><br>



				<label>CEP</label><br> <input type="text" id="cepEnderecoTutor"
					name="cepEnderecoTutor" value="${endereco.cepEndereco}"
					maxlength="5" required><br> <label>Numero</label><br>
				<input type="text" id="numeroEnderecoTutor"
					name="numeroEnderecoTutor" value="${endereco.numeroEndereco}"
					maxlength="25" required><br>



			</fieldset>

			<input type="submit" value="Atualizar endereco"
				id="botaoAtuaEnderecoTutor">

		</form>
		</div>
	</c:if>

</body>
</html>