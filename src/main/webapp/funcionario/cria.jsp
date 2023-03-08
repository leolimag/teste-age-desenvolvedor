<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Criar Funcionário</title>
</head>
<body>
			<form action="adicionaFuncionario">
				<div>
					<label for="nome">nome</label>
					<input type="text" name="nome" id="nome" required>	
				</div>
				<br>
				<div>
					<button type="submit">Criar</button>
				</div>
			</form>
</body>
</html>