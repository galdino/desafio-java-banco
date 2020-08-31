package br.com.djb.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContaCorrenteDto {
	
	@JsonProperty(access = JsonProperty.Access.READ_ONLY, value="idConta")
    private Long idConta;
    @JsonProperty("numero")
    private Integer numero;
    @JsonProperty("agencia")
    private Integer agencia;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("idPessoa")
    private Long idPessoa;
    @JsonProperty("carteiras")
	private List<CarteiraDto> carteiras;
    
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public List<CarteiraDto> getCarteiras() {
		return carteiras;
	}
	public void setCarteiras(List<CarteiraDto> carteiras) {
		this.carteiras = carteiras;
	}
}
