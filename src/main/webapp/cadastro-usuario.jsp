<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<h1>Insira os dados para cadastro:</h1>
	<div id="divMotoristaCadastro">
	
		<h3>Motorista</h3>
		
						
			<form action="<%=request.getContextPath()%>/cadastrar-motorista" method="post">
			
			<fieldset>
			<label for="nomeMotoristaCad">Nome</label><br>
			<input type ="text" id="nomeMotoristaCad" name="nomeMotoristaCad" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="sobrenomeMotoristaCad">Sobrenome</label><br>
			<input type ="text" id="sobrenomeMotoristaCad" name="sobrenomeMotoristaCad" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="cpfMotoristaCad">CPF</label><br>
			<input type ="text" id="cpfMotoristaCad" name ="cpfMotoristaCad" maxlength ="11" required><br>
			</fieldset>
			
			<fieldset>
			<label for="cnhMotoristaCad">CNH</label><br>
			<input type ="text" id="cnhMotoristaCad" name="cnhMotoristaCad" maxlength ="11" required><br>
			</fieldset>
			
			<fieldset>
			<label for = "telefoneMotoristaCad">Telefone</label><br>
			<input type ="tel" id="telefoneMotoristaCad" name = "telefoneMotoristaCad" maxlength ="11" placeholder="(99)9-9999-9999" pattern="[0-9]{2}[0-9]{1}[0-9]{4}[0-9]{4}"required><br>
			</fieldset>
		
			<fieldset>
			<label for="idadeMotoristaCad">Idade</label><br>
			<input type ="text" id="idadeMotoristaCad" name="idadeMotoristaCad" maxlength ="3" required><br>
			</fieldset>
			
			<fieldset>
			<label for="emailMotoristaCad">Email</label><br>
			<input type ="text" id="emailMotoristaCad" name ="emailMotoristaCad" maxlength ="35" required><br>
			</fieldset>
			
			<fieldset>
			<label for = "loginMotoristaCad">Login</label><br>
			<input type ="text" id="loginMotoristaCad" name ="loginMotoristaCad" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for = "senhaMotoristaCad">Senha</label><br>
			<input type ="password" id="senhaMotoristaCad" name ="senhaMotoristaCad" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for = "confirmarSenhaMotoristaCad">Confirmar Senha</label><br>
			<input type ="password" id="confirmarSenhaMotoristaCad" name ="confrimarSenhaMotoristaCad" required><br>
			</fieldset>
			
					
			<input type ="submit" value="Cadastrar-se" id="botaoMotorista">
			
			
		</form>
		
		
	</div>
	
	<div id="divTutorCadastro">
		
		<form action="<%=request.getContextPath()%>/cadastrar-tutor" method="post">
		
			<h3>Tutor</h3>
			
			<fieldset>
			<label for="nomeTutorCad">Nome</label><br>
			<input type="text" id="nomeTutorCad" name="nomeTutorCad" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="sobrenomeTutorCad">Sobrenome</label><br>
			<input type="text" id="sobrenomeTutorCad" name="sobrenomeTutorCad" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="cpfTutorCad">CPF</label><br>
			<input type="text" id="cpfTutorCad" name="cpfTutorCad" maxlength ="11" required><br>
			</fieldset>
			
			<fieldset>			
			<label for = "telefoneTutorCad">Telefone</label><br>
			<input type ="tel" id="telefoneTutorCad" name = "telefoneTutorCad" maxlength ="11" placeholder="(99)99999-9999" pattern="[0-9]{2}[0-9]{1}[0-9]{4}[0-9]{4}"required><br>
			</fieldset>
			
			<fieldset>
			<label for="idadeTutorCad">Idade</label><br>
			<input type ="text" id="idadeTutorCad" name="idadeTutorCad" maxlength ="3" required><br>
			</fieldset>
			
			<fieldset>
			<label for="emailMotoristaCad">Email</label><br>
			<input type ="text" id="emailTutorCad" name ="emailMotoristaCad" maxlength ="35" required><br>
			</fieldset>
			
			<fieldset>
			<label for="usuarioTutorCad">Login</label><br>
			<input type="text" id="usuarioTutorCad" name="usuarioTutorCad" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="senhaTutorCad">Senha</label><br>
			<input type="password" id="senhaTutorCad" name="senhaTutorCad" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="confirmarSenhaTutorCad">Confirmar Senha</label><br>
			<input type="password" id="confirmarSenhaTutorCad" name="confirmarSenhaTutorCad" maxlength ="25" required><br><br>
   			</fieldset>
   			
   			<input type ="submit" value="Cadastrar-se" id="botaoTutor">
			
		</form>
	
	</div>
	
</body>
</html>