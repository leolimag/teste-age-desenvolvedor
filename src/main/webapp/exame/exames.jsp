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
	<div class="page-title">
		<h1>Exames dos Funcionários</h1>
		<a href="listaExamesFuncionarios" class="add-btn">Registrar Exame</a>
	</div>
	<div class="div-table">
		<table class="table-container">
			<thead class="theader">
				<tr>
					<th class="title-td">Funcionário</th>
					<th class="title-td">Exame</th>
					<th class="title-td">Data</th>
				</tr>
			</thead>
			<tbody>
				<s:forEach items="${exameFuncionarios}" var="exame">
					<tr>
						<td class="title-td">${exame.nomeFuncionario}</td>
						<td class="title-td">${exame.nomeExame}</td>
						<td class="title-td"> ${exame.data}</td>
						<td><a href="selecionaRegistro?idExame=${exame.idExame}&idFuncionario=${exame.idFuncionario}&data=${exame.data}" class="edit-btn"> Editar </a></td>
						<td><a onclick="confirmadorRegistro(${exame.idExame }, ${exame.idFuncionario}, '${exame.data }')" href="#" class="delete-btn-ef"> Deletar </a></td>
					</tr>
				</s:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>