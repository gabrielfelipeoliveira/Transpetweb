<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Dados Tutor</title>
   <script><%@include file="\resources\js\metodos.js"%></script>
</head>
<body>

	<%@ include file="cabecalho-tutor.jsp"%>


	

	<c:if test="${tutor!=null }">
		<div class="formCadastro">
			<h3>Atualize os dados</h3>
			<form
				action="<%=request.getContextPath()%>/dados-tutor-atualizar-atu">


				<input type="hidden" name="idTutorAtu" maxlength="25"
					value="${tutor.idUsuario }" >
				
					<label>Nome</label><br> 
					<input type="text" name="nomeTutorAtu" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$"	maxlength="25" required value="${tutor.nomeUsuario }"><br>

					<label>Sobrenome</label><br> 
					<input type="text" name="sobrenomeTutorAtu" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$" maxlength="25" required value="${tutor.sobreNomeUsuario }"><br> 
					
					<label>Cpf</label><br>
					<input type="text" name="cpfTutorAtu"  oninput="mascara(this, 'cpf')" maxlength="11" required value="${tutor.cpfUsuario }"><br> 
					
					<label>Telefone</label><br>
					<input type="tel" name="telefoneTutorAtu"  oninput="mascara(this, 'tel')" maxlength="15" required placeholder="(99)99999-9999" value="${tutor.telefoneUsuario}"><br>
					
					<label>E-mail</label><br>
					<input type="text" name="emailTutorAtu"  onblur="mascaraEmail(this, 'email')" maxlength="35" required
						value="${tutor.emailUsuario }"><br>
					
					<label>Idade</label><br>
					<input type="text" name="idadeTutorAtu"  oninput="mascara(this, 'idade')" maxlength="3" required
						value="${tutor.idadeUsuario }"><br> 
					
					<label>Usuário</label><br>
					<input type="text" name="usuarioTutorAtu" maxlength="25" required
						value="${tutor.login_usuario }"><br> 
					
					<label>Senha</label><br>
					<input type="password" name="senhaTutorAtu" maxlength="25" required
						value="${tutor.senha_usuario }"><br>
				

				<input type="submit" id="submitTutorAtu" value="Atualizar">

			</form>
			<br>
		</div>
	</c:if>
</body>
</html>