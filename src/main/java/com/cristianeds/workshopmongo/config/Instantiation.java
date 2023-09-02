package com.cristianeds.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cristianeds.workshopmongo.domain.Post;
import com.cristianeds.workshopmongo.domain.User;
import com.cristianeds.workshopmongo.repository.PostRepository;
import com.cristianeds.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		User juliaUser = new User(null, "Julia Ana", "juliana@gmail.com");
		User joaoUser = new User(null, "Joao Carlos", "joao.carlos@gmail.com");
		User taldoUser = new User(null, "Taldo Jr", "taldo.jr@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("09/09/2023"), "Partiu viagem", "Vou viajar para SP", juliaUser);
		Post post2 = new Post(null, sdf.parse("10/09/2023"), "Bom dia", "Cheguei em SP", juliaUser);
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		repository.saveAll(Arrays.asList(juliaUser,joaoUser,taldoUser));
		
		
		
	}
	
}
