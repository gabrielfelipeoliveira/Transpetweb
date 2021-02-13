<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Procurar Corrida Motorista</title>
</head>
<body>
	
	<h1>Selecione a corrida</h1>
	<form id="formProcurarCorrida" action="<%=request.getContextPath()%>">
		<label for="idMotorista">Motorista</label> <br> 
		<select	name="idMotorista">

				<c:forEach var="motorista" items="${motoristas}">
				<option id="idMotorista" value="${motorista.idUsuario}">
					${motorista.nomeUsuario} ${motorista.sobreNomeUsuario}</option>
			</c:forEach>
		</select>
	
	<br>
		<table id="tabelaProcurarCorrida">

			<tr>
				<td>Nome Solicitante</td>
				<td>Endereço Inicial</td>
				<td>Endereço Final</td>
				<td>Pet</td>
			</tr>

			<tbody>
				<c:forEach var="corrida" items="${corridas}">
					<tr>
						<td><c:out value="${corrida.motorista.nomeUsuario}" /></td>
						<td><c:out value="${corrida.enderecoInicial}" /></td>
						<td><c:out value="${corrida.enderecoFinal}" /></td>
						<td><c:out value="${corrida.animal}" /></td>
						<td><a href="procurarCorrida?id=<c:out value='${contato.id}'/>"> Aceitar Corrida</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	</c:if>
</body>
</html>