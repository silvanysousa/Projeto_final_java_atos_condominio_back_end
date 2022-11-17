package com.api.condominio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.condominio.models.Categoria;
import com.api.condominio.repositories.CategoriaRepository;


@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

	@Autowired /*obtem uma instancia do categoriaRepository*/
	private CategoriaRepository categoriaRepository; /*para acessar os metodos do repository dentro do resource*/
	
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() { //metodo buscar
		List<Categoria> list = categoriaRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria cat = categoriaRepository.findById(id); //busca no map
		return ResponseEntity.ok().body(cat);
	}
}