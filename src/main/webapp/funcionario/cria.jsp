<%@ taglib prefix="c" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Criar Funcionário</title>
</head>
<body class="forms">
	<div class="content">
		<form action="adicionaFuncionario" method="post" class="form">
			<div class="border">
				<div>
					Nome do Funcionário: <input type="text" name="nome" id="nome"
						class="input" required>
				</div>
				<div>
					<button type="submit" class="btn">Criar</button>
				</div>
			</div>
		</form>
	</div>
	<div class="back">
		<a href="funcionarios" class="btnBack">Voltar</a>
	</div>
</body>
</html>