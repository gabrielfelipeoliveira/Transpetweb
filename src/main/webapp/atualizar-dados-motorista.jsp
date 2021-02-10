<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Perfil Motorista</title>
</head>
<body>

	<h1>Editar Dados Pessoais</h1>
	
		<form action="dados-motorista" method="post">
		
		<label for="selectMotoristaAtu">Tutor</label>
	<select id="selectMotoristaAtu" name="selectMotoristaAtu">
	 <option value="">..</option>
    <c:forEach var="motoristas" items="${motorista}">
        <option value= "${motoista.codigoMotorista}">
           				${motorista.nomeMotorista}
            			${motorista.sobrenomeMotorista}
        </option>
     </c:forEach>
	</select>
	</form>
		
		<form action="atualizar-dados-motorista" method="post">
		
			<fieldset>
			<label for="nomeMotoristaAtu">Nome</label><br>
			<input type="text" id="nomeMotoristaAtu" name="nomeMotoristaAtu" maxlength ="25"><br>
			</fieldset>
			
			 <fieldset>
			<label for="sobrenomeMotoristaAtu">Sobrenome</label><br>
			<input type="text" id="sobrenomeMotoristaAtu" name="sobrenomeMotoristaAtu" maxlength ="25" ><br>
			</fieldset>
			
			<fieldset>
			<label for="cpfMotoristaAtu">Cpf</label><br>
			<input type="text" id="cpfMotoristaAtu" name="cpfMotoristaAtu" maxlength ="11" required ><br>
			</fieldset>
			
			<fieldset>
			<label for="cnhMotoristaAtu">Cnh</label><br>
			<input type="text" id="cnhMotoristaAtu" name="cnhMotoristaAtu" maxlength ="11" required  ><br>
			</fieldset>
			
			<fieldset>
			<label for="idadeMotoristaAtu">Idade</label><br>
			<input type="text" id="idadeMotoristaAtu" name="idadeMotoristaAtu" maxlength ="3" required  ><br>
			</fieldset>
			
			<fieldset>
			<label for="emailMotoristaAtu">Email</label><br>
			<input type="text" id="emailMotoristaAtu" name="emailMotoristaAtu" maxlength ="35" required  ><br>
			</fieldset>
			
			<fieldset>
			<label for = "telefoneMotoristaAtu">Telefone</label><br>
			<input type ="tel" id="telefoneMotoristaAtu" name = "telefoneMotoristaAtu" maxlength ="11" required  placeholder="(99)99999-9999" pattern="[0-9]{2}[0-9]{1}-[0-9]{4}-[0-9]{4}"><br>
			 </fieldset>
			 
			<fieldset>
			<label for="UsuarioMotoristaAtu">Usuário</label><br>
			<input type="text" id="UsuarioMotoristaAtu" name="UsuarioMotoristaAtu" maxlength ="125" required  ><br>
			</fieldset>
			
			<fieldset> 
			<label for="senhaMotoristaAtu">Senha</label><br>
			<input type="password" id="senhaMotoristaAtu" name="senhaMotoristaAtu" maxlength ="25" required  ><br>
			</fieldset>
			
			<input type="submit" id="submitMotoristaAtu" value="Atualizar">
						
							
		</form><br>



</body>
</html>