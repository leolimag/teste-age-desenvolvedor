<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatório - HTML</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="div-table">
		<table id="table-container">
			<thead>
				<tr>
					<th>Id do Funcionário</th>
					<th>Funcionário</th>
					<th>Id do Exame</th>
					<th>Exame</th>
					<th>Data</th>
				</tr>
			</thead>
			<s:forEach items="${exameFuncionarios}" var="exame">
				<tbody>
					<tr>
						<td class="title-td">${exame.idFuncionario}</td>
						<td class="title-td">${exame.nomeFuncionario}</td>
						<td class="title-td">${exame.idExame}</td>
						<td class="title-td">${exame.nomeExame}</td>
						<td class="title-td">${exame.data}</td>
					</tr>
				</tbody>
			</s:forEach>
		</table>
		<div class="back">
			<a href="relatorio" class="btnBackRel">Voltar</a>
		</div>
	</div>
</body>
</html>