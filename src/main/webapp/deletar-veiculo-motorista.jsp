<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deletar Veiculo Motorista</title>
</head>
<body>

<%@ include file="cabecalho-motorista.jsp" %>



	<c:if test="${motoristas!=null }">
	<div class="formCadastro" >
	<h3>Selecione o motorista</h3>
		<form
			action="<%=request.getContextPath()%>/deletar-veiculo-motorista">
			<br> <select name="idMotorista">

				<c:forEach var="motorista" items="${motoristas}">
					<option value="${motorista.idUsuario}">
						${motorista.nomeUsuario} ${motorista.sobreNomeUsuario}</option>
				</c:forEach>
			</select><br><br>
			<input type="submit" value="selecionar">
		</form>
		</div>
	</c:if>

<c:if test="${veiculos!=null }">
	<div class="formCadastro" >
	<form action="" >
	
	<h3>Selecione o Veiculo</h3>
	
		<table>
			
			<tr>
				<th>Marca</th>
				<th>Modelo</th>
				<th>Placa</th>
				<th>Ano</th>
				<th>Deletar</th>
			</tr>
			
			<tbody>
					<c:forEach var="veiculo" items="${veiculos}">
						<tr>
							<td><c:out value="${veiculo.marcaVeiculo}" /></td>
							<td><c:out value="${veiculo.modeloVeiculo}" /></td>
							<td><c:out value="${veiculo.placaVeiculo}" /></td>
							<td><c:out value="${veiculo.anoVeiculo}" /></td>
							<td><a class ="deletarBotao" href="<%=request.getContextPath()%>/deletar-veiculo-motorista-del?idVeiculoTabela=<c:out value='${veiculo.idVeiculo}'/>">Deletar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</form>
		<br>
</div>
</c:if>





</body>
</html>