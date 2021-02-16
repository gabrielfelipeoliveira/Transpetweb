<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela Inicial TransPet</title>

<style type="text/css"> @import url("../resources/NewFile.css"); </style>
</head>
<body>

		<h1>TransPet!</h1>
			<p>Preencha os campos informados,</p> 
			<p>caso voc� ja tenha uma conta!</p>
				<form action="<%=request.getContextPath()%>/login" method="post">
  					<label for="usuario">Usuario</label><br>
  					<input type="text" id="usuario" name="usuario"><br>
  					<label for="senha">Senha</label><br>
  					<input type="password" id="senha" name="senha"><br><br>
  					<input type="submit" value="Entrar">
				</form>
			
		<h3>O que somos?</h3>
	
		
		<p>Somos a solu��o para conectar tutores de animais dom�sticos</p> 
		<p>que necessitam de um transporte de curta dist�ncia especializado</p>
		<p>para o seu pet, com motoristas adequados, seguran�a e praticidade.</p>
		
	
			
				<p>Caso voc� n�o seja um cliente ou queira trabalhar conosco, </p>
				<p>clique em CADASTRAR-SE.</p>

				<a href="<%=request.getContextPath()%>/inicial-cadastro"> Cadastrar-se</a>

</body>
</html>