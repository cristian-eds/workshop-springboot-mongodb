package com.cristianeds.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cristianeds.workshopmongo.domain.Post;
import com.cristianeds.workshopmongo.domain.User;
import com.cristianeds.workshopmongo.dto.AuthorDTO;
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
		postRepository.deleteAll();
		User juliaUser = new User(null, "Julia Ana", "juliana@gmail.com");
		User joaoUser = new User(null, "Joao Carlos", "joao.carlos@gmail.com");
		User taldoUser = new User(null, "Taldo Jr", "taldo.jr@gmail.com");
		
		repository.saveAll(Arrays.asList(juliaUser,joaoUser,taldoUser));
		
		
		
		Post post1 = new Post(null, sdf.parse("09/09/2023"), "Partiu viagem", "Vou viajar para SP", new AuthorDTO(juliaUser));
		Post post2 = new Post(null, sdf.parse("10/09/2023"), "Bom dia", "Cheguei em SP", new AuthorDTO(juliaUser));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		juliaUser.getPosts().addAll(Arrays.asList(post1,post2));
		repository.save(juliaUser);
		
		
		
		
	}
	
}
