package com.blog.pessoal.blog.pessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blog.pessoal.blog.pessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDON_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.save(new Usuario(0L, "Teste01", "teste01@email.com.br", "545646515795"));
		usuarioRepository.save(new Usuario(0L, "Teste02", "teste02@email.com.br", "5456465585795"));
		usuarioRepository.save(new Usuario(0L, "Teste03", "teste03@email.com.br", "54564651554795"));
		usuarioRepository.save(new Usuario(0L, "Testee04", "teste04@email.com.br", "54564999995"));
	}
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("teste01@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("teste01@email.com.br"));
		
		
	}
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Teste");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Teste01"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Teste02"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Teste03"));
}
}
