<%@ page language="java" 	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Perfil Motorista</title>
   <script><%@include file="\resources\js\metodos.js"%></script>
</head>
<body>

<%@ include file="cabecalho-motorista.jsp" %>

	
		<c:if test="${motorista!=null }">
			<div class="formCadastro" >
		<h3>Atualize os dados</h3>
		<form action="<%=request.getContextPath()%>/atualizar-dados-motorista-atu" method="post">
		
			<input type="hidden" id="idMotoristaAtu" name="idMotoristaAtu" maxlength ="25" value="${motorista.idUsuario }" >
			
			<label for="nomeMotoristaAtu">Nome</label><br>
			<input type="text" id="nomeMotoristaAtu" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" name="nomeMotoristaAtu" maxlength ="25" value="${motorista.nomeUsuario }"><br>
			
			
			 
			<label for="sobrenomeMotoristaAtu">Sobrenome</label><br>
			<input type="text" id="sobrenomeMotoristaAtu" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" name="sobrenomeMotoristaAtu" value="${motorista.sobreNomeUsuario }" maxlength ="25" ><br>
			
			
			
			<label for="cpfMotoristaAtu">CPF</label><br>
			<input type="text" id="cpfMotoristaAtu"  oninput="mascara(this, 'cpf')" name="cpfMotoristaAtu" maxlength ="11" required value="${motorista.cpfUsuario }" ><br>
			
					
			
			<label for="cnhMotoristaAtu">CNH</label><br>
			<input type="text" id="cnhMotoristaAtu" pattern="[0-9]+$" name="cnhMotoristaAtu" maxlength ="11" required value="${motorista.cnh }" ><br>
			
			
			
			
			<label for="idadeMotoristaAtu">Idade</label><br>
			<input type="text" id="idadeMotoristaAtu"  oninput="mascara(this, 'idade')" name="idadeMotoristaAtu" maxlength ="3" required value="${motorista.idadeUsuario }" ><br>
			
			
			
			
			<label for="emailMotoristaAtu">E-mail</label><br>
			<input type="text" id="emailMotoristaAtu"  onblur="mascaraEmail(this, 'email')" name="emailMotoristaAtu" maxlength ="35" required value="${motorista.emailUsuario}" ><br>
			
			
			
			
			<label for = "telefoneMotoristaAtu">Telefone</label><br>
			<input type ="tel" id="telefoneMotoristaAtu"  oninput="mascara(this, 'tel')" name = "telefoneMotoristaAtu" maxlength ="15" required value="${motorista.telefoneUsuario}" placeholder="(99)99999-9999" pattern="[0-9]{2}[0-9]{1}[0-9]{4}[0-9]{4}"><br>
		
			
			 
			
			<label for="UsuarioMotoristaAtu">Usuário</label><br>
			<input type="text" id="loginMotoristaAtu" name="loginMotoristaAtu" maxlength ="125" required value="${motorista.login_usuario}" ><br>

			
			
			
			<label for="senhaMotoristaAtu">Senha</label><br>
			<input type="password" id="senhaMotoristaAtu" name="senhaMotoristaAtu" maxlength ="25" required value="${motorista.senha_usuario}" ><br>
			
			
			<input type="submit" id="submitMotoristaAtu" value="Atualizar">
						
							
		</form><br>
</div>
</c:if>

</body>
</html>