package com.api.condominio.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.condominio.models.Reserva;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {}

