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

<h1>Deletar veiculo</h1>

	<c:if test="${motoristas!=null }">
	<h3>Selecione o motorista</h3>
		<form
			action="<%=request.getContextPath()%>/deletar-veiculo-motorista">
			<label>Motorista</label><br> <select name="idMotorista">

				<c:forEach var="motorista" items="${motoristas}">
					<option value="${motorista.idUsuario}">
						${motorista.nomeUsuario} ${motorista.sobreNomeUsuario}</option>
				</c:forEach>
			</select><br><br>
			<input type="submit" value="selecionar">
		</form>
	</c:if>

<c:if test="${veiculos!=null }">
	<form action="" >
	
	<h3>Selecione o Veiculo</h3>
	
		<table>
			
			<tr>
				<td>Marca</td>
				<td>Modelo</td>
				<td>Placa</td>
				<td>Ano</td>
			</tr>
			
			<tbody>
					<c:forEach var="veiculo" items="${veiculos}">
						<tr>
							<td><c:out value="${veiculo.marcaVeiculo}" /></td>
							<td><c:out value="${veiculo.modeloVeiculo}" /></td>
							<td><c:out value="${veiculo.placaVeiculo}" /></td>
							<td><c:out value="${veiculo.anoVeiculo}" /></td>
							<td><a href="<%=request.getContextPath()%>/deletar-veiculo-motorista-del?idVeiculoTabela=<c:out value='${veiculo.idVeiculo}'/>">Deletar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</form>
		<br>

</c:if>





</body>
</html>