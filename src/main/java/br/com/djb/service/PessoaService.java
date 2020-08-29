package br.com.djb.service;

import java.util.List;
import java.util.Optional;

import br.com.djb.model.Pessoa;

public interface PessoaService {
	
	Pessoa save(Pessoa pessoa);

	List<Pessoa> listarPessoas();

	Optional<Pessoa> listarUmaPessoa(long idPessoa);
	
	

}
