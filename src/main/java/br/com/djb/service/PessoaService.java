package br.com.djb.service;

import java.util.List;

import br.com.djb.dto.CriarPessoaDto;
import br.com.djb.model.Pessoa;

public interface PessoaService {
	
	Pessoa save(CriarPessoaDto criarPessoaDto);

	List<Pessoa> listarPessoas();
}
