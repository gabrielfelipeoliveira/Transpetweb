<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitar Corrida</title>
</head>
<body>

	<h1>Insira os dados da corrida</h1>
	<form>
		<label for= "selectTutorCorridaIns">Tutor</label>
		<select name="selectTutorCorridaIns">
		
		<option value="tutores">..</option>
    <c:forEach var="tutores" items="${tutores}">
        <option value="${tutor.corrida}">
        </option>
     </c:forEach>
		
		
		</select>
	</form>
	
	<form action="">
	
		<fieldset>
		<label for = "selectEnderecoInicial">Endereço Inicial</label><br>
			<select name="selectEnderecoInicialIns">  
			</select><br>
		</fieldset>
		
		<fieldset>
		<label for = "selectEnderecoFinal">Endereço Final</label><br>
			<select name="selectEnderecoFinalIns">  
			</select><br>
		</fieldset>
			
		<fieldset>
		<label for = "selectAnimal">Escolha seu pet</label><br>
			<select name="selectAnimalIns">  
			</select><br><br>
		</fieldset>
			
			<input type="submit" value="Solicitar">
	</form>


</body>
</html>