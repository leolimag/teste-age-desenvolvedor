<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Exame</title>
<script src="script/register.js"></script>
</head>
<body>
			<form action="editaRegistro" id="form" name="registry">
				<div>
					<label for="idExame">Id do Exame</label>
					<input type="text" name="idExame" id="idExame" value="${idExame}" readonly>		
				</div>
				<br>
				<div>
					<label for="idFuncionario">Id do Funcionário</label>
					<input type="text" name="idFuncionario" id="idFuncionario" value="${idFuncionario}"  readonly>	
				</div>
				<br>
				<div>
					<label for="data">Data</label>
					<input type="date" name="data" id="data" value="${data}"  required>		
				</div>
				<br>
				<div>
					<input type="submit" value="Atualizar" onclick="register()">
				</div>
			</form>
</body>
</html>