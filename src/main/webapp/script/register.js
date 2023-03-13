/**
 *  Validando a data
 */

function register() {
	const date = new Date();
	const dateForm = document.getElementById("data").valueAsDate;

	day = date.getDate();
	month = date.getMonth() + 1;
	year = date.getFullYear();

	let dayForm = dateForm.getUTCDate();
	let monthForm = dateForm.getUTCMonth() + 1; 
	let yearForm = dateForm.getUTCFullYear();
	
	if(yearForm > year ){
		alert("Data inválida. Insira uma data anterior ou correspondente ao dia de hoje.");
		registry.data.focus();
		return false;
	} else if (yearForm == year && monthForm > month){
		alert("Data inválida. Insira uma data anterior ou correspondente ao dia de hoje.");
		registry.data.focus();
		return false;
	} else if (monthForm == month && dayForm > day){
		alert("Data inválida. Insira uma data anterior ou correspondente ao dia de hoje.");
		registry.data.focus();
		return false;
	} else {
		document.forms['registry'].submit();
	} 
	
}
