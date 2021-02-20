<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Endereço</title>
<script><%@include file="\resources\js\metodos.js"%></script>
</head>
<body>


<%@ include file="cabecalho-tutor.jsp" %>
	<div class="formCadastro" >
	<h1>Insira os dados para cadastrar um Endereço!</h1>
	
		
		<form action="<%=request.getContextPath()%>/cadastrar-endereco-tutor">
			
			<input type="hidden" value ="${tutor.idUsuario }" id="idTutorEnderecoAtu" name="idTutorEnderecoAtu">
				
					
			
			<label >Rua</label><br>
			<input type ="text" id="idRuaEnderecoTutorIns" name="ruaEnderecoTutorIns" maxlength="25" required><br>
			
			
			<label >Cep</label><br>
			<input type ="text" id="idCepEnderecoTutorIns" oninput="mascara(this, 'cep')" name="cepEnderecoTutorIns" maxlength="8" required><br>
			
			
			
			<label >Numero</label><br>
			<input type ="text" id="idNumeroEnderecoTutorIns" pattern="[0-9]+$" name ="numeroEnderecoTutorIns" maxlength="5" required><br>
			
			
			
			
			<input type ="submit" value="Cadastrar Endereço" id="botaoInsEnderecoTutor">
			
		</form>
</div>
</body>
</html>