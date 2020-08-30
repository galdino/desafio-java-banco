package br.com.djb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.djb.model.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

}
