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

	<%@ include file="cabecalho-tutor.jsp"%>
	<c:if test="${tutores!=null }">
		<div class="formCadastro" >
		<h3>Selecione o tutor</h3>
		<form action="<%=request.getContextPath()%>/deletar-corrida-tutor">
			<select name="idTutor">
				<c:forEach var="tutor" items="${tutores}">
					<option value="${tutor.idUsuario}">${tutor.nomeUsuario}
						${tutor.sobreNomeUsuario}</option>
				</c:forEach>
			</select> <br> <input type="submit" value="Selecionar Tutor"
				id="selecionarTutor">
		</form>
		</div>
	</c:if>
	
	<c:if test="${corridas!=null }">
		<div class="formCadastro" >
		<form action="<%=request.getContextPath()%>/deletar-corrida-tutor-del">

			<h3>Selecione a corrida</h3>

			<table>

				<tr>
					<th>Endereço Inicial</th>
					<th>Endereço Final</th>
					<th>Pet</th>
					<th>Selecionar</th>
				</tr>

				<tbody>
					<c:forEach var="corrida" items="${corridas}">
						<tr>
							<td><c:out value="${corrida.enderecoInicial.ruaEndereco}" /></td>
							<td><c:out value="${corrida.enderecoFinal.ruaEndereco}" /></td>
							<td><c:out value="${corrida.animal.nomeAnimal}" /></td>
							<td><a class="deletarBotao"
								href="<%=request.getContextPath()%>/deletar-corrida-tutor-del?idCorridaTabela=<c:out value='${corrida.idCorrida}'/>">Deletar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		</div>
	</c:if>
</body>
</html>