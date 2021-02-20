

function mascaraCel() {

	var celular = document.getElementById('txtCel').value;
	if (celular.length == 1) {
		document.getElementById('txtCel').value = '(' + celular;
	}
	else if (celular.length == 3) {
		document.getElementById('txtCel').value = celular + ')';
	}
	else if (celular.length == 9) {
		document.getElementById('txtCel').value = celular + '-';
	}
}


function mascaraCpf() {
	var cpf = document.getElementById('txtCpf').value;
	if (cpf.length == 3) {
		document.getElementById('txtCpf').value = cpf + '.';
	}
	else if (cpf.length == 7) {
		document.getElementById('txtCpf').value = cpf + '.';
	}
	else if (cpf.length == 11) {
		document.getElementById('txtCpf').value = cpf + '-';
	}
}

function mascaraCep() {
	var cep = document.getElementById('txtCep').value;
	if (cep.length == 5) {
		document.getElementById('txtCep').value = cep + '-';
	}
}