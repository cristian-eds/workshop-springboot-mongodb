package com.cristianeds.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cristianeds.workshopmongo.domain.User;
import com.cristianeds.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		User juliaUser = new User(null, "Julia Ana", "juliana@gmail.com");
		User joaoUser = new User(null, "Joao Carlos", "joao.carlos@gmail.com");
		User taldoUser = new User(null, "Taldo Jr", "taldo.jr@gmail.com");
		
		repository.saveAll(Arrays.asList(juliaUser,joaoUser,taldoUser));
		
	}
	
}
