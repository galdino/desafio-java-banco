package br.com.djb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.djb.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUserName(String userName);

}
