<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Veículo Motorista</title>
</head>
<body>


	<%@ include file="cabecalho-motorista.jsp"%>

	
	

<c:if test="${veiculos!=null }">
	<div class="formCadastro" >
	<h3>Selecione o veículo para atualizar</h3>
	<table>
		<tr>
			<th>Marca</th>
			<th>Modelo</th>
			<th>Placa</th>
			<th>Ano</th>
			<th>Selecionar</th>
		</tr>
		<tbody>
		<c:forEach var="veiculo" items="${veiculos}">
			<tr>
							
				<td><c:out value="${veiculo.marcaVeiculo}" /></td>
				<td><c:out value="${veiculo.modeloVeiculo}" /></td>
				<td><c:out value="${veiculo.placaVeiculo}" /></td>
				<td><c:out value="${veiculo.anoVeiculo}" /></td>
				
				<td><a class="atualizarBotao"
					href="<%=request.getContextPath()%>/atualizar-veiculo-tabela?idVeiculoTabela=<c:out value='${veiculo.idVeiculo}'/>">Atualizar</a></td>

			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</c:if>

<c:if test="${veiculo!=null }">
	<div class="formCadastro" >
	<h3>Atualize os dados</h3>

	<form action="<%=request.getContextPath()%>/atualizar-veiculo-dados" method="post">
		
			
			<input
				type="hidden" id="IdVeiculoAtu"
				name="IdVeiculoAtu" value="${veiculo.idVeiculo}" maxlength="25" required ><br>
		
			<label>Marca</label><br> <input
				type="text" id="marcaVeiculoMotoristaAtu"
				name="marcaVeiculoMotoristaAtu" value="${veiculo.marcaVeiculo}" maxlength="25" required><br>
		

		
			<label >Modelo</label><br> <input
				type="text" id="modeloVeiculoMotoristaAtu"
				name="modeloVeiculoMotoristaAtu" value="${veiculo.modeloVeiculo}" maxlength="35" required><br>
		

		
			<label>Placa</label><br> <input
				type="text" id="placaVeiculoMotoristaAtu"
				name="placaVeiculoMotoristaAtu" value="${veiculo.placaVeiculo}" maxlength="7" required><br>
			
		

		
			<label>Ano</label><br> <input
				type="text" id="anoVeiculoMotoristaAtu"
				name="anoVeiculoMotoristaAtu" pattern="[0-9]+$" value="${veiculo.anoVeiculo}" maxlength="4" required><br>
			<br> 
		

		<input type="submit" value="Atualizar Veículo"
			id="botaoAtuaVeiculoMotorista">

	</form>
	</div>
</c:if>
</body>
</html>