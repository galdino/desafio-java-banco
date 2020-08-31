package br.com.djb.score;

public class ScoreFaixaDois implements CarteiraValues {

	private Double chequeEspecial = 1000.00;
	private Double cartaoCredito = 200.00;

	@Override
	public Double getCE() {
		return chequeEspecial;
	}

	@Override
	public Double getCC() {
		return cartaoCredito;
	}
}
