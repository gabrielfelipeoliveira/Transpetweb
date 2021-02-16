<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cabeçalho Tutor</title>
</head>

    <link rel="stylesheet" href="<%=request.getContextPath()%>resources/css/estilo.css"/>
        <style><%@include file="\resources\css\estilo.css"%></style>

</head>
<body>

<div class="navbar">

  <div class="dropdown">
    <button class="dropbtn">DADOS 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="<%=request.getContextPath()%>/dados-tutor">Atualizar</a>
    </div>
  </div>
  
   <div class="dropdown">
    <button class="dropbtn">ANIMAL 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="<%=request.getContextPath()%>/cadastrar-animal">Cadastrar</a>
      <a href="<%=request.getContextPath()%>/atualizar-animal">Atualizar</a>
      <a href="<%=request.getContextPath()%>/deletar-animal">Deletar</a>
      <a href="<%=request.getContextPath()%>/listar-animal">Listar</a>
    </div>
  </div>
  
  <div class="dropdown">
    <button class="dropbtn">ENDEREÇO 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="<%=request.getContextPath()%>/endereco-tutor">Cadastrar</a>
      <a href="<%=request.getContextPath()%>/atualizar-endereco">Atualizar</a>
      <a href="<%=request.getContextPath()%>/deletar-endereco">Deletar</a>
      <a href="<%=request.getContextPath()%>/listar-endereco">Listar</a>
    </div>
  </div>
  
   <div class="dropdown">
    <button class="dropbtn">CORRIDA 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="<%=request.getContextPath()%>/iniciar-corrida">Iniciar</a>
      <a href="<%=request.getContextPath()%>/atualizar-corrida">Editar</a>
      <a href="<%=request.getContextPath()%>/deletar-corrida">Deletar</a>
      <a href="<%=request.getContextPath()%>/corrida-tutor">Listar</a>
      
    </div>
  </div> 
</div>


</body>
</html>