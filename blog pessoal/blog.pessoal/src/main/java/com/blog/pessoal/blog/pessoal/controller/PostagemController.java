package com.blog.pessoal.blog.pessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.pessoal.blog.pessoal.model.Postagem;
import com.blog.pessoal.blog.pessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/blogpessoal")
@CrossOrigin("*")

public class PostagemController {

	@Autowired
	PostagemRepository postagemRepository;

	@GetMapping(value = "/lista")
	public ResponseEntity<List<Postagem>> findAllPostagem() {

		return ResponseEntity.ok(postagemRepository.findAll());
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Postagem> findByIDPostagem(@PathVariable("id") long id) { 

		return ResponseEntity.ok(postagemRepository.findById(id));
	}

	@GetMapping(value = "/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {

		return ResponseEntity.ok(postagemRepository.findByTitulo(titulo));
	}

	@PostMapping(value = "/postagem")
	public ResponseEntity<Postagem> postPostagem(@Valid @RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}

	@PutMapping (value = "/postagem")
	public ResponseEntity<Postagem> putPostagem(@Valid @RequestBody Postagem postagem) {

		return postagemRepository.findById(postagem.getId())
				.map(resposta -> ResponseEntity.ok().body(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value = "/postagem/id/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id) {
		postagemRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
