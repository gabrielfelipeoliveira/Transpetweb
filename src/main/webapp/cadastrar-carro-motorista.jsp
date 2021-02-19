<%@ page language="java" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Veículo Motorista</title>
<script><%@include file="\resources\js\metodos.js"%></script>
</head>
<body>

<%@ include file="cabecalho-motorista.jsp" %>
	<div class="formCadastro" >

		
		
	<form id="formProcurarCorrida" action="<%=request.getContextPath()%>/cadastrar-veiculo-motorista">
		
		
		  
		  
			<h3>Veículo</h3>
			
			<input type="hidden" value="${motoristas.idUsuario }" name="idMotorista">
			
			<label >Marca</label><br>
			<input type ="text" id="marcaVeiculoMotoristaIns" name="marcaVeiculoMotoristaIns" maxlength ="25" required><br>
			
			<label >Modelo</label><br>
			<input type ="text" id="modeloVeiculoMotoristaIns" name="modeloVeiculoMotoristaIns" maxlength ="35" required><br>
			
			<label >Placa</label><br>
			<input type ="text" id="placaVeiculoMotoristaIns" name ="placaVeiculoMotoristaIns" maxlength ="7" required><br>
			
			<label >Ano</label><br>
			<input type ="text" id="anoVeiculoMotoristaIns" pattern="[0-9]+$" name="anoVeiculoMotoristaIns" maxlength ="4"  required><br><br>
		
			<input type ="submit" value="Cadastrar Veículo" id="botaoInsVeiculoMotorista">
			
		</form>
		
</div>
</body>
</html>