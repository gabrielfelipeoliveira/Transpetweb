<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>resources/css/estilo.css"/>
        <style><%@include file="\resources\css\estilo.css"%></style>
        <script><%@include file="\resources\js\metodos.js"%></script>
        
</head>
<body>
	<h1 id="cadastroUsuario">Insira os dados para cadastro:</h1>
	<div id="divMotoristaCadastro" 	class="formCadastro" >
		
						
			<form action="<%=request.getContextPath()%>/cadastrar-motorista" method="post">
			
			<label >Nome</label><br>
			<input type ="text" id="nomeMotoristaCad" name="nomeMotoristaCad" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" maxlength ="25" required><br>
			
			
			
			<label>Sobrenome</label><br>
			<input type ="text" id="sobreNomeMotoristaCad" name="sobreNomeCad" maxlength ="25" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" required><br>
			
			
			
			<label >CPF</label><br>
			<input type ="text" id="cpfMotoristaCad" oninput="mascara(this, 'cpf')" name ="cpfMotoristaCad" maxlength ="11" required><br>
			
			
			
			<label >CNH</label><br>
			<input type ="text" id="cnhMotoristaCad" name="cnhMotoristaCad" maxlength ="11" pattern="[0-9]+$" required><br>
			
			
			
			<label >Telefone</label><br>
			<input type ="tel" id="telefoneMotoristaCad" oninput="mascara(this, 'tel')" name = "telefoneMotoristaCad" maxlength ="15" placeholder="(99)9-9999-9999" required><br>
			
		
			
			<label for="idadeMotoristaCad">Idade</label><br>
			<input type ="text" id="idadeMotoristaCad" name="idadeMotoristaCad" oninput="mascara(this, 'idade')" maxlength ="3" required><br>
			
			
			
			<label >Email</label><br>
			<input type ="text" id="emailMotoristaCad" name ="emailMotoristaCad" onblur="mascaraEmail(this, 'email')" maxlength ="35" required><br>
			
			
			
			<label >Login</label><br>
			<input type ="text" id="loginMotoristaCad" name ="loginMotoristaCad" maxlength ="25" required><br>
			
			
			
			<label >Senha</label><br>
			<input type ="password" id="senhaMotoristaCad" name ="senhaMotoristaCad" maxlength ="25" required><br>
			
			
			
			<label >Confirmar Senha</label><br>
			<input type ="password" id="confirmarSenhaMotoristaCad" name ="confrimarSenhaMotoristaCad" required><br>
			
					
			<input type ="submit" value="Cadastrar-se" id="botaoMotorista">
			
			
		</form>
		
		
	</div>
	
	
	<a class="botaoVoltar" href="<%=request.getContextPath()%>/tela-inicial.jsp">Voltar</a>
</body>
</html>