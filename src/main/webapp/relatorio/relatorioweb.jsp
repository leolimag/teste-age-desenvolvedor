<%@ taglib prefix="s"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Relatório - HTML</title>
</head>
<body>
	<h2>Relatório</h2>
	<table>
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
					<td>${exame.idFuncionario}</td>
					<td>${exame.nomeFuncionario}</td>
					<td>${exame.idExame}</td>
					<td>${exame.nomeExame}</td>
					<td>${exame.data}</td>
				</tr>
			</tbody>
		</s:forEach>
	</table>
	<br>
	<a href="relatorio">Voltar</a>
</body>
</html>