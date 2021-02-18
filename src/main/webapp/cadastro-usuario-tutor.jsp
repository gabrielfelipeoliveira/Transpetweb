<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar tutor</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>resources/css/estilo.css"/>
        <style><%@include file="\resources\css\estilo.css"%></style>
</head>
<body>

<div id="divTutorCadastro" 	class="formCadastro" >
		
		<form action="<%=request.getContextPath()%>/cadastrar-tutor" method="post">
		
			<h3>Tutor</h3>
			
			
			<label for="nomeTutorCad">Nome</label><br>
			<input type="text" id="nomeTutorCad" name="nomeTutorCad" maxlength ="25" required><br>
			
			
			
			<label for="sobrenomeTutorCad">Sobrenome</label><br>
			<input type="text" id="sobrenomeTutorCad" name="sobrenomeTutorCad" maxlength ="25" required><br>
			
			
			
			<label for="cpfTutorCad">CPF</label><br>
			<input type="text" id="cpfTutorCad" name="cpfTutorCad" maxlength ="11" required><br>
			
			
				
			<label for = "telefoneTutorCad">Telefone</label><br>
			<input type ="tel" id="telefoneTutorCad" name = "telefoneTutorCad" maxlength ="11" placeholder="(99)99999-9999" pattern="[0-9]{2}[0-9]{1}[0-9]{4}[0-9]{4}"required><br>
			
			
			
			<label for="idadeTutorCad">Idade</label><br>
			<input type ="text" id="idadeTutorCad" name="idadeTutorCad" maxlength ="3" required><br>
			
			<label for="emailMotoristaCad">Email</label><br>
			<input type ="text" id="emailTutorCad" name ="emailTutorCad" maxlength ="35" required><br>
			
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