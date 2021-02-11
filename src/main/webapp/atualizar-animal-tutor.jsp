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

	<h1>Insira os dados para Atualizar seu Pet!</h1>

		<form action="animal-tutor" method="post">
			<label for="selectTutorAnimalAtu">Tutor</label>
	<select id="selectTutorAnimalAtu" name="selectTutorAnimalAtu">
	 <option value="">..</option>
    <c:forEach var="animais" items="${animal}">
        <option value= "${animal.nome}
           				${animal.raca}">
            			
            			
        </option>
     </c:forEach>
	</select><br>
	</form>
	
	<table>

		<tr>
			<td>Nome</td>
			<td>Peso</td>
			<td>Raça</td>
			<td>Tamanho</td>
			<td>Observação</td>
		</tr>

				<tbody>
					<c:forEach var="CorridasTutorLis" items="${corridas}">
						<tr>
							<td><c:out value="${animal.nome}" /></td>
							<td><c:out value="${animal.peso}" /></td>
							<td><c:out value="${animal.raca}" /></td>
							<td><c:out value="${animal.tamanho}" /></td>
							<td><c:out value="${animal.observacao}" /></td>
						</tr>
					</c:forEach>
				</tbody>

		</table>
		
			<h3>Animal Doméstico</h3>
			
			<form action="atualizar-animal-tutor" method="post">
			
			<fieldset>
			<label for="nomeAnimalTutorAtu">Nome</label><br>
			<input type ="text" id="nomeAnimalTutorAtu" name="nomeAnimalTutorAtu" value="" maxlength="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="pesoAnimalTutorAtu">Peso</label><br>
			<input type ="text" id="pesoAnimalTutorAtu" name="pesoAnimalTutorAtu" value="" maxlength="5" required><br>
			${animal.peso}
			</fieldset>
			
			<fieldset>
			<label for="racaAnimalTutorAtu">Raça</label><br>
			<input type ="text" id="racaAnimalTutorAtu" name ="racaAnimalTutorAtu" value="" maxlength="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="tamanhoAnimalTutorAtu">Tamanho</label><br>
			<input type ="text" id="tamanhoAnimalTutorAtu" name="tamanhoAnimalTutorAtu" value="" maxlength="5" required><br>
			${animal.tamanho}
			</fieldset>
			
			<fieldset>
			<label for="observacaoAnimalTutorAtu">Observação</label><br>
			<textarea id="observacaoAnimalTutorAtu" name="observacaoAnimalTutorAtu" value="" maxlength="100">
			${animal.observacao}
			</textarea><br><br>
			</fieldset>
					
			<input type ="submit" value="Atualizar Pet" id="botaoAtuaAnimalTutor">			
			
		</form>

</body>
</html>