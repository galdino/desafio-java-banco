package br.com.djb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.stereotype.Service;

import br.com.djb.model.ContaCorrente;
import br.com.djb.repository.ContaCorrenteRepository;

@Service
public class ContaCorrenteServiceImpl implements ContaCorrenteService {
	
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	@Value("${agencia.numero}")
	private String agenciaParam;

	@Override
	public List<ContaCorrente> listarContas() {
		System.out.println(this.agenciaParam);
		try {
			return this.contaCorrenteRepository.findAll();
		} catch (QueryTimeoutException e) {
			throw new QueryTimeoutException(e.getMessage());
		}
	}

}
