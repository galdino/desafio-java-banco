package br.com.djb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.djb.dto.CriarPessoaDto;
import br.com.djb.dto.PessoaDto;
import br.com.djb.exception.CamposInvalidosDaoException;
import br.com.djb.util.Util;

@Entity
@Table(name="PESSOA")
public class Pessoa implements Serializable {
	
	
	private static final long serialVersionUID = 3517223709245348854L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PESSOA")
	private Long idPessoa;
	@Column(name = "NOME")
	private String nome;
	@Column(name = "TIPO")
	private String tipo;
	@Column(name="NUM_DOCUMENTO")
	private String numDocumento;
	@Column(name="SCORE")
	private Integer score;
	
	public Pessoa() {
	}
	
	public Pessoa(CriarPessoaDto criarPessoaDto) {
		if(criarPessoaDto.getNome() == null || "".equals(criarPessoaDto.getNome().trim())){
			throw new CamposInvalidosDaoException("Nome");
		}
		
		if(criarPessoaDto.getTipo() == null 
		   || "".equals(criarPessoaDto.getTipo().trim())
		   || TipoPessoa.contains(criarPessoaDto.getTipo()) == null){
			throw new CamposInvalidosDaoException("Tipo");
		}
		
		if(criarPessoaDto.getNumDocumento() == null 
		   || "".equals(criarPessoaDto.getNumDocumento().trim())
		   || TipoPessoa.contains(criarPessoaDto.getTipo()).getValue() != criarPessoaDto.getNumDocumento().length()){
			throw new CamposInvalidosDaoException("Número Documento");
		}
		
        this.nome = criarPessoaDto.getNome();
        this.tipo = criarPessoaDto.getTipo();
        this.numDocumento = criarPessoaDto.getNumDocumento();
        this.score = Util.random0a9();
    }
	
	public PessoaDto converterDto() {
		PessoaDto pessoaDto = new PessoaDto();
		pessoaDto.setIdPessoa(this.idPessoa);
		pessoaDto.setNome(this.nome);
		pessoaDto.setTipo(this.tipo);
		pessoaDto.setNumDocumento(this.numDocumento);
		pessoaDto.setScore(this.score);
        return pessoaDto;
    }
	
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
