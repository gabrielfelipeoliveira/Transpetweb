<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Procurar Uma Corrida</title>
</head>
<body>
	
	<%@ include file="cabecalho-motorista.jsp" %>
	<h1>Procurar Corrida</h1><br>
	
	<c:if test="${motoristas !=null }">
	<h3>Selecione o motorista</h3>
	<form id="formProcurarCorrida" action="<%=request.getContextPath()%>/procurar-corrida-motorista">
		<label >Motorista</label> <br> 
		<select	name="idMotorista">

				<c:forEach var="motorista" items="${motoristas}">
				<option value="${motorista.idUsuario}">
					${motorista.nomeUsuario} ${motorista.sobreNomeUsuario}</option>
			</c:forEach>
			
		</select><br>
		<input type="submit" value="selecionar">
	</form>
	</c:if>
	
	<c:if test="${motorista !=null }">
	<br>
	 <h3>Selecione a corrida</h3>
		<table>

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
						<td><a href="<%=request.getContextPath()%>/procurar-corrida-motorista-aceitar?idMotoristaTabela=<c:out value='${motorista.idUsuario}'/>&idCorrida=<c:out value='${corrida.idCorrida}'/>"> Aceitar Corrida</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>