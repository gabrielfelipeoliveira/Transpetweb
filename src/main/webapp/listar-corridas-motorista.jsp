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

<%@ include file="cabecalho-motorista.jsp" %>

<h1>Histórico de Corrida Motorista</h1>
	<form action="<%=request.getContextPath()%>/listar-corridas-motoristas">
		<label >Motorista</label><br>
		<select name="idMotorista">
		
    <c:forEach var="motorista" items="${motoristas}">
        <option value="${motorista.idUsuario}">
            ${motorista.nomeUsuario}
            ${motorista.sobreNomeUsuario}
        </option>
     </c:forEach>
		</select>
	</form>
	<br>
	
	
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
							<td><c:out value="${corrida.animal.nomeAnimal}" /></td>
						</tr>
					</c:forEach>
				</tbody>
	
		</table>

	

</body>
</html>