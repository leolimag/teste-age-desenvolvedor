/**
 * Validando o campo para inserir o ano no relatório
 */
 
 function report() { 
	 const date = new Date();
	 const initialDate = document.getElementById("dataInicial").valueAsDate;
	 const finalDate = document.getElementById("dataFinal").valueAsDate;
	 
	 if (initialDate != null){
		 var initialYear = initialDate.getUTCFullYear();
		 var initialMonth = initialDate.getUTCMonth() + 1;
		 var initialDay = initialDate.getUTCDate();
	 }
	 
	 if (finalDate != null){
		 var finalYear = finalDate.getUTCFullYear();
		 var finalMonth = finalDate.getUTCMonth() + 1;
		 var finalDay = finalDate.getUTCDate();
	 }
	 
	 if (initialYear > date.getFullYear()){
		 alert("Ano inválido. Insira um ano anterior ou correspondente ao ano de " + date.getFullYear() + ".");
	 } else if (initialYear < 2000 && initialYear != 0) {
		 alert("Data inválida. Só há registros a partir no ano 2000.")
	 } else if (initialYear >= finalYear && finalYear > 0) {
		 alert("Data inválida. A data final deve ser maior que a data inicial.")
	 } else if (initialYear == finalYear && initialMonth > finalMonth) {
		 alert("Data inválida. A data final deve ser maior que a data inicial.")
	 } else if (initialYear == finalYear && initialMonth <= finalMonth && initialDay >= finalDay) {
		 alert("Data inválida. A data final deve ser maior que a data inicial.")
	 } else {
		 if (finalDate == null){
			document.getElementById("dataFinal").value = "2222-12-31";
		 }
		 if (initialDate == null){
			 document.getElementById("dataInicial").value = "2000-01-01";
		 }
		 document.forms['form'].submit();
	}
	
	document.getElementById("dataFinal").value = null;
	document.getElementById("dataInicial").value = null;
	
 }	
 
 