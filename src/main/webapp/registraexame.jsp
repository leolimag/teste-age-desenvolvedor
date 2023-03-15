<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Registrar um Exame</title>
<script src="script/register.js"></script>
</head>
<body class="forms">
	<div class="content">
		<form action="registraExame" name="registry" id="form" class="form">
			<div class="border">
				<div>
					Qual funcionário realizou o exame? 
					<select name="funcionario" id="func" class="input">
						<s:forEach items="${funcionarios }" var="funcionario">
							<option value="${funcionario.id }">${funcionario.nome}</option>
						</s:forEach>
					</select>
				</div>
				<div>
					Qual exame foi realizado? 
					<select name="exame" id="exam" class="input">
						<s:forEach items="${exames }" var="exame">
							<option value="${exame.id }">${exame.nome}</option>
						</s:forEach>
					</select>
				</div>
				<div>
					Qual a data do exame? <input type="date" name="data" id="data" class="input" required>
				</div>
				<div>
					<input type="button" value="Registrar" onclick="register()" class="btn">
				</div>
			</div>
		</form>
	</div>
	<div class="back">
		<a href="examesFuncionarios" class="btnBack">Voltar</a>
	</div>
</body>
</html>