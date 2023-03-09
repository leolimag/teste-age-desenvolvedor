/**
 *  Criando "confirms" para os inserts
 */

function confirmadorExame(id) {
	let answer = confirm("Deseja realmente excluir este exame?");
	if (answer === true) {
		window.location.href = "deletaExame?id=" + id;
	}
}

function confirmadorFuncionario(id) {
	let answer = confirm("Deseja realmente excluir este funcionário?");
	if (answer === true) {
		window.location.href = "deletaFuncionario?id=" + id;
	}
}
