<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deletar Corrida Tutor</title>
</head>
<body>


<h1>Selecione a corrida para Deletar</h1>
		
	<form for="deletarCorridaTutor" action="" >
		<label>Selecione o tutor</label>
		<select name = "deletarCorridaTutor" id="deletarCorridaTutor">
		
		<option value="CorridaTutorDel">..</option>
    <c:forEach var="CorridaTutorDel" items="${tutor}">
        <option value="${tutor.codigoTutores}">
             ${tutor.Nome}
            ${tutor.Sobrenome}
        </option>
     </c:forEach>
		</select><br>
	</form>
	
		
	<form action="" hidden>	
	
	<h3>Selecione a corrida</h3>
	
	<table>
		
		<tr>
			<td>Endereço Inicial</td>
			<td>Endereço Final</td>
			<td>Pet</td>
		</tr>
		
		<tbody>
					<c:forEach var="CorridaTutorDel" items="${corridas}">
						<tr>
							<td><c:out value="${corrida.EnderecoInicial}" /></td>
							<td><c:out value="${corrida.EnderecoFinal}" /></td>
							<td><c:out value="${corrida.Pet}" /></td>
							<td><a href="deletar?id=<c:out value='${animal.id}'/>">Deletar</a></td>
						</tr>
					</c:forEach>
				</tbody>
	</table>
	</form>

</body>
</html>