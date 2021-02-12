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

	<form action="/listar-corrida-tutor" method="post">
		<label>Selecione o tutor</label> <br> 
		<select name="selectListarCorridaTutor">
			<c:forEach var="tutor" items="${tutores}">
				<option id="idTutor" value="${tutor.idUsuario}">${tutor.nomeUsuario} ${tutor.sobreNomeUsuario}</option>
			</c:forEach>
			
		</select><br>
		<input type ="submit" value="Selecionar Tutor" id="selecionarTutor">
	</form>

	<c:if test="${corridas!=null }">
	<div >
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
						<td><c:out value="${corrida.enderecoInicial.ruaEndereco}" /></td>
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
				<td>Endereço Inicial</td>
				<td>Endereço Final</td>
				<td>Pet</td>
			</tr>

			<tbody>
				<c:forEach var="corrida" items="${corridasFeitas}">
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