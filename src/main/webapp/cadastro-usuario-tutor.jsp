<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar tutor</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>resources/css/estilo.css"/>
        <style><%@include file="\resources\css\estilo.css"%></style>
        
        <script><%@include file="\resources\js\metodos.js"%></script>
        
</head>
<body>
<h1 id="cadastroUsuario">Insira os dados para cadastro:</h1>
<div id="divTutorCadastro" 	class="formCadastro" >
		
		<form action="<%=request.getContextPath()%>/cadastrar-tutor" method="post">
		
		
			
			
			<label for="nomeTutorCad">Nome</label><br>
			<input type="text" id="nomeTutorCad" name="nomeTutorCad" maxlength ="25" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" required><br>
			
			
			
			<label for="sobrenomeTutorCad">Sobrenome</label><br>
			<input type="text" id="sobrenomeTutorCad"  name="sobrenomeTutorCad" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" maxlength ="25" required><br>
			
			
			
			<label for="cpfTutorCad">CPF</label><br>
			<input type="text" id="cpfTutorCad1" oninput="mascara(this, 'cpf')" name="cpfTutorCad" maxlength ="14" required><br>
			
			
				
			<label for = "telefoneTutorCad">Telefone</label><br>
			<input type ="tel" id="telefoneTutorCad" oninput="mascara(this, 'tel')" name = "telefoneTutorCad" maxlength ="15" placeholder="(99)99999-9999" required><br>
			
			
			
			<label for="idadeTutorCad">Idade</label><br>
			<input type ="text" id="idadeTutorCad" oninput="mascara(this, 'idade')" name="idadeTutorCad" maxlength ="3" required><br>
			
			<label for="emailMotoristaCad">Email</label><br>
			<input type ="text" id="emailTutorCad" onblur="mascaraEmail(this, 'email')" name ="emailTutorCad" maxlength ="35" required><br>
			
			<label for="usuarioTutorCad">Login</label><br>
			<input type="text" id="usuarioTutorCad" name="loginTutorCad" maxlength ="25" required><br>
			
			<label for="senhaTutorCad">Senha</label><br>
			<input type="password" id="senhaTutorCad" name="senhaTutorCad" maxlength ="25" required><br>
			
			<label for="confirmarSenhaTutorCad">Confirmar Senha</label><br>
			<input type="password" id="confirmarSenhaTutorCad" name="confirmarSenhaTutorCad" maxlength ="25" required><br><br>
   			
   			
   			<input type ="submit" value="Cadastrar-se" id="botaoTutor">
			
		</form>
	
	</div>
	<a class="botaoVoltar" href="<%=request.getContextPath()%>/tela-inicial.jsp">Voltar</a>
</body>
</html>