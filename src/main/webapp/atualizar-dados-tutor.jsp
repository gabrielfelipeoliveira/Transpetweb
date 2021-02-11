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
			<h1>Atualizar Dados Pessoais</h1>
	
	<form action="dados-tutor">
		<label for="selectTutorAtu">Tutor</label>
	<select id="selectTutorAtu" name="selectTutorAtu">
	 <option value="tutores">..</option>
    <c:forEach var="tutores" items="${tutor}">
        <option value="${tutor.codigoTutor}">
            ${tutor.nomeTutor}
            ${tutor.sobrenomeTutor}
        </option>
     </c:forEach>
	</select>
	</form>
	
	<form action="atualizar-dados-tutor">
		  <fieldset>
		  <label for="nomeTutorAtu">Nome</label><br>
		  <input type="text" id="nomeTutorAtu" name="nomeTutorAtu" maxlength ="25" required  ><br>
		  </fieldset>
		  
		  <fieldset>
		  <label for="sobrenomeTutorAtu">Sobrenome</label><br>
		  <input type="text" id="sobrenomeTutorAtu" name="sobrenomeTutorAtu" maxlength ="25" required ><br>
		  </fieldset>
		  
		  <fieldset>
		  <label for="cpfTutorAtu">Cpf</label><br>
		  <input type="text" id="cpfTutorAtu" name="cpfTutorAtu" maxlength ="11" required ><br>
		  </fieldset>
		  
		  <fieldset>
		  <label for = "telefoneTutorAtu">Telefone</label><br>
		  <input type ="tel" id="telefoneTutorAtu" name = "telefoneTutorAtu" maxlength ="11" required placeholder="(99)99999-9999" pattern="[0-9]{2}[0-9]{1}-[0-9]{4}-[0-9]{4}"><br>
		  </fieldset>
		  
		  <fieldset>		  
		  <label for="usuarioTutorAtu">Usuário</label><br>
		  <input type="text" id="usuarioTutorAtu" name="usuarioTutorAtu" maxlength ="25" required ><br>
		  </fieldset>
		  
		  <fieldset>
		  <label for="senhaTutorAtu">Senha</label><br>
		  <input type="password" id="senhaTutorAtu" name="senhaTutorAtu" maxlength ="25" required ><br>
		  </fieldset>
		  
		  <input type="submit" id="submitTutorAtu" value="Atualizar">

	</form><br>
	
</body>
</html>