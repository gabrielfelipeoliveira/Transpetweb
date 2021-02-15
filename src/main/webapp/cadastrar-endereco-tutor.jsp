<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Endere�o</title>
</head>
<body>


<%@ include file="cabecalho-tutor.jsp" %>

	<h1>Insira os dados para cadastrar seu Endere�o!</h1>
		
		<form action="<%=request.getContextPath()%>/cadastrar-endereco-tutor">
			<label>Tutor</label> 
			<select name="idTutorSelect">
				<c:forEach var="tutor" items="${tutores}">
					<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
						${tutor.sobreNomeUsuario}</option>
				</c:forEach>
			</select> <br>
	
				
					
			<fieldset>
			<label >Rua</label><br>
			<input type ="text" id="idRuaEnderecoTutorIns" name="ruaEnderecoTutorIns" maxlength="25" required><br>
			
			
			<label >Cep</label><br>
			<input type ="text" id="idCepEnderecoTutorIns" name="cepEnderecoTutorIns" maxlength="8" required><br>
			
			
			
			<label >Numero</label><br>
			<input type ="text" id="idNumeroEnderecoTutorIns" name ="numeroEnderecoTutorIns" maxlength="5" required><br>
			</fieldset>
			
			
			
			<input type ="submit" value="Cadastrar Endere�o" id="botaoInsEnderecoTutor">
			
		</form>

</body>
</html>