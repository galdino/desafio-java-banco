package br.com.djb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.djb.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
