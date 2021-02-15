<%@ page language="java" 
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cabeçalho Tutor</title>
</head>
<body>

<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}


.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}


.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: gray;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: white;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
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