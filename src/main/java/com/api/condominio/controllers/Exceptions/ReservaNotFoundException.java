package com.api.condominio.controllers.Exceptions;

public class ReservaNotFoundException extends RuntimeException {

	ReservaNotFoundException(Long id){
		super("Reserva nao encontrada: " + id);
	}
}
