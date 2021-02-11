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

<h1>Corridas</h1>

	<form action="">
		<label>Selecione o tutor</label> <br>
		<select name="selectListarCorridaTutor">
		
		<option value="tutores">..</option>
    <c:forEach var="tutores" items="${tutores}">
        <option value="${tutor.codigoTutor}">
            ${tutor.Nome}
            ${tutor.Sobrenome}
        </option>
     </c:forEach>
		</select>
	</form>

	
	<div hidden>
		<h3>Histórico de Corrida</h3>
		<table>

			<tr>
				<td>Endereço Inicial</td>
				<td>Endereço Final</td>
				<td>Pet</td>
				<td>Nome Motorista</td>
			</tr>
			
			<tbody>
					<c:forEach var="CorridasTutorLis" items="${corridas}">
						<tr>
							<td><c:out value="${corrida.EnderecoInicial}" /></td>
							<td><c:out value="${corrida.EnderecoFinal}" /></td>
							<td><c:out value="${corrida.Pet}" /></td>
							<td><c:out value="${corrida.NomeMotorista}" /></td>
						</tr>
					</c:forEach>
				</tbody>

		</table>

		<h3>Corridas em Aberto</h3>

		<table>

			<tr>
				<td>Endereço Inicial</td>
				<td>Endereço Final</td>
				<td>Pet</td>
			</tr>
			
			<tbody>
					<c:forEach var="CorridasTutorLis" items="${corridas}">
						<tr>
							<td><c:out value="${corrida.EnderecoInicial}" /></td>
							<td><c:out value="${corrida.EnderecoFinal}" /></td>
							<td><c:out value="${corrida.Pet}" /></td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>


</body>
</html>