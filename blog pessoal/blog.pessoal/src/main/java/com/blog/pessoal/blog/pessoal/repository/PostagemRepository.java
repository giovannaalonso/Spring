package com.blog.pessoal.blog.pessoal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blog.pessoal.blog.pessoal.model.Postagem;

public interface PostagemRepository extends CrudRepository<Postagem, Long>{
	
	List<Postagem> findAll();
	Postagem findById( long id);
	List<Postagem>findByTitulo (String titulo);
}
