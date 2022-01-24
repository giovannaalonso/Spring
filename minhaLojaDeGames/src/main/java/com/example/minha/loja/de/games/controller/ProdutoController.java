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
import com.example.minha.loja.de.games.model.Produto;
import com.example.minha.loja.de.games.repository.ProdutoRepository;

	@RestController
	@RequestMapping("/minhaloja/produto")
	@CrossOrigin("*")

	public class ProdutoController { 

		@Autowired
		ProdutoRepository produtoRepository;

		@GetMapping(value = "/lista")
		public ResponseEntity<List<Produto>> findAllProduto() {

			return ResponseEntity.ok(produtoRepository.findAll());
		}

		@GetMapping(value = "/id/{id}")
		public ResponseEntity<Produto> findByIDProduto(@PathVariable("id") long id) {

			return ResponseEntity.ok(produtoRepository.findById(id));
		}

		@GetMapping(value = "/descricao")
		public ResponseEntity<List<Produto>> getByDescricao(@PathVariable String descricao) {

			return ResponseEntity.ok(produtoRepository.findByDescricao(descricao));
		}

		@PostMapping(value = "/produto")
		public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto) {
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
		}

		@PutMapping(value = "/produto")
		public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto) {

			return produtoRepository.findById(produto.getId())
					.map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produto)))
					.orElse(ResponseEntity.notFound().build());
		}

		@DeleteMapping(value = "/produto/id/{id}")
		public ResponseEntity<?> deleteProduto(@PathVariable long id) {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
