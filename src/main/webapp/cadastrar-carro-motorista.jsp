<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Veículo Motorista</title>
</head>
<body>


<h1>Insira os dados para cadastrar seu Veículo e seu Dono!</h1>
		
		<form action="">
		<label for = "selectMotoristaIns">Motoristas Cadastrados</label><br>
			<select name="selectMotoristaIns">  
			 <option value="">..</option>
    <c:forEach var="motoristas" items="${motorista}">
     </c:forEach>
			</select><br>
		</form>
		
		
		
		<form action="" hidden>
			<h3>Veículo</h3>
			<label for="marcaVeiculoMotoristaIns">Marca</label><br>
			<input type ="text" id="marcaVeiculoMotoristaIns" name="marcaVeiculoMotoristaIns" maxlength ="25" required><br>
			
			<label for="modeloVeiculoMotoristaIns">Modelo</label><br>
			<input type ="text" id="modeloVeiculoMotoristaIns" name="modeloVeiculoMotoristaIns" maxlength ="35" required><br>
			
			<label for="placaVeiculoMotoristaIns">Placa</label><br>
			<input type ="text" id="placaVeiculoMotoristaIns" name ="placaVeiculoMotoristaIns" maxlength ="7" required><br>
			
			<label for="anoVeiculoMotoristaIns">Ano</label><br>
			<input type ="text" id="anoVeiculoMotoristaIns" name="anoVeiculoMotoristaIns" maxlength ="4"  required><br><br>
			
			<input type ="submit" value="Cadastrar Veículo" id="botaoInsVeiculoMotorista">
			
		</form>
		

</body>
</html>