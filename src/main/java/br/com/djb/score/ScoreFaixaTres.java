package br.com.djb.score;

public class ScoreFaixaTres implements CarteiraValues {

	private Double chequeEspecial = 2000.00;
	private Double cartaoCredito = 2000.00;

	@Override
	public Double getCE() {
		return chequeEspecial;
	}

	@Override
	public Double getCC() {
		return cartaoCredito;
	}
}
