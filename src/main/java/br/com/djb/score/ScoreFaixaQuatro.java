package br.com.djb.score;

public class ScoreFaixaQuatro implements CarteiraValues {

	private Double chequeEspecial = 5000.00;
	private Double cartaoCredito = 15000.00;

	@Override
	public Double getCE() {
		return chequeEspecial;
	}

	@Override
	public Double getCC() {
		return cartaoCredito;
	}
}
