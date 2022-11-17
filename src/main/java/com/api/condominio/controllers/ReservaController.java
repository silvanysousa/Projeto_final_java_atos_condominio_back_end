package com.api.condominio.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.condominio.models.Reserva;
import com.api.condominio.repositories.ReservaRepository;
import com.api.condominio.repositories.UsuarioRepository;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	public ReservaRepository reservaRepository;
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@PostMapping("/{id}")
	public String novaReserva(@RequestBody Reserva reserva, @PathVariable Long id) {
		
		
		
		
		
		
		
		
		
		
		return "ola";
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	