<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatório</title>
<script type="text/javascript" src="script/report.js"></script>
</head>
<body>
	<s:import url="/template/template.jsp"></s:import>
	<h1>Relatório</h1>
	<form action="gerarRelatorio" name="form">
		Filtre por um período (Caso queira todos os registros, deixe os campos vazios):
		<br>
		<br>
		<div>
			Data inicial: <input type="date" name="dataInicial" id="dataInicial">
			Data final: <input type="date" name="dataFinal"  id="dataFinal">
		</div>
		<br>
		<div>
			<input type="button" value="Gerar Relatório" onclick="report()">
				<select name="tipo" id="relatorio">
				<option value="pdf">PDF</option>
				<option value="html">Página web (HTML)</option>
				<option value="excel">Excel</option>
			</select>
		</div>
	</form>
</body>
</html>