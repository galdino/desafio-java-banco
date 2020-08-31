package br.com.djb.score;

import java.util.Optional;
import java.util.stream.Stream;

import br.com.djb.model.Pessoa;

public enum ScoreRange implements Carteira {

	ZERO_E_UM(0, 1) {
		@Override
		public CarteiraValues getCarteira() {
			return new ScoreFaixaUm();
		}
	},
	DOIS_E_CINCO(2, 5) {
		@Override
		public CarteiraValues getCarteira() {
			return new ScoreFaixaDois();
		}
	},
	SEIS_E_OITO(6, 8) {
		@Override
		public CarteiraValues getCarteira() {
			return new ScoreFaixaTres();
		}
	},
	NOVE(9, 9) {
		@Override
		public CarteiraValues getCarteira() {
			return new ScoreFaixaQuatro();
		}
	};
	
	private Integer inicio;
	private Integer fim;

	ScoreRange(int i, int j) {
		this.inicio = i;
		this.fim = j;
	}

	public Integer getInicio() {
		return inicio;
	}

	public Integer getFim() {
		return fim;
	}

	public static Optional<ScoreRange> filter(Pessoa p) {
		return Stream.of(values())
					 .filter(s -> p.getScore() >= s.getInicio() && p.getScore() <= s.getFim())
					 .findAny();
	}

}
