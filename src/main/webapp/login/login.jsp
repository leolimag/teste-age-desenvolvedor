<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Login</title>
</head>
<body class="forms">
	<div class="content">
	    <div id="borderLogin">
	    <h1 class="login">Login</h1>
	      <form class="form" name="form" action="login" method="post">
	      	<div>
	      		E-mail: <input class="input" type="email" name="email" required>
	      	</div>
	      	<div>
	      		Senha: <input class="input" type="password"  name="senha" required>
	      	</div>
	          <div>
	            <input class="btn" type="submit" value="Enviar">
	          </div>  
	        </form>
	    </div>
  </div>
  	<div class="back">
		<a href="cadastro" class="btnBack">Cadastre-se</a>
	</div>
</body>
</html>