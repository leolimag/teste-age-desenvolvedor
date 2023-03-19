<%@ taglib prefix="c" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Editar Exame</title>
</head>
<body class="forms">
	<div class="content">
		<form action="editaExame" class="form">
			<div class="border">
				<div>
					Id: <input type="text" name="id" id="id" value="${exame.id}" class="input" readonly>
				</div>
				<div>
					Nome do Exame: <input type="text" name="nome" pattern="[a-zA-Z0-9]+" id="nome" value="${exame.nome}" class="input"  maxlength="40" required>
				</div>
				<div>
					<input type="submit" value="Atualizar" class="btn">
				</div>
			</div>
		</form>
	</div>
	<div class="back">
		<a href="exames" class="btnBack">Voltar</a>
	</div>
</body>
</html>