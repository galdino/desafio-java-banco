package br.com.djb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djb.dto.CriarPessoaDto;
import br.com.djb.dto.PessoaDto;
import br.com.djb.model.Pessoa;
import br.com.djb.service.PessoaService;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Void> criarPessoa(@RequestBody CriarPessoaDto criarPessoaDto) {
		this.pessoaService.save(criarPessoaDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDto>> listarPessoas() {
		List<Pessoa> pessoaList = this.pessoaService.listarPessoas();
		if(pessoaList.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			List<PessoaDto> pessoaListAux = pessoaList.stream()
									  				  .map(Pessoa::converterDto)
									  				  .collect(Collectors.toList());
			return new ResponseEntity<List<PessoaDto>>(pessoaListAux, HttpStatus.OK);
		}
	}
}
