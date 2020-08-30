package br.com.djb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarPessoaDto {
	
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("tipo")
	private String tipo;
	@JsonProperty("numDocumento")
	private String numDocumento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

}
