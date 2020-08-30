package br.com.djb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.stereotype.Service;

import br.com.djb.model.ContaCorrente;
import br.com.djb.model.Pessoa;
import br.com.djb.repository.ContaCorrenteRepository;

@Service
public class ContaCorrenteServiceImpl implements ContaCorrenteService {
	
	@Value("${agencia.numero}")
	private String agenciaParam;
	
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	@Override
	public List<ContaCorrente> listarContas() {
		try {
			return this.contaCorrenteRepository.findAll();
		} catch (QueryTimeoutException e) {
			throw new QueryTimeoutException(e.getMessage());
		}
	}

	@Override
	public ContaCorrente save(Pessoa pessoa) {
		ContaCorrente contaCorrente = new ContaCorrente(pessoa, Integer.valueOf(this.agenciaParam));
		return this.contaCorrenteRepository.save(contaCorrente);
	}

}
