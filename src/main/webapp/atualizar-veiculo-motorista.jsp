<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Veículo Motorista</title>
</head>
<body>


<%@ include file="cabecalho-motorista.jsp" %>

	<h1>Insira os dados para atualizar seu Veículo!</h1>
		
		<form action="veiculo-motorista" method="post">
		
		<label for="selectVeiculoMotoristaAtu">Tutor</label>
	<select id="selectVeiculoMotoristaAtu" name="selectVeiculosMotoristaAtu">
	 <option value="">..</option>
    <c:forEach var="veiculos" items="${veiculo}">
        <option value= "${veiculo.marca}
           				${veiculo.modelo}">
            			
            			
        </option>
     </c:forEach>
	</select><br>
		</form> 
	
			<h3>Veículo</h3>
			
			<form action="atualizar-veiculo-motorista" method="post">
			<fieldset>
			<label for="marcaVeiculoMotoristaAtu">Marca</label><br>
			<input type ="text" id="marcaVeiculoMotoristaAtu" name="marcaVeiculoMotoristaAtu" value="" maxlength ="25" required><br>
			</fieldset>
			
			<fieldset>
			<label for="modeloVeiculoMotoristaAtu">Modelo</label><br>
			<input type ="text" id="modeloVeiculoMotoristaAtu" name="modeloVeiculoMotoristaAtu" value="" maxlength ="35" required><br>
			</fieldset>
			
			<fieldset>
			<label for="placaVeiculoMotoristaAtu">Placa</label><br>
			<input type ="text" id="placaVeiculoMotoristaAtu" name ="placaVeiculoMotoristaAtu" value="" maxlength ="7" required><br>
			${veiculo.placa}
			</fieldset>
			
			<fieldset>
			<label for="anoVeiculoMotoristaAtu">Ano</label><br>
			<input type ="text" id="anoVeiculoMotoristaAtu" name="anoVeiculoMotoristaAtu" value="" maxlength ="4" required><br><br>
			${veiculo.ano}
			</fieldset>
			
			<input type ="submit" value="Atualizar Veículo" id="botaoAtuaVeiculoMotorista">
			
		</form>

</body>
</html>