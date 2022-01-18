package com.blog.pessoal.blog.pessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.pessoal.blog.pessoal.model.Postagem;
import com.blog.pessoal.blog.pessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/blogpessoal")

public class PostagemController {
	
	@Autowired
			PostagemRepository postagemRepository;
			@GetMapping (value = "/lista")
			public List <Postagem> findAllPostagem() {
				
				return postagemRepository.findAll();
		}
			
			@GetMapping (value = "/id/{id}")
				public Postagem findByIDPostagem(@PathVariable("id")long id) {
					
					return postagemRepository.findById(id);
	}

				@GetMapping (value = "/titulo/{titulo}")
				public Postagem findByTitulo (@PathVariable("titulo")String titulo) {
					
					return postagemRepository.findByTitulo(titulo);
				}
}
