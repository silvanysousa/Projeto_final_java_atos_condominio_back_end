package com.api.condominio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.condominio.models.Reserva;
import com.api.condominio.models.Usuario;
import com.api.condominio.repositories.ReservaRepository;
import com.api.condominio.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario") /*endereco para todos os endpoints*/
public class UsuarioController {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Autowired /*para injeção de dependência*/
	private UsuarioRepository usuarioRepository;
	
	@GetMapping /*retorna todos os us cadastrados no bd*/
	public ResponseEntity<List<Usuario>> listar() { /*criando metodo findAll*/
		return ResponseEntity.ok().body(usuarioRepository.findAll()); /*procura todos os usuarios cadastrados*/
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario>  listarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNotFoundException(id)));
	}
		
	@PostMapping /*cria um novo usuario*/
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(usuarioRepository.save(usuario));
	}
	
	@PutMapping("/{id}") /*altera um usuario existente*/
	public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario, @PathVariable Long id) {
		Optional<Usuario> usuario1 = usuarioRepository.findById(id);
		Usuario usuario2 = usuario1.orElse(null);
		usuario2.setNome(usuario.getNome());
		usuario2.setCpf(usuario.getCpf());
		usuario2.setBloco(usuario.getBloco());
		usuario2.setApartamento(usuario.getApartamento());
		usuario2.setTelefone(usuario.getTelefone());
		usuario2.setId(usuario.getId());		
		
		
		return ResponseEntity.ok().body(usuarioRepository.save(usuario));
	} 
	
	@DeleteMapping("/{id}") /*deleta us atraves do id*/
	public void excluir(@PathVariable Long id) {		
		usuarioRepository.deleteById(id);		
	}
	
}