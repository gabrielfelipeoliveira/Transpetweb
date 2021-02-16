<%@ page language="java" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Veículo Motorista</title>
</head>
<body>

<%@ include file="cabecalho-motorista.jsp" %>

<h1>Insira os dados para cadastrar seu Veículo e seu Dono!</h1>
		
		
	<form id="formProcurarCorrida" action="<%=request.getContextPath()%>/cadastrar-veiculo-motorista">
		<label >Motorista</label> <br> 
		<select	name="idMotorista">

				<c:forEach var="motorista" items="${motoristas}">
				<option value="${motorista.idUsuario}">
					${motorista.nomeUsuario} ${motorista.sobreNomeUsuario}</option>
			</c:forEach>
			
		</select><br>
			
		
		
			<h3>Veículo</h3>
			<fieldset>
			<label >Marca</label><br>
			<input type ="text" id="marcaVeiculoMotoristaIns" name="marcaVeiculoMotoristaIns" maxlength ="25" required><br>
			
			<label >Modelo</label><br>
			<input type ="text" id="modeloVeiculoMotoristaIns" name="modeloVeiculoMotoristaIns" maxlength ="35" required><br>
			
			<label >Placa</label><br>
			<input type ="text" id="placaVeiculoMotoristaIns" name ="placaVeiculoMotoristaIns" maxlength ="7" required><br>
			
			<label >Ano</label><br>
			<input type ="text" id="anoVeiculoMotoristaIns" name="anoVeiculoMotoristaIns" maxlength ="4"  required><br><br>
			</fieldset>
			<input type ="submit" value="Cadastrar Veículo" id="botaoInsVeiculoMotorista">
			
		</form>
		

</body>
</html>