package br.com.djb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PessoaDto {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY, value="idPessoa")
    private Long idPessoa;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("numDocumento")
    private String numDocumento;
    @JsonProperty("score")
    private Integer score;
    
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
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
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
