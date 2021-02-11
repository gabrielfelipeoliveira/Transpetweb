<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deletar Animal Tutor</title>
</head>
<body>

<h1>Escolha algum dos Tutores cadastrados!</h1>

	<form action="">
		<label for="selectTutorAnimalDel">Tutores Cadastrados</label><br>
		<select name="selectTutorAnimalDel">
		
		<option value="tutores">..</option>
    <c:forEach var="tutores" items="${tutor}">
        <option value="${tutor.codigoTutores}">
            ${tutor.Nome}
            ${tutor.Sobrenome}
        </option>
     </c:forEach>
		</select><br>
	</form>

	<form action="" hidden>
		<h3>Selecione um Pet para Deletar</h3>
		<table>

			<tr>
				<td>Nome</td>
				<td>Peso</td>
				<td>Raça</td>
				<td>Tamanho</td>
				<td>Observaçao</td>
			</tr>
			
			<tbody>
					<c:forEach var="AnimalTutorDel" items="${animais}">
						<tr>
							<td><c:out value="${animal.Nome}" /></td>
							<td><c:out value="${animal.Peso}" /></td>
							<td><c:out value="${animal.Raca}" /></td>
							<td><c:out value="${animal.Tamanho}" /></td>
							<td><c:out value="${animal.Observacao}" />
							<a href="deletar?id=<c:out value='${animal.id}'/>">Deletar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</form>

</body>
</html>