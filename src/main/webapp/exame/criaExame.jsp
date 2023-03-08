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
<%-- 			<c:property value="exame"/> do id <c:property value="id"/> --%>
			<form action="adicionaExame">
				<div>
					<label for="descricao">Descrição</label>
					<input type="text" name="descricao" id="descricao" required>	
				</div>
				<br>
				<div>
					<label for="id">Data</label>
					<input type="text" name="data" id="data" required>		
				</div>
				<br>
				<div>
					<button type="submit">Criar</button>
				</div>
			</form>
</body>
</html>