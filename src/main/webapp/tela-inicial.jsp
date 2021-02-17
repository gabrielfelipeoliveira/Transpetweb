<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>resources/css/estilo.css"/>
        <style><%@include file="\resources\css\estilo.css"%></style>
<meta charset="ISO-8859-1">
<title>Tela Inicial TransPet</title>


</head>
<body>

<img src="<c:url value="<%=request.getContextPath()%>/resources/logo.png"/>" alt="descri��o da imagem" />
<div class="login">

	<p>caso voc� ja tenha uma conta!</p>
	<p>Preencha os campos informados,</p>
	
	
		<form action="<%=request.getContextPath()%>/login" method="post">
			<label for="usuario">Usuario</label><br> <input type="text"
				id="usuario" name="usuario"><br> <label for="senha">Senha</label><br>
			<input type="password" id="senha" name="senha"><br>
			<br> <input type="submit" value="Entrar">
		</form>
	</div>
	<div class="texto">
	<h3>O que somos e fazemos?</h3>

<div class="textoP">
	<p>Somos a solu��o para conectar tutores de animais dom�sticos</p>
	<p>que necessitam de um transporte de curta dist�ncia especializado</p>
	<p>para o seu pet, com motoristas adequados, seguran�a e
		praticidade.</p>
</div>
</div>

	<div class="cadastro">
	<p>Caso voc� queira utilizar nosso servi�o ou trabalhar conosco</p>
	

		<a class= "atualizarBotao" href="<%=request.getContextPath()%>/inicial-cadastro"> Cadastrar-se</a>
	</div>
</body>
</html>
