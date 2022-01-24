package com.example.minha.loja.de.games.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.minha.loja.de.games.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
		
		List<Produto> findAll();
		Produto findById( long id);
		List<Produto>findByDescricao (String descricao);

}