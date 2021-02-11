<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Animal Tutor</title>
</head>
<body>

	<h1>Insira os dados para cadastrar seu Pet!</h1>
		
		<form action="animal-tutor" method="post">
		
		<label for="selectAnimalTutorCad">Tutor</label>
	<select id="selectAnimalTutorCad" name="selectAnimalTutorCad">
	 <option value="">..</option>
    <c:forEach var="animais" items="${animal}">
     </c:forEach>
	</select><br>
		</form>
		
		<form action="cadastrar-animal-tutor" method="post">
			
			<fieldset>
			<label for="nomeAnimalTutorIns">Nome</label><br>
			<input type ="text" id="nomeAnimalTutorIns" name="nomeAnimalTutorIns" maxlength="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="pesoAnimalTutorIns">Peso</label><br>
			<input type ="text" id="pesoAnimalTutorIns" name="pesoAnimalTutorIns" maxlength="5" required><br>
			
			</fieldset>
			
			<fieldset>
			<label for="racaAnimalTutorIns">Raça</label><br>
			<input type ="text" id="racaAnimalTutorIns" name ="racaAnimalTutorIns" maxlength="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="tamanhoAnimalTutorIns">Tamanho</label><br>
			<input type ="text" id="tamanhoAnimalTutorIns" name="tamanhoAnimalTutorIns" maxlength="5" required><br>
		
			</fieldset>
			
			<fieldset>
			<label for="selectTipoAnimalIns">Tipo</label>
			<select id="selectTipoAnimalIns" name="selectTipoAnimal">
				<option value="0">Gato</option>
				<option value="1">Cachorro</option>
			</select>
			</fieldset>
			
			<fieldset>
			<label for="observacaoAnimalTutorIns">Observação</label><br>
			<textarea id="observacaoAnimalTutorIns" name="observacaoAnimalTutorIns" maxlength="100" ></textarea><br><br>
			</fieldset>
			
			<input type ="submit" value="Cadastrar Pet" id="botaoInsAnimalTutor">
			
		</form>

</body>
</html>