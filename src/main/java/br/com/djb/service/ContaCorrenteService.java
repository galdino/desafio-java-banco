package br.com.djb.service;

import java.util.List;

import br.com.djb.model.ContaCorrente;
import br.com.djb.model.Pessoa;

public interface ContaCorrenteService {
	
	ContaCorrente save(Pessoa pessoa);
	
	List<ContaCorrente> listarContas();

}
