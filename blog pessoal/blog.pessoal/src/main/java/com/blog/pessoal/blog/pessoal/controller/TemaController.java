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
import org.springframework.web.bind.annotation.RestController;
import com.blog.pessoal.blog.pessoal.model.Tema;
import com.blog.pessoal.blog.pessoal.repository.TemaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository repository;

	@GetMapping (value = "/tema")
 public ResponseEntity<List<Tema>> findAllTema(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping (value = "/id/{id}")
		public ResponseEntity<Tema> findByIDPostagem(@PathVariable("id") long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping (value = "/nome/{nome}")
		public ResponseEntity<List<Tema>> findByName(@PathVariable String nome){
			return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome));
			}
	
	@PostMapping (value = "/tema")
	public ResponseEntity<Tema> post(@Valid @RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping (value = "/tema")
	public ResponseEntity<Tema> put(@Valid @RequestBody Tema tema) {
		return ResponseEntity.ok(repository.save(tema));
	}
	
		@DeleteMapping(value = "/{id}")
		public void delete (@PathVariable long id) {
			repository.deleteById(id);
		}
		
	
}