package br.com.djb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.stereotype.Service;

import br.com.djb.dto.CriarPessoaDto;
import br.com.djb.model.Pessoa;
import br.com.djb.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Pessoa save(CriarPessoaDto criarPessoaDto) {
		final Pessoa pessoa = new Pessoa(criarPessoaDto);
		return this.pessoaRepository.save(pessoa);
	}

	@Override
	public List<Pessoa> listarPessoas() {
		try {
			return this.pessoaRepository.findAll();
		} catch (QueryTimeoutException e) {
			throw new QueryTimeoutException(e.getMessage());
		}
	}
}
