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

<h1>Histórico de Corrida Motorista</h1>
	<form action="">
		<label for="selectCorridaMotorista">Motorista</label><br>
		<select name="idMotorista">
		
		<option value="motorista">..</option>
    <c:forEach var="motorista" items="${motoristas}">
        <option value="${motorista.codigoMotorista}">
            ${motorista.Nome}
            ${motorista.Sobrenome}
        </option>
     </c:forEach>
		</select>
	</form>
	<br>
	
	<form action="">
		<table id="TabelaListarCorridaMotorista" hidden\>
	
			<td>Tutor</td>
			<td>Endereço Inicial</td>
			<td>Endereço Final</td>
			<td>Pet</td>
			
			<tbody>
					<c:forEach var="CorridaMotoristaList" items="${corridas}">
						<tr>
							<td><c:out value="${corrida.Tutor}" /></td>
							<td><c:out value="${corrida.EnderecoInicial}" /></td>
							<td><c:out value="${corrida.EnderecoFinal}" /></td>
							<td><c:out value="${corrida.Pet}" /></td>
						</tr>
					</c:forEach>
				</tbody>
	
		</table>

	</form>

</body>
</html>