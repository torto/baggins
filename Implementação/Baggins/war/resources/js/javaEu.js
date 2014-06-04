$(document).ready(function() {
	$("#FROM\\:dinheiro").maskMoney({
		showSymbol : true,
		symbol : "R$",
		decimal : ",",
		thousands : "."
	});
});