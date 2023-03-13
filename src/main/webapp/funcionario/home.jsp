<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Funcionários</title>
<script type="text/javascript" src="script/confirm.js"></script>
</head>
<body>
	<s:import url="/template/template.jsp"></s:import>
	<h1>Funcionários</h1>
	<a href="criaFuncionario">Adicionar Funcionário</a>
	<br>
	<div>
<%-- 		<c:property value="exames"/> --%>
		<s:forEach items="${funcionarios}" var="funcionario">
			<p>${funcionario.nome}<a href="selecionaFuncionario?id=${funcionario.id }"> Editar </a> <a onclick="confirmadorFuncionario(${funcionario.id })" href="#"> Deletar </a></p> 
		</s:forEach>
	</div>
</body>
</html>