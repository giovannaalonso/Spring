package com.blog.pessoal.blog.pessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.pessoal.blog.pessoal.model.Usuario;
import com.blog.pessoal.blog.pessoal.model.UsuarioLogin;
import com.blog.pessoal.blog.pessoal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder ();
		
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return repository.save(usuario);
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user){
		BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder ();
		Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
		
		if (usuario.isPresent()) {
			
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get() + ":" + user.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodeAuth);
				
				user.get().setToken(authHeader);
				user.get().setId(usuario.get().getId());
				//linha 43 está diferente dá apresentada no vídeo de integração back e frontend
				user.get().setNome(usuario.get().getNome());
				user.get().setFoto(usuario.get().getFoto());
				user.get().setTipo(usuario.get().getTipo());
				
			}
		}
		
		//return null;
		return user;
	}
	
}
