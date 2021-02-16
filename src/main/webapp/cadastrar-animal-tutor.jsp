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

<%@ include file="cabecalho-tutor.jsp" %>
	<div class="formCadastro" >
	<h1>Insira os dados para cadastrar seu Pet!</h1>
		
		<form action="<%=request.getContextPath()%>/cadastrar-animal-tutor-inserir">
		<select name="idTutor">
			<c:forEach var="tutor" items="${tutores}">
				<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
					${tutor.sobreNomeUsuario}</option>
			</c:forEach>
		</select> <br>
	
				
					
			<fieldset>
			<label >Nome</label><br>
			<input type ="text" id="nomeAnimalTutorIns" name="nomeAnimalTutorIns" maxlength="25" required><br>
			
			<label >Peso</label><br>
			<input type ="text" id="pesoAnimalTutorIns" name="pesoAnimalTutorIns" maxlength="5" required><br>
			
			
			<label >Raça</label><br><bR>
			<input type ="text" id="racaAnimalTutorIns" name ="racaAnimalTutorIns" maxlength="25" required><br>
			
			<label >Tamanho</label><br>
			<input type ="text" id="tamanhoAnimalTutorIns" name="tamanhoAnimalTutorIns" maxlength="5" required><br>
		
			<label >Tipo</label><br>
			<select id="selectTipoAnimalIns" name="selectTipoAnimal">
				<option value="0">Gato</option>
				<option value="1">Cachorro</option>
			</select>
			
			<label >Observação</label><br>
			<textarea id="observacaoAnimalTutorIns" name="observacaoAnimalTutorIns" maxlength="100" ></textarea><br><br>
			</fieldset>
			
			<input type ="submit" value="Cadastrar Pet" id="botaoInsAnimalTutor">
			
		</form>
	</div>
</body>
</html>