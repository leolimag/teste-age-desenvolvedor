<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatório</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="script/report.js"></script>
</head>
<body>
	<s:import url="/template/template.jsp"></s:import>
	<div class="page-title">
		<h1>Relatório</h1>
		<div>
			<input type="button" class="btnGen" value="Gerar Relatório"
				onclick="report()">
		</div>
	</div>
	<div class="div-table">
		<form action="gerarRelatorio" name="form">
			<h5>Filtre por um período (caso queira todos os registros, deixe
				os campos vazios):</h5>
			<div class="filter">
				<strong>Data inicial: </strong> <input type="date" name="dataInicial" class="input" id="dataInicial"> 
				<strong>Data final: </strong> <input type="date" name="dataFinal" class="input" id="dataFinal">
				<div class="filter-format">
					<strong>Escolha o formato: </strong> 
					<select name="tipo" id="relatorio" class="input" >
						<option value="pdf">PDF</option>
						<option value="html">Página web (HTML)</option>
					</select>
				</div>
			</div>
		</form>
	</div>
</body>
</html>