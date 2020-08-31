package br.com.djb.score;

public class ScoreFaixaUm implements CarteiraValues {

	private Double chequeEspecial = 0.00;
	private Double cartaoCredito = 0.00;

	@Override
	public Double getCE() {
		return chequeEspecial;
	}

	@Override
	public Double getCC() {
		return cartaoCredito;
	}

}
