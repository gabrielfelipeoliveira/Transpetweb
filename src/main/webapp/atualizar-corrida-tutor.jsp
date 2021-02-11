<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Corrida Tutor</title>
</head>
<body>


<h1>Selecione a corrida para atualizar</h1>
		

		<form action="" >
		<label for="selectCorridaAtu">Tutor</label>
		<select id="selectCorridaAtu" name="selectCorridaAtu">
		
		<option value="tutores">..</option>
    <c:forEach var="tutores" items="${tutor}">
        <option value="${tutor.codigoTutores}">
            ${tutor.Nome}
            ${tutor.Sobrenome}
        </option>
     </c:forEach>
		</select>
	</form>
	
	<form action="" hidden>	
		<table>

		<tr>
			<td>Endereço Inicial</td>
			<td>Endereço Final</td>
			<td>Pet</td>
		</tr>
				<tbody>
					<c:forEach var="CorridaTutorAtua" items="${corridas}">
						<tr>
							<td><c:out value="${corrida.EnderecoInicial}" /></td>
							<td><c:out value="${corrida.EnderecoFinal}" /></td>
							<td><c:out value="${corrida.Pet}" /></td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</form>
		
		<form action="" hidden>
		
		<fieldset>
		<label for = "selectEnderecoInicial">Endereço Inicial</label><br>
			<select name="selectEnderecoInicialAtu">  
			</select><br>
			</fieldset>
			
		<fieldset>
		<label for = "selectEnderecoFinal">Endereço Final</label><br>
			<select name="selectEnderecoFinalAtu">  
			</select><br>
		</fieldset>
		
		<fieldset>
		<label for = "selectAnimal">Escolha seu pet</label><br>
			<select name="selectAnimalAtu">  
			</select><br><br>
		</fieldset>
			
	</form>

</body>
</html>