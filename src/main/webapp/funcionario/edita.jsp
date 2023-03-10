<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Funcionário</title>
</head>
<body>
			<form action="editaFuncionario?id=${funcionario.id }">
				<div>
					<label for="id">Id</label>
					<input type="text" name="id" id="id" value="${funcionario.id}" readonly required>		
				</div>
				<br>
				<div>
					<label for="nome">Nome</label>
					<input type="text" name="nome" id="nome" value="${funcionario.nome}"  required>	
				</div>
				<br>
				<div>
					<input type="submit" value="Atualizar">
				</div>
			</form>
</body>
</html>