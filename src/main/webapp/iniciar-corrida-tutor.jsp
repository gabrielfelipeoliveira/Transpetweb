<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="<%=request.getContextPath()%>resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>resources/css/estilo.css"/>
<meta charset="ISO-8859-1">
<title>Solicitar Corrida</title>
</head>
<body>

	<%@ include file="cabecalho-tutor.jsp"%>

	
	
	<h1>Iniciar Corrida</h1><br>
	
	<c:if test="${tutores!=null }">
	<div class="formCadastro" >
		<h3>Selecione o tutor</h3>
		
		<form action="<%=request.getContextPath()%>/iniciar-corrida-tutor">
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


	<div class="formCadastro" >
	<c:if test="${tutor!=null }">
	<h3>Insira os dados para iniciar a corrida</h3>
		<form action="<%=request.getContextPath()%>/iniciar-corrida-tutor-ins">
			
			<input type="hidden" id="idTutorIns" name="idTutorIns" value="${tutor.idUsuario }" >

			
				<label >Endereço Inicial</label><br>
				<select name="idEnderecoInicial">
					<c:forEach var="endereco" items="${enderecos}">
						<option value="${endereco.idEndereco}">${endereco.ruaEndereco}
							${endereco.numeroEndereco}</option>
					</c:forEach>
				</select><br>
			
				<label >Endereço Final</label><br> <select
					name="idEnderecoFinal">
					<c:forEach var="endereco" items="${enderecos}">
						<option value="${endereco.idEndereco}">${endereco.ruaEndereco}
							${endereco.numeroEndereco}</option>
					</c:forEach>
				</select><br>
			
				<label >Escolha seu pet</label><br> <select
					name="idAnimal">
					<c:forEach var="animal" items="${animais}">
						<option value="${animal.idAnimal}">${animal.nomeAnimal}
							${animal.raca}</option>
					</c:forEach>
				</select><br> <br>
			

			<input type="submit" value="Solicitar">
		</form>
	</c:if>
</div>
</body>
</html>