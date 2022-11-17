package com.api.condominio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.condominio.models.Reserva;
import com.api.condominio.models.Usuario;

@Repository /*para transacoes no bd*/
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { /*extensao para usar os metodos prontos do jparepository para transacoes com bd*/

	Optional<Usuario> findById(Long id);
	
	List<Usuario> findAll();
}