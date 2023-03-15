<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Página de Erro</title>
</head>
<body>
	<div class="error">
		<h2 class="h-error"><s:property value="mensagem"></s:property></h2>
		<div class="back">
			<a href="exames" class="btnBack">Voltar</a>
		</div>
	</div>
</body>
</html>