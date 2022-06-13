package br.com.djb.model;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.djb.dto.CarteiraDto;
import br.com.djb.score.ScoreRange;

@Entity
@Table(name="CARTEIRA")
public class Carteira implements Serializable {

	private static final long serialVersionUID = 6364914908615008124L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARTEIRA")
	private Long idCarteira;
	@Column(name = "LIMITE_CE")
	private Double limiteCE;
	@Column(name = "LIMITE_CC")
	private Double limiteCC;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CONTA")
	private ContaCorrente contaCorrente;
	
	public Carteira() {
	}
	
	public Carteira(Pessoa pessoa, ContaCorrente contaCorrente) {
		Optional<ScoreRange> scoreRange = ScoreRange.filter(pessoa);
		if(scoreRange.isPresent()){
			this.limiteCE = scoreRange.get().getCarteira().getCE();
			this.limiteCC = scoreRange.get().getCarteira().getCC();
		}
		this.contaCorrente = contaCorrente;
	}

	public CarteiraDto converterDto() {
		CarteiraDto carteiraDto = new CarteiraDto();
		carteiraDto.setIdCarteira(this.idCarteira);
		carteiraDto.setLimiteCE(this.limiteCE);
		carteiraDto.setLimiteCC(this.limiteCC);;
        return carteiraDto;
    }
	
	public Long getIdCarteira() {
		return idCarteira;
	}
	public void setIdCarteira(Long idCarteira) {
		this.idCarteira = idCarteira;
	}
	public Double getLimiteCE() {
		return limiteCE;
	}
	public void setLimiteCE(Double limiteCE) {
		this.limiteCE = limiteCE;
	}
	public Double getLimiteCC() {
		return limiteCC;
	}
	public void setLimiteCC(Double limiteCC) {
		this.limiteCC = limiteCC;
	}
	public ContaCorrente getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
}
