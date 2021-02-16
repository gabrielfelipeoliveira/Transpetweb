<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="ISO-8859-1">
<title>Listar Corridas Tutor</title>
</head>
<body>

	<%@ include file="cabecalho-tutor.jsp"%>




	<c:if test="${tutores != null}">
		<div class="formCadastro">
			<form action="<%=request.getContextPath()%>/listar-corrida-tutor"
				method="post">
				<h3>Selecione o tutor</h3>
				<br> <select name="idTutor">
					<c:forEach var="tutor" items="${tutores}">
						<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
							${tutor.sobreNomeUsuario}</option>
					</c:forEach>

				</select><br> <input type="submit" value="Selecionar Tutor"
					id="selecionarTutor">
			</form>
		</div>
	</c:if>

	<c:if test="${corridasAbertas!=null }">
		<div class="formCadastro">
			<h3>Histórico de Corrida</h3>
			<table>

				<tr>
					<th>Endereço Inicial</th>
					<th>Endereço Final</th>
					<th>Pet</th>
					<th>Nome Motorista</th>
				</tr>

				<tbody>
					<c:forEach var="corrida" items="${corridasFeitas}">
						<tr>
							<td><c:out value="${corrida.enderecoInicial.ruaEndereco}" />
							</td>
							<td><c:out value="${corrida.enderecoFinal.ruaEndereco}" /></td>
							<td><c:out value="${corrida.animal.nomeAnimal}" /></td>
							<td><c:out value="${corrida.motorista.nomeUsuario}" /></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

			<h3>Corridas em Aberto</h3>

			<table>

				<tr>
					<th>Endereço Inicial</th>
					<th>Endereço Final</th>
					<th>Pet</th>
				</tr>

				<tbody>
					<c:forEach var="corrida" items="${corridasAbertas}">
						<tr>
							<td><c:out value="${corrida.enderecoInicial.ruaEndereco}" /></td>
							<td><c:out value="${corrida.enderecoFinal.ruaEndereco}" /></td>
							<td><c:out value="${corrida.animal.nomeAnimal}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>

</body>
</html>