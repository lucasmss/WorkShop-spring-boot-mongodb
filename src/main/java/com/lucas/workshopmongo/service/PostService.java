package com.lucas.workshopmongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.workshopmongo.domain.Post;
import com.lucas.workshopmongo.repository.PostRepository;
import com.lucas.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		if(user == null) {
			
			throw new ObjectNotFoundException("Objeto não encontrado");
			
		}
		return  user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	

	
}
