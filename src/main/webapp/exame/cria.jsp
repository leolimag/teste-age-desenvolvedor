<%@ taglib prefix="c" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Criar Exame</title>
</head>
<body class="forms">
	<div class="content">
		<form action="adicionaExame" method="post" class="form">
			<div class="border">
				<div>
					Nome do Exame: <input type="text" name="nome" id="nome" class="input"  maxlength="40" required>
				</div>
				<div>
					<button type="submit" class="btn">Criar</button>
				</div>
			</div>
		</form>
	</div>
	<div class="back">
		<a href="exames" class="btnBack">Voltar</a>
	</div>
</body>
</html>