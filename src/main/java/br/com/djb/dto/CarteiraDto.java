package br.com.djb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarteiraDto {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY, value="idCarteira")
	private Long idCarteira;
	@JsonProperty("limiteCE")
	private Double limiteCE;
	@JsonProperty("limiteCC")
	private Double limiteCC;
	
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
}
