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
	
	<%@ include file="cabecalho-motorista.jsp" %>
	
	<h1>Selecione a corrida</h1>
	<form id="formProcurarCorrida" action="<%=request.getContextPath()%>/procurar-corrida-motorista">
		<label >Motorista</label> <br> 
		<select	name="idMotorista">

				<c:forEach var="motorista" items="${motoristas}">
				<option value="${motorista.idUsuario}">
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
						<td><c:out value="${corrida.tutor.nomeUsuario}" /></td>
						<td><c:out value="${corrida.enderecoInicial.ruaEndereco}" /></td>
						<td><c:out value="${corrida.enderecoFinal.ruaEndereco}" /></td>
						<td><c:out value="${corrida.animal.nomeAnimal}" /></td>
						<td><a href="procurarCorrida?idMotorista=<c:out value='${motorista.idUsuario}'/>&idCorrida=<c:out value='${corrida.idCorrida}'/>"> Aceitar Corrida</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>