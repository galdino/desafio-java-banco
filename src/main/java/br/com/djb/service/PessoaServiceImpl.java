package br.com.djb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.djb.exception.CamposInvalidosDaoException;
import br.com.djb.model.Pessoa;
import br.com.djb.model.TipoPessoa;
import br.com.djb.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	@Transactional
	public Pessoa save(Pessoa pessoa) {
		
			if(pessoa.getNome() == null || "".equals(pessoa.getNome().trim())){
				throw new CamposInvalidosDaoException("Nome");
			}
			
			if(pessoa.getTipo() == null 
			   || "".equals(pessoa.getTipo().trim())
			   || TipoPessoa.contains(pessoa.getTipo()) == null){
				throw new CamposInvalidosDaoException("Tipo");
			}
			
			if(pessoa.getNumDocumento() == null 
			   || "".equals(pessoa.getNumDocumento().trim())
			   || TipoPessoa.contains(pessoa.getTipo()).getValue() != pessoa.getNumDocumento().length()){
				throw new CamposInvalidosDaoException("Número Documento");
			}
			
			pessoa.setScore((int) (Math.random()*9));
			
			return this.pessoaRepository.save(pessoa);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Pessoa> listarPessoas() {
		try {
			return this.pessoaRepository.findAll();
		} catch (QueryTimeoutException e) {
			throw new QueryTimeoutException(e.getMessage());
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pessoa> listarUmaPessoa(long idPessoa) {
		try {
			return this.pessoaRepository.findById(idPessoa);
		} catch (QueryTimeoutException e) {
			throw new QueryTimeoutException(e.getMessage());
		}
	}

}
