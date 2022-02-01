package com.blog.pessoal.blog.pessoal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.pessoal.blog.pessoal.model.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuario(String usuario);
	public List <Usuario> findAllByNomeContainingIgnoreCase(String nome); 
	
}

//public interface UsuarioRepository extends JpaRepository<Usuario, Long>  {

//	public Optional<Usuario> findByUsuario(String usuario);
	 
	
	
//}
