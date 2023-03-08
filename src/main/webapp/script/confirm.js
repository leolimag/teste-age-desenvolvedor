function confirmador(id) {
	let answer = confirm("Deseja realmente excluir este exame?");
	if(answer === true){
		window.location.href = "deletaExame?id=" + id;
	}
}