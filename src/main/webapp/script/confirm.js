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
	let answer = confirm("Deseja realmente excluir este funcionário? Ao exclui-lo, também serão excluídos os exames realizados deste funcionário.");
	if (answer === true) {
		window.location.href = "deletaFuncionario?id=" + id;
	}
}

function confirmadorRegistro(idExame, idFuncionario, data) {
	let answer = confirm("Deseja realmente excluir este exame?");
	if (answer === true) {
		window.location.href = "deletaRegistro?idExame=" + idExame + "&idFuncionario=" + idFuncionario + "&data=" + data;
	}	
}

function confirmarLogout(){
	let answer = confirm("Deseja realmente sair do sistema?");
	if (answer === true){
		window.location.href = "logout";
	}
}