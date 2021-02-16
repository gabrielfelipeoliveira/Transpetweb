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
			<p>caso você ja tenha uma conta!</p>
				<form action="<%=request.getContextPath()%>/login" method="post">
  					<label for="usuario">Usuario</label><br>
  					<input type="text" id="usuario" name="usuario"><br>
  					<label for="senha">Senha</label><br>
  					<input type="password" id="senha" name="senha"><br><br>
  					<input type="submit" value="Entrar">
				</form>
			
		<h3>O que somos?</h3>
	
		
		<p>Somos a solução para conectar tutores de animais domésticos</p> 
		<p>que necessitam de um transporte de curta distância especializado</p>
		<p>para o seu pet, com motoristas adequados, segurança e praticidade.</p>
		
	
			
				<p>Caso você não seja um cliente ou queira trabalhar conosco, </p>
				<p>clique em CADASTRAR-SE.</p>

				<a href="<%=request.getContextPath()%>/inicial-cadastro"> Cadastrar-se</a>

</body>
</html>