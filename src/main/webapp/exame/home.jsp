<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exames</title>
<script type="text/javascript" src="script/confirm.js"></script>
</head>
<body>
	<s:import url="/template/template.jsp"></s:import>
	<h1>Exames</h1>
	<a href="criaExame">Adicionar Exame</a>
	<br>
	<div>
		<s:forEach items="${exames}" var="exame">
			<p>${exame.nome}<a href="selecionaExame?id=${exame.id }"> Editar </a> <a onclick="confirmadorExame(${exame.id })" href="#"> Deletar </a> </p> 
		</s:forEach>
	</div>
</body>
</html>