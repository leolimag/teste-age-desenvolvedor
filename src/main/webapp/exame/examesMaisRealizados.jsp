<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="script/report.js"></script>
<title>Exames mais Realizados</title>
</head>
<body>
	<s:import url="/template/template.jsp"></s:import>
	<div id="date">
		<strong>Filtre por Data: </strong>
		<br>
		<form action="examesMaisRealizados" name="form">
			<strong>Data inicial: </strong> <input type="date" name="dataInicial" class="input" id="dataInicial"> 
			<strong>Data final: </strong> <input type="date" name="dataFinal" class="input" id="dataFinal">
			<input type="button" class="btnUpdate" value="Atualizar" onclick="report()">
		</form>
	</div>
	<div class="div-table">
		<table class="table-container">
			<thead class="theader">
				<tr>
					<th class="title-td">Exame</th>
					<th>Quantidade</th>
				</tr>
			</thead>
			<tbody>
				<s:forEach items="${exameFuncionarios}" var="exame">
					<tr>
						<td class="title-td">${exame.nomeExame}</td>
						<td class="title-td">${exame.quantidade}</td>
					</tr>
				</s:forEach>
			</tbody>
		</table>
	</div>
	<div class="back">
		<a href="exames" class="btnBack">Voltar</a>
	</div>
</body>
</html>