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



	<c:if test="${corridas!=null }">
		<div class="formCadastro" >
		<h3>Hist�rico de Corrida</h3>
		<table>

			<tr>
				<th>Tutor</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Endere�o Inicial</th>
				<th>Endere�o Final</th>
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

	</c:if>


</body>
</html>