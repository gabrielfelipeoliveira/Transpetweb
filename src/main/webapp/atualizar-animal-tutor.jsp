<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Animal Tutor</title>
</head>
<body>
	<%@ include file="cabecalho-tutor.jsp"%>
	<h1>Insira os dados para Atualizar seu Pet!</h1>

	<c:if test="${tutores!=null }">
	<form action="<%=request.getContextPath()%>/atualizar-animal-tutor"
		method="post">
		<label>Tutor</label> <select name="idTutor">
			<c:forEach var="tutor" items="${tutores}">
				<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
					${tutor.sobreNomeUsuario}</option>
			</c:forEach>
		</select><br> <input type="submit" value="selecionar">
	</form>
	</c:if>
	<c:if test="${animais !=null}">
		<table>

			<tr>
				<th>Nome</th>
				<th>Peso</th>
				<th>Raça</th>
				<th>Tamanho</th>
				<th>Observação</th>
				<th>Selecionar</th>
			</tr>

			<tbody>
				<c:forEach var="animal" items="${animais}">
					<tr>
						<td><c:out value="${animal.nomeAnimal}" /></td>
						<td><c:out value="${animal.peso}" /></td>
						<td><c:out value="${animal.raca}" /></td>
						<td><c:out value="${animal.tamanho}" /></td>
						<td><c:out value="${animal.observacao}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/atualizar-animal-tabela?idAnimalTabela=<c:out value='${animal.idAnimal}'/>">Selecionar</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
</c:if>

<c:if test="${animal!= null }">
		<h3>Animal Doméstico</h3>
	
		<form
			action="<%=request.getContextPath()%>/atualizar-animal-tutor-dados"
			method="post">

			<input type = "text" id = "idAnimalDados" name="idAnimalDados" value="${animal.idAnimal}" hidden>
			
			<fieldset>
				<label >Nome</label><br> <input
					type="text" id="nomeAnimalTutorAtu" name="nomeAnimalTutorAtu"
					value="${animal.nomeAnimal}" maxlength="25" required><br>
			</fieldset>

			<fieldset>
				<label> Peso</label><br> <input
					type="text" id="pesoAnimalTutorAtu" name="pesoAnimalTutorAtu"
					value="${animal.peso}" maxlength="5" required><br> 
			</fieldset>

			<fieldset>
				<label >Raça</label><br> <input
					type="text" id="racaAnimalTutorAtu" name="racaAnimalTutorAtu"
					value="${animal.raca}" maxlength="25" required><br>
			</fieldset>

			<fieldset>
				<label >Tamanho</label><br> <input
					type="text" id="tamanhoAnimalTutorAtu" name="tamanhoAnimalTutorAtu"
					value="${animal.tamanho}" maxlength="5" required><br> 
			</fieldset>

			<fieldset>
				<label>Observação</label><br>
				<textarea id="observacaoAnimalTutorAtu"
					name="observacaoAnimalTutorAtu" value="${animal.observacao}" maxlength="100">
			
			</textarea>
				<br>
				<br>
			</fieldset>

			<input type="submit" value="Atualizar Pet" id="botaoAtuaAnimalTutor">

		</form>
	</c:if>

</body>
</html>