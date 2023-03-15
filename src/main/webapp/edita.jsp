<%@ taglib prefix="c" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Editar Exame</title>
<script src="script/register.js"></script>
</head>
<body class="forms">
	<div class="content">
		<form action="editaRegistro" id="form" name="registry">
			<div class="border">
				<div>
					Id do Exame: <input type="text" name="idExame" class="input" id="idExame" value="${idExame}" readonly>
				</div>
				<div>
					Id do Funcionário: <input type="text" name="idFuncionario" class="input" id="idFuncionario" value="${idFuncionario}" readonly>
				</div>
				<div>
					Data: <input type="date" name="data" id="data" class="input" value="${data}" required>
				</div>
				<input hidden type="text" name="dataAntiga" value="${data}" required>
				<div>
					<input type="button" value="Atualizar" class="btn" onclick="register()">
				</div>
			</div>
		</form>
	</div>
	<div class="back">
		<a href="examesFuncionarios" class="btnBack">Voltar</a>
	</div>
</body>
</html>