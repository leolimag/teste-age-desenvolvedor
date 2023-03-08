<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exames dos Funcionários</title>
<script type="text/javascript" src="script/confirm.js"></script>
</head>
<body>
	<header>
	<a href="exames">Exames</a> <!-- <a href="">Meus Exames</a> --> <a href="funcionarios">Funcionários</a> <a href="examesFuncionarios">Exames dos Funcionários</a>
	</header>
	<h1>Exames</h1>
	<a href="criaExame">Adicionar Exame</a>
	<br>
	<div>
		<s:forEach items="${exames}" var="exame">
			<p>${exame.descricao}<a href="selecionaExame?id=${exame.id }"> Editar </a> <a onclick="confirmadorExame(${exame.id })" href="#"> Deletar </a> </p> 
		</s:forEach>
	</div>
</body>
</html>