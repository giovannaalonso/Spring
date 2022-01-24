package com.example.minha.loja.de.games.controller;

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
import com.example.minha.loja.de.games.model.Categoria;
import com.example.minha.loja.de.games.repository.CategoriaRepository;

@RestController
@RequestMapping("/minhaloja")
@CrossOrigin("*")

public class CategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;

	@GetMapping(value = "/lista")
	public ResponseEntity<List<Categoria>> findAllCategoria() {

		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@GetMapping(value = "/id/{id}")
	public ResponseEntity<Categoria> findByIDCategoria(@PathVariable("id") long id) {

		return ResponseEntity.ok(categoriaRepository.findById(id));
	}

	@GetMapping(value = "/descricao")
	public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String descricao) {

		return ResponseEntity.ok(categoriaRepository.findByDescricao(descricao));
	}

	@PostMapping(value = "/categoria")
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}

	@PutMapping(value = "/categoria")
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria categoria) {

		return categoriaRepository.findById(categoria.getId())
				.map(resposta -> ResponseEntity.ok().body(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(value = "/categoria/id/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable long id) {
		categoriaRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
