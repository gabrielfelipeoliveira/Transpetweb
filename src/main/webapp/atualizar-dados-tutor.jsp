<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Dados Tutor</title>
</head>
<body>

<%@ include file="cabecalho-tutor.jsp" %>

			<h1>Atualizar Dados Pessoais</h1>
	
	<form action="<%=request.getContextPath()%>/dados-tutor-atualizar">
		<label>Tutor</label> <select name="idTutor">
			<c:forEach var="tutor" items="${tutores}">
				<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
					${tutor.sobreNomeUsuario}</option>
			</c:forEach>
		</select> <br> <input type="submit" value="Selecionar Tutor"
			id="selecionarTutor">
	</form>
	
	<form action="<%=request.getContextPath()%>/dados-tutor-atualizar-atu">
	
			
			<input type="text"  name="idTutorAtu" maxlength ="25" value ="${tutor.idUsuario }" hidden>
			<fieldset>
			<label>Nome</label><br>
			<input type="text"  name="nomeTutorAtu" maxlength ="25" required value ="${tutor.nomeUsuario }"><br>
			 
			  
			  
			<label>Sobrenome</label><br>
			<input type="text" name="sobrenomeTutorAtu" maxlength ="25" required value ="${tutor.sobreNomeUsuario }"><br>
			  
			  
			  
			<label>Cpf</label><br>
			<input type="text"  name="cpfTutorAtu" maxlength ="11" required value ="${tutor.cpfUsuario }" ><br>
			  
			  
			  
			<label>Telefone</label><br>
			<input type ="tel" name = "telefoneTutorAtu" maxlength ="11" required placeholder="(99)99999-9999" pattern="[0-9]{2}[0-9]{1}[0-9]{4}[0-9]{4}" value ="${tutor.telefoneUsuario}"><br>
			  
			  
			<label >E-mail</label><br>
			<input type="text"  name="emailTutorAtu" maxlength ="35" required value ="${tutor.emailUsuario }"><br>	  
				
			
			<label>Idade</label><br>
			<input type="text" name="idadeTutorAtu" maxlength ="3" required value ="${tutor.idadeUsuario }"><br>
					
			 
			<label >Usuário</label><br>
			<input type="text"  name="usuarioTutorAtu" maxlength ="25" required value ="${tutor.login_usuario }"><br>
			  
			  
			 
			<label>Senha</label><br>
			<input type="password"  name="senhaTutorAtu" maxlength ="25" required value ="${tutor.senha_usuario }"><br>
			</fieldset>
			  
			<input type="submit" id="submitTutorAtu" value="Atualizar">

	</form><br>
	
</body>
</html>