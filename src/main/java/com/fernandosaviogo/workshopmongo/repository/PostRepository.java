package com.fernandosaviogo.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fernandosaviogo.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")    // ?0 pega o 1º parametro que chegou - options i tira o case sensitive
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);   // Metodo de busca padrão Query methods

}
