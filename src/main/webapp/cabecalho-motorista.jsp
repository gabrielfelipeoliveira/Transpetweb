<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cabe�alho Motorista</title>
</head>
<body>



<link rel="stylesheet" href="<%=request.getContextPath()%>resources/css/estilo.css"/>
        <style><%@include file="\resources\css\estilo.css"%></style>
</head>
<body>

<div class="navbar">

  <div class="dropdown">
    <button class="dropbtn">${usuario.nomeUsuario}  
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="<%=request.getContextPath()%>/atualizar-dados-motorista">Atualizar dados</a>
       <a href="<%=request.getContextPath()%>/deslogar">Sair</a>
    </div>
  </div>
  
   <div class="dropdown">
    <button class="dropbtn">VEICULO
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="<%=request.getContextPath()%>/cadastrar-veiculo">Cadastrar</a>
      <a href="<%=request.getContextPath()%>/atualizar-veiculo-motorista">Atualizar</a>
      <a href="<%=request.getContextPath()%>/deletar-veiculo-motorista">Deletar</a>
      <a href="<%=request.getContextPath()%>/listar-veiculo-motorista">Listar</a>
    </div>
  </div>
  
   <div class="dropdown">
    <button class="dropbtn">CORRIDA 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="<%=request.getContextPath()%>/procurar-corrida-motorista">Procurar</a>
      <a href="<%=request.getContextPath()%>/listar-corridas-motoristas">Listar</a>
      
    </div>
  </div>
  
   
</div>

</body>
</html>