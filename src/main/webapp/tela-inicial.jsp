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


	<img src="https://i.imgur.com/DFW3X1bl.png"/>	
	
	<div class="login">
		<div class="loginDentro">
			
			<form action="<%=request.getContextPath()%>/login" method="post">
				<label for="usuario">Usuario</label><br> <input type="text"
					id="usuario" name="usuario"><br> <label for="senha">Senha</label><br>
				<input type="password" id="senha" name="senha"><br>
				<br> <input type="submit" value="Entrar">
			</form>
		</div>
	</div>
	

	<div class="cadastro">
	<p>Caso você queira utilizar nosso serviço ou trabalhar conosco cadastre-se como:</p>
	
		
		<a id="cadMot" class= "atualizarBotao" href="<%=request.getContextPath()%>/inicial-cadastro">Motorista</a>
		<a id="cadTut" class= "atualizarBotao" href="<%=request.getContextPath()%>/cadastro-usuario-tutor.jsp">Usuario</a>
	</div>
</body>
</html>
