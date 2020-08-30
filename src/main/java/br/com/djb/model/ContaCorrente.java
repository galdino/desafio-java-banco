package br.com.djb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.djb.dto.ContaCorrenteDto;
import br.com.djb.util.Util;

@Entity
@Table(name="CONTA_CORRENTE")
public class ContaCorrente implements Serializable {

	private static final long serialVersionUID = 241007515330316065L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CONTA")
	private Long idConta;
	@Column(name = "NUMERO")
	private Integer numero;
	@Column(name = "AGENCIA")
	private Integer agencia;
	@Column(name="TIPO")
	private String tipo;
	@Column(name="ID_PESSOA")
	private Long idPessoa;
	
	public ContaCorrente() {
	}
	
	public ContaCorrente(Pessoa pessoa, Integer agenciaParam) {
		this.numero = Util.random6digitos();
		this.agencia = agenciaParam;
	}
	
	public ContaCorrenteDto converterDto() {
		ContaCorrenteDto contaCorrenteDto = new ContaCorrenteDto();
		contaCorrenteDto.setIdConta(this.idConta);
		contaCorrenteDto.setNumero(this.numero);
		contaCorrenteDto.setAgencia(this.agencia);
		contaCorrenteDto.setTipo(this.tipo);
		contaCorrenteDto.setIdPessoa(this.idPessoa);
		return contaCorrenteDto;
	}
	
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
}
