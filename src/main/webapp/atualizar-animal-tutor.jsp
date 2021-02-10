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
        <option value= "${animal.nomeAnimal}">
           				${animal.racaAnimal}
            			
            			
        </option>
     </c:forEach>
	</select><br>
	</form>
		
			<h3>Animal Doméstico</h3>
			
			<form action="atualizar-animal-tutor" method="post">
			
			<fieldset>
			<label for="nomeAnimalTutorAtu">Nome</label><br>
			<input type ="text" id="nomeAnimalTutorAtu" name="nomeAnimalTutorAtu" value="" maxlength="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="pesoAnimalTutorAtu">Peso</label><br>
			<input type ="text" id="pesoAnimalTutorAtu" name="pesoAnimalTutorAtu" value="" maxlength="5" required><br>
			${animal.pesoAnimal}
			</fieldset>
			
			<fieldset>
			<label for="racaAnimalTutorAtu">Raça</label><br>
			<input type ="text" id="racaAnimalTutorAtu" name ="racaAnimalTutorAtu" value="" maxlength="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="tamanhoAnimalTutorAtu">Tamanho</label><br>
			<input type ="text" id="tamanhoAnimalTutorAtu" name="tamanhoAnimalTutorAtu" value="" maxlength="5" required><br>
			${animal.tamanhoAnimal}
			</fieldset>
			
			<fieldset>
			<label for="observacaoAnimalTutorAtu">Observação</label><br>
			<textarea id="observacaoAnimalTutorAtu" name="observacaoAnimalTutorAtu" value="" maxlength="100">
			${animal.observacaoAnimal}
			</textarea><br><br>
			</fieldset>
					
			<input type ="submit" value="Atualizar Pet" id="botaoAtuaAnimalTutor">			
			
		</form>

</body>
</html>