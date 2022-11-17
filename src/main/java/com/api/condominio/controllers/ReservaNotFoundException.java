package com.api.condominio.controllers;

public class ReservaNotFoundException extends RuntimeException {

	ReservaNotFoundException(Long id){
		super("Reserva nao encontrada: " + id);
	}
}
