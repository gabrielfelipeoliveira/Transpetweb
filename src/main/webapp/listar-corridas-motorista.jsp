<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historico Corridas</title>
</head>
<body>

	<%@ include file="cabecalho-motorista.jsp"%>


	<c:if test="${motoristas!=null }">
	<div class="formCadastro">
		<h3>Selecione o motorista</h3>
		
			<form
				action="<%=request.getContextPath()%>/listar-corridas-motoristas">
				<br> <select name="idMotorista">

					<c:forEach var="motorista" items="${motoristas}">
						<option value="${motorista.idUsuario}">
							${motorista.nomeUsuario} ${motorista.sobreNomeUsuario}</option>
					</c:forEach>
				</select><br> <input type="submit" value="selecionar">
			</form>
			</div>
	</c:if>
	<br>

	<c:if test="${corridas!=null }">
		<div class="formCadastro" >
		<h3>Histórico de Corrida Motorista</h3>
		<table>

			<tr>
				<th>Tutor</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Endereço Inicial</th>
				<th>Endereço Final</th>
				<th>Pet</th>
			<tr>
			<tbody>
				<c:forEach var="corrida" items="${corridas}">
					<tr>
						<td><c:out value="${corrida.tutor.nomeUsuario}" /></td>
						<td><c:out value="${corrida.tutor.telefoneUsuario}" /></td>
						<td><c:out value="${corrida.tutor.emailUsuario}" /></td>
						<td><c:out value="${corrida.enderecoInicial.ruaEndereco}" /></td>
						<td><c:out value="${corrida.enderecoFinal.ruaEndereco}" /></td>
						<td><c:out value="${corrida.animal.raca}" /></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
</tr>
	</c:if>


</body>
</html>