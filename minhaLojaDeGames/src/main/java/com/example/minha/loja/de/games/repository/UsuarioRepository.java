package com.example.minha.loja.de.games.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.minha.loja.de.games.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>  {

	public Optional<Usuario> findByUsuario(String usuario);
}