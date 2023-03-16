/**
 *  Validando a data
 */

function register() {
	const date = new Date();
	const dateForm = document.getElementById("data").valueAsDate;

	day = date.getDate();
	month = date.getMonth() + 1;
	year = date.getFullYear();

	if (dateForm != null) {
		var dayForm = dateForm.getUTCDate();
		var monthForm = dateForm.getUTCMonth() + 1;
		var yearForm = dateForm.getUTCFullYear();
		if (yearForm > 2000) {
			if (yearForm > year) {
				alert("Data inválida. Insira uma data anterior ou correspondente ao dia de hoje.");
				registry.data.focus();
				return false;
			} else if (yearForm == year && monthForm > month) {
				alert("Data inválida. Insira uma data anterior ou correspondente ao dia de hoje.");
				registry.data.focus();
				return false;
			} else if (monthForm == month && dayForm > day) {
				alert("Data inválida. Insira uma data anterior ou correspondente ao dia de hoje.");
				registry.data.focus();
				return false;
			} else {
				document.forms['registry'].submit();
			}
		} else {
			alert("Data inválida. Não é possível registrar datas anteriores ao ano 2000.")
		}
	} else {
		alert("Insira uma data.")
	}

}

function checkPassword(){
	let password = document.getElementById("senha").value;
	let confPassword = document.getElementById("senhaConfirmada").value;
	if (password === confPassword){
		document.forms['form'].submit();
	} else {
		alert("Confirmação de senha incorreta. Tente Novamente.");
		form.senhaConfirmada.focus();
		form.senhaConfirmada.value = "";
	}
}
