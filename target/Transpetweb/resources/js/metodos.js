function mascara(i, t) {

	var v = i.value;

	if (isNaN(v[v.length - 1])) {
		i.value = v.substring(0, v.length - 1);
		return;
	}

	if (t == "data") {
		i.setAttribute("maxlength", "10");
		if (v.length == 2 || v.length == 5) i.value += "/";
	}

	if (t == "cpf") {
		i.setAttribute("maxlength", "14");
		if (v.length == 3 || v.length == 7) i.value += ".";
		if (v.length == 11) i.value += "-";
	}

	if (t == "cnpj") {
		i.setAttribute("maxlength", "18");
		if (v.length == 2 || v.length == 6) i.value += ".";
		if (v.length == 10) i.value += "/";
		if (v.length == 15) i.value += "-";
	}

	if (t == "cep") {
		i.setAttribute("maxlength", "9");
		if (v.length == 5) i.value += "-";
	}

	if (t == "tel") {


		if (v.length == 1) {
			i.value = '(' + i.value;
		}
		else if (v.length == 3) {
			i.value = i.value + ') ';
		}
		else if (v.length == 10) {
			i.value = i.value + '-';
		}

	}
	
}

function mascaraEmail(i, t){
	
	var v = i.value;
	if (t == 'email') {
		var email = i.value;
		if (email == "" || email.indexOf('@') == -1 || email.indexOf('.') == -1) {

			alert("Por favor Insira um E-mail valido");

		}

	}
}



