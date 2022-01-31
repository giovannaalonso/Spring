package com.example.minha.loja.de.games.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.minha.loja.de.games.model.Usuario;
import com.example.minha.loja.de.games.model.UsuarioLogin;
import com.example.minha.loja.de.games.service.UsuarioService;

		@RestController
		@RequestMapping("/usuarios")
		@CrossOrigin (origins = "*", allowedHeaders = "*")
		public class UsuarioController {

			@Autowired
			private UsuarioService usuarioService;
			
			@PostMapping("/logar")
			public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> usuario){
				
				return usuarioService.Logar(usuario).map(resp -> ResponseEntity.ok(resp))
						.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
			}
			
			@PostMapping("/cadastrar")
			public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
				
				return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
			}
			
		}

		