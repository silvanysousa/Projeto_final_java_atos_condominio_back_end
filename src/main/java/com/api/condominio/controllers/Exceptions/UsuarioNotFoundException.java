package com.api.condominio.controllers.Exceptions;

public class UsuarioNotFoundException extends RuntimeException {

	UsuarioNotFoundException(Long id){
		super("Usuario nao encontrado: " + id);
	}
}
