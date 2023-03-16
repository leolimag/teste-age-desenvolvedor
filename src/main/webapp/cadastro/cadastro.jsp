<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="script/register.js"></script>
<title>Login</title>
</head>
<body class="forms">
	<div class="content">
	    <div id="borderLogin">
	    <h1 class="login">Cadastro</h1>
	      <form class="form" name="form" action="criaUsuario" method="post">
	      	<div>
	      		E-mail: <input class="input" type="email" name="email" required>
	      	</div>
	      	<div>
	      		Senha: <input class="input" type="password"  name="senha" id="senha" required>
	      	</div>
	      	<div>
	      		Confirme sua senha: <input class="input" type="password" id="senhaConfirmada" required>
	      	</div>
	          <div>
	            <input class="btn" type="button" value="Enviar" onclick="checkPassword()">
	          </div>  
	        </form>
	    </div>
  </div>
</body>
</html>