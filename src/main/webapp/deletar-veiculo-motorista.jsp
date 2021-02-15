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

<h1>Selecione o veiculo para deletar</h1>

	<form action="">
		<label for="motorista">Escolha o Motorista</label><br> 
		<select name="motorista" id="deletarVeiculoMotorista">
		
		<option value="motorista">..</option>
    <c:forEach var="motorista" items="${motoristas}">
        <option value="${motorista.codigoMotorista}">
            ${motorista.Nome}
            ${motorista.Sobrenome}
        </option>
     </c:forEach>
		</select><br>
	</form>


	<form action="" hidden>
	
	<h3>Selecione o Veiculo</h3>
	
		<table>
			
			<tr>
				<td>Veiculo</td>
				<td>Marca</td>
				<td>Modelo</td>
				<td>Ano</td>
			</tr>
			
			<tbody>
					<c:forEach var="VeiculoMotoristaDel" items="${veiculos}">
						<tr>
							<td><c:out value="${veiculo.Veiculo}" /></td>
							<td><c:out value="${veiculo.Marca}" /></td>
							<td><c:out value="${veiculo.Modelo}" /></td>
							<td><c:out value="${veiculo.Ano}" /></td>
							<td><a href="deletar?id=<c:out value='${veiculo.id}'/>">Deletar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</form>
		<br>







</body>
</html>