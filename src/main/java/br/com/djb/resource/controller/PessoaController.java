package br.com.djb.resource.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.djb.model.Pessoa;
import br.com.djb.service.PessoaService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaAux = this.pessoaService.save(pessoa);
		pessoaAux.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(PessoaController.class).listarPessoas()).withRel("Lista Pessoas"));
		return new ResponseEntity<Pessoa>(pessoaAux, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> listarPessoas() {
		List<Pessoa> pessoaList = this.pessoaService.listarPessoas();
		if(pessoaList.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			for (Pessoa pessoaAux : pessoaList) {
				Long serialNumber = pessoaAux.getIdPessoa();
				pessoaAux.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(PessoaController.class).listarUmaPessoa(serialNumber)).withSelfRel());
			}
			return new ResponseEntity<List<Pessoa>>(pessoaList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{idPessoa}")
	public ResponseEntity<Pessoa> listarUmaPessoa(@PathVariable(value="idPessoa") long idPessoa) {
		Optional<Pessoa> pessoaAuxO = this.pessoaService.listarUmaPessoa(idPessoa);
		if(pessoaAuxO.isPresent()){
			pessoaAuxO.get().add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(PessoaController.class).listarPessoas()).withRel("Lista Pessoas"));
			return new ResponseEntity<Pessoa>(pessoaAuxO.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
