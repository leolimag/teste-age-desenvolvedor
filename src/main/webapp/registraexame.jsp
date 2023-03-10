<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar um Exame</title>
<script src="script/register.js"></script>
</head>
<body>
<h2>Registre o Exame de um Funcionário</h2>
<br>
<form action="registraExame" name="registry" id="form">
	<div>
		<label for="func">Qual funcionário realizou o exame?</label>
		<select name="funcionario" id="func">
			<s:forEach items="${funcionarios }" var="funcionario">
				<option value="${funcionario.id }">${funcionario.nome}</option>
			</s:forEach>
		</select>
	</div>
	<br>
	<div>
		<label for="exam">Qual exame foi realizado?</label>
		<select name="exame" id="exam">
			<s:forEach items="${exames }" var="exame">
				<option value="${exame.id }">${exame.descricao}</option>
			</s:forEach>
		</select>
	</div>
	<br>
	<label for="data">Qual a data do exame?</label>
	<input type="date" name="data" id="data" required>
	<br>
	<br>
	<input type="submit" value="Registrar" onclick="register()">
</form>



</body>
</html>