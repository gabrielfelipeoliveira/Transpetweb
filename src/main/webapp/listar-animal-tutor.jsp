<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de animais</title>
</head>
<body>


	<%@ include file="cabecalho-tutor.jsp"%>

	<c:if test="${tutores != null}">
		<div class="formCadastro">
			<h1>Selecione o tutor</h1>

			<form action="<%=request.getContextPath()%>/listar-animal-tutor"
				method="post">
				<label>Selecione o tutor</label> <br> <select name="idTutor">
					<c:forEach var="tutor" items="${tutores}">
						<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
							${tutor.sobreNomeUsuario}</option>
					</c:forEach>

				</select><br> <input type="submit" value="Selecionar Tutor"
					id="selecionarTutor">
			</form>
		</div>
	</c:if>

	<c:if test="${animais!=null }">
	<div class="formCadastro">
		<h3>Lista de animais</h3>
		
			
			<table>

				<tr>
					<th>Nome</th>
					<th>Raça</th>
					<th>Tamanho</th>
					<th>Peso</th>
					<th>Observação</th>
				</tr>

				<tbody>
					<c:forEach var="animal" items="${animais}">
						<tr>
							<td><c:out value="${animal.nomeAnimal}" /></td>
							<td><c:out value="${animal.raca}" /></td>
							<td><c:out value="${animal.tamanho}" /></td>
							<td><c:out value="${animal.peso}" /></td>
							<td><c:out value="${animal.observacao}" /></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</c:if>


</body>
</html>