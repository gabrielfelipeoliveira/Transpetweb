<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Corrida Tutor</title>
</head>
<body>

	<%@ include file="cabecalho-tutor.jsp"%>

	<h1>Selecione a corrida para atualizar</h1>


	<form action="<%=request.getContextPath()%>/atualizar-corrida-tutor">
		<label for="idTutor">Tutor</label> <select name="idTutor">
			<c:forEach var="tutor" items="${tutores}">
				<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
					${tutor.sobreNomeUsuario}</option>
			</c:forEach>
		</select> <br> <input type="submit" value="Selecionar Tutor"
			id="selecionarTutor">
	</form>

	<form action="<%=request.getContextPath()%>/atualizar-corrida-tutor-tabela">
	
			<input type ="text" name="idTutorAtu" hidden value="${tutor.idUsuario}">
	
		<table>
	
			<tr>
				<th>Endere�o Inicial</th>
				<th>Endere�o Final</th>
				<th>Pet</th>
			</tr>
			<tbody>
				<c:forEach var="corrida" items="${corridas}">
					<tr>
						<td><c:out value="${corrida.enderecoInicial.ruaEndereco}" /></td>
						<td><c:out value="${corrida.enderecoFinal.ruaEndereco}" /></td>
						<td><c:out value="${corrida.animal.nomeAnimal}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/atualizar-corrida-tutor-tabela?idCorridaTabela=<c:out value='${corrida.idCorrida}'/>&idTutorTabela=<c:out value='${tutor.idUsuario }'/>">Selecionar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>

	<form action="<%=request.getContextPath()%>/atualizar-corrida-tutor-dados">

			<input type ="text" name="idCorridaAtu" hidden value="${corrida.idCorrida }">
		<fieldset>
			<label>Endere�o Inicial</label><br> <select
				name="idEnderecoInicialAtu">
				<c:forEach var="endereco" items="${enderecos}">
					<c:if test="${endereco.idEndereco !=enderecoInicial.idEndereco}">
						<option value="${endereco.idEndereco}">${endereco.ruaEndereco}<
							${endereco.numeroEndereco}</option>
					</c:if>
					<c:if test="${endereco.idEndereco ==enderecoInicial.idEndereco}">
						<option value="${endereco.idEndereco}" selected>${endereco.ruaEndereco}<
							${endereco.numeroEndereco}</option>
					</c:if>
				</c:forEach>
			</select><br> <label>Endere�o Final</label><br> <select
				name="idEnderecoFinalAtu">
				<c:forEach var="endereco" items="${enderecos}">
					<c:if test="${endereco.idEndereco !=enderecoFinal.idEndereco}">
						<option value="${endereco.idEndereco}">${endereco.ruaEndereco}<
							${endereco.numeroEndereco}</option>
					</c:if>
					<c:if test="${endereco.idEndereco ==enderecoFinal.idEndereco}">
						<option value="${endereco.idEndereco}" selected>${endereco.ruaEndereco}<
							${endereco.numeroEndereco}</option>
					</c:if>
				</c:forEach>
			</select><br> <label>Escolha seu pet</label><br> <select
				name="idAnimalAtu">

				<c:forEach var="animal" items="${animais}">
					<c:if test="${animal.idAnimal != animalRetorno.idAnimal }">
						<option value="${animal.idAnimal}">${animal.nomeAnimal}
							${animal.raca}</option>
					</c:if>
					<c:if test="${animal.idAnimal == animalRetorno.idAnimal }">
						<option value="${animal.idAnimal}" selected >${animal.nomeAnimal}
							${animal.raca}</option>
					</c:if>
				</c:forEach>

			</select><br> <br>
		</fieldset>
		<input type="submit" value="Atualizar Corrida"
			id="atualizarCorrida">
	</form>

</body>
</html>