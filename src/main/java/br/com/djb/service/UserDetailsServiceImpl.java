package br.com.djb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.djb.model.MyUserDetails;
import br.com.djb.model.User;
import br.com.djb.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = this.userRepository.findByUserName(username);
		
		if(!user.isPresent()) {
			throw new UsernameNotFoundException("Not found: " + username);
		}
		
		return user.map(u -> new MyUserDetails(u)).get();
	}

}
