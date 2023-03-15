<%@ taglib prefix="c" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Editar Funcionário</title>
</head>
<body class="forms">
	<div class="content">
		<form action="editaFuncionario">
			<div class="border">
				<div>
					Id do Funcionário: <input type="text" name="id" id="id"
						value="${funcionario.id}" class="input" readonly required>
				</div>
				<div>
					Nome: <input type="text" name="nome" id="nome"
						value="${funcionario.nome}" class="input" required>
				</div>
				<div>
					<input type="submit" value="Atualizar" class="btn">
				</div>
			</div>
		</form>
	</div>
	<div class="back">
		<a href="funcionarios" class="btnBack">Voltar</a>
	</div>
</body>
</html>