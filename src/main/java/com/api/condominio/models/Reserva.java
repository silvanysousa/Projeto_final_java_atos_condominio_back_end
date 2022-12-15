package com.api.condominio.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataReserva;
	private String AreaLazer; 
	private String tipoDeArea;

	public Reserva(){}

	public Reserva(Long id, String dataReserva, String areaLazer,String tipoDeArea) {
		this.id = id;
		this.dataReserva = dataReserva;
		AreaLazer = areaLazer;
		this.tipoDeArea =tipoDeArea;
	}

	public String getTipoDeArea() {
		return tipoDeArea;
	}

	public void setTipoDeArea(String tipoDeArea) {
		this.tipoDeArea = tipoDeArea;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}

	public String getAreaLazer() {
		return AreaLazer;
	}

	public void setAreaLazer(String areaLazer) {
		AreaLazer = areaLazer;
	}

	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Reserva reserva = (Reserva) o;
		return Objects.equals(id, reserva.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
