package com.api.condominio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.condominio.models.Categoria;
import com.api.condominio.models.Tipo;
import com.api.condominio.repositories.CategoriaRepository;
import com.api.condominio.repositories.TipoRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/tipos")
public class TipoResource {

	@Autowired /*obtem uma instancia do tipoRepository*/
	private TipoRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Tipo>> findAll() { //metodo buscar
		List<Tipo> list = categoriaRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tipo> findById(@PathVariable Long id) {
		Tipo cat = categoriaRepository.findById(id); //busca no map
		return ResponseEntity.ok().body(cat);
	}
}
