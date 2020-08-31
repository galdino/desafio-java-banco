package br.com.djb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djb.dto.ContaCorrenteDto;
import br.com.djb.model.ContaCorrente;
import br.com.djb.service.ContaCorrenteService;

@RestController
@RequestMapping("/contas")
public class ContaCorrenteController {
	
	@Autowired
	private ContaCorrenteService contaCorrenteService;
	
	@GetMapping
	public ResponseEntity<List<ContaCorrenteDto>> listarContas() {
		List<ContaCorrente> contaList = this.contaCorrenteService.listarContas();
		List<ContaCorrenteDto> contaListAux = contaList.stream()
								  				       .map(ContaCorrente::converterDto)
								  				       .collect(Collectors.toList());
		return new ResponseEntity<List<ContaCorrenteDto>>(contaListAux, HttpStatus.OK);
	}

}
