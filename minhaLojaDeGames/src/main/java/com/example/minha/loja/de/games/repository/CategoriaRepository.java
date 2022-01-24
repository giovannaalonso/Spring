package com.example.minha.loja.de.games.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.minha.loja.de.games.model.Categoria;

	public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
		
		List<Categoria> findAll();
		Categoria findById( long id);
		List<Categoria>findByDescricao (String descricao);

}
