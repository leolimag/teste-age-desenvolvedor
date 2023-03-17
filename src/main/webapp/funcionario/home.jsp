<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="/struts-tags"%>
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
	<div class="page-title">
		<h1>Funcionários</h1>
		<a href="criaFuncionario" class="add-btn">Adicionar Funcionário</a>
	</div>
	<s:choose>
		<s:when test="${numeroFuncionarios  == 0}">
			<h2 class="empty">Não há funcionários disponíveis.</h2>
		</s:when>
		<s:when test="${numeroFuncionarios > 0}">
			<div class="div-table">
				<table class="table-container">
					<tbody>
						<s:forEach items="${funcionarios}" var="funcionario">
							<tr>
								<td class="title-td">${funcionario.nome}</td>
								<td class="edit"><a
									href="selecionaFuncionario?id=${funcionario.id }"
									class="edit-btn-ef"> Editar </a></td>
								<td class="delete"><a
									onclick="confirmadorFuncionario(${funcionario.id })" href="#"
									class="delete-btn"> Deletar </a></td>
							</tr>
						</s:forEach>
					</tbody>
				</table>
			</div>
		</s:when>
	</s:choose>
</body>
</html>