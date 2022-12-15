package com.api.condominio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {	
	private String cpf;
	private String senha;
	
	public UsuarioDto(String cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha;
	}
}
