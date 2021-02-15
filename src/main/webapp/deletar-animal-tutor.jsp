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

	<%@ include file="cabecalho-tutor.jsp"%>

<h1>Escolha algum dos Tutores cadastrados!</h1>

	<c:if test="${tutores!=null }">
	<form action="<%=request.getContextPath()%>/deletar-animal-tutor"
		method="post">
		<label>Tutor</label> <select name="idTutor">
			<c:forEach var="tutor" items="${tutores}">
				<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
					${tutor.sobreNomeUsuario}</option>
			</c:forEach>
		</select><br> <input type="submit" value="selecionar">
	</form>
	</c:if>
	
	<c:if test="${animais!=null }">
	<form action="<%=request.getContextPath()%>/deletar-animal-tutor-del" >
		<h3>Selecione um Pet para Deletar</h3>
		<table>

			<tr>
				<th>Nome</th>
				<th>Peso</th>
				<th>Raça</td>
				<th>Tamanho</th>
				<th>Observaçao</th>
			</tr>
			
			<tbody>
					<c:forEach var="animal" items="${animais}">
						<tr>
							<td><c:out value="${animal.nomeAnimal}" /></td>
							<td><c:out value="${animal.peso}" /></td>
							<td><c:out value="${animal.raca}" /></td>
							<td><c:out value="${animal.tamanho}" /></td>
							<td><c:out value="${animal.observacao}" /></td>
							<td><a
							href="<%=request.getContextPath()%>/deletar-animal-tutor-del?idAnimalTutorDel=<c:out value='${animal.idAnimal}'/>">Selecionar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</form>
</c:if>
</body>
</html>