<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exames</title>
<script type="text/javascript" src="script/confirm.js"></script>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<s:import url="/template/template.jsp"></s:import>
	<div class="page-title">
		<h1>Exames</h1>
		<a href="criaExame" class="add-btn">Adicionar Exame</a>
	</div>
	<s:choose>
		<s:when test="${numeroExames  == 0}">
			<h2 class="empty">Não há exames disponíveis.</h2>
		</s:when>
		<s:when test="${numeroExames  > 0}">
			<div class="div-table">
				<table class="table-container">
					<tbody>
						<s:forEach items="${exames}" var="exame">
							<tr>
								<td class="title-td">${exame.nome}</td>
								<td class="edit"><a href="selecionaExame?id=${exame.id }"
									class="edit-btn"> Editar </a></td>
								<td class="delete"><a
									onclick="confirmadorExame(${exame.id })" href="#"
									class="delete-btn"> Deletar </a></td>
							</tr>
						</s:forEach>
					</tbody>
				</table>
			</div>
		</s:when>
	</s:choose>
	<div id="verify">
		<a href="examesMaisRealizados?dataInicial=2000-01-01&dataFinal=2222-12-31" class="verify-btn">Verificar Exames mais Realizados</a>
	</div>
</body>
</html>