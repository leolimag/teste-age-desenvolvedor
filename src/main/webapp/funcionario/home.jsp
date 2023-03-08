<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<script type="text/javascript" src="script/confirm.js"></script>
</head>
<body>
	<header>
	<a href="exames">Exames</a> <!-- <a href="">Meus Exames</a> --> <a href="funcionarios">Funcionários</a> 
	</header>
	<h1>Funcionários</h1>
	<a href="criaExame">Adicionar Funcionário</a>
	<br>
	<div>
<%-- 		<c:property value="exames"/> --%>
		<s:forEach items="${funcionarios}" var="funcionario">
			<p>${funcionario.nome}<a href="selecionaFuncionario?id=${funcionario.id }"> Editar </a> <a onclick="confirmador(${funcionario.id })" href="#"> Deletar </a> </p> 
		</s:forEach>
	</div>
</body>
</html>