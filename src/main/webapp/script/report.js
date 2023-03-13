/**
 * Validando o campo para inserir o ano no relatório
 */
 
 function report() { 
	 const date = new Date();
	 let initialYear = document.getElementById("anoInicial").value;
	 let finalYear = document.getElementById("anoFinal").value;
	 if (initialYear > date.getFullYear()){
		 alert("Ano inválido. Insira um ano anterior ou correspondente ao ano de " + date.getFullYear() + ".");
	 } else if (initialYear < 2000 && initialYear != 0) {
		 alert("Data inválida. Só há registros a partir no ano 2000.")
	 } else if (initialYear >= finalYear && finalYear > 0) {
		 alert("Data inválida. A data final deve ser maior que a data inicial.")
	 } else {
		 document.forms['form'].submit();
	}
 }	
 
 