<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exames dos Funcionários</title>
<script src="script/confirm.js"></script>
</head>
<body>
	<s:import url="/template/template.jsp"></s:import>
	<h1>Exames dos Funcionários</h1>
	<a href="listaExamesFuncionarios">Registrar Exame</a>
	<div>
		<s:forEach items="${exameFuncionarios}" var="exame">
			<p> ${exame.nomeFuncionario} - ${exame.nomeExame} - ${exame.data}<a href="selecionaRegistro?idExame=${exame.idExame}&idFuncionario=${exame.idFuncionario}&data=${exame.data}"> Editar </a> <a onclick="confirmadorRegistro(${exame.idExame }, ${exame.idFuncionario}, '${exame.data }')" href="#"> Deletar </a> </p> 
		</s:forEach>
	</div>
</body>
</html>