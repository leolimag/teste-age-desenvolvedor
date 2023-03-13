<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Exame</title>
</head>
<body>
			<form action="editaExame">
				<div>
					<label for="id">Id</label>
					<input type="text" name="id" id="id" value="${exame.id}" readonly>		
				</div>
				<br>
				<div>
					<label for="nome">Nome</label>
					<input type="text" name="nome" id="nome" value="${exame.nome}"  required>	
				</div>
				<br>
				<div>
					<input type="submit" value="Atualizar">
				</div>
			</form>
</body>
</html>