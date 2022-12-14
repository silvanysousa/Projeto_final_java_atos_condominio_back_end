package com.api.condominio.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@NotBlank(message = "Campo obrigatorio")
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "Campo obrigatorio")
	@Column(nullable = false, unique = true)
	private String cpf;	
	
	@NotBlank(message = "Campo obrigatorio")
	@Column(nullable = false)
	private String telefone;
	
	@NotBlank(message = "Campo obrigatorio")
	@Column(nullable = false)
	private String bloco;	
	
	@NotBlank(message = "Campo obrigatorio")
	@Column(nullable = false)
	private String apartamento;
	
	@NotBlank(message = "Campo obrigatorio")
	@Column(nullable = false)
	private String senha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_usuario_reserva",
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns= @JoinColumn(name = "reserva_id"))
	private List<Reserva> reservas = new ArrayList<>();

	public Usuario(){}

	public Usuario(Long id, String nome, String cpf, String telefone, String bloco, String apartamento, String senha) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.bloco = bloco;
		this.apartamento = apartamento;
		this.senha = senha;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public void addReservas(Reserva reservas){
		this.reservas.add(reservas);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return Objects.equals(id, usuario.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
