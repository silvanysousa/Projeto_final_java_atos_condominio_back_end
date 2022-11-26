package com.api.condominio.controllers;


import com.api.condominio.models.Reserva;
import com.api.condominio.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> todos(){
        return ResponseEntity.ok().body(reservaService.todasReservas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> pegarReserva(@PathVariable Long id){
        Reserva reserva = reservaService.pegarReserva(id);
        return ResponseEntity.ok().body(reserva);
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva){
        Reserva r = reservaService.criarReserva(reserva);
        return ResponseEntity.ok().body(r);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id,@RequestBody Reserva reserva){
        Reserva r = reservaService.updateReserva(id,reserva);
        return ResponseEntity.ok().body(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id){
        reservaService.deleteReserva(id);
        return ResponseEntity.notFound().build();
    }

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	