package com.api.condominio.service;

import com.api.condominio.models.Reserva;
import com.api.condominio.repositories.ReservaRepository;
import com.api.condominio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> todasReservas(){
        return reservaRepository.findAll();
    }
    public Reserva pegarReserva(Long id){
        Optional<Reserva> reserva = reservaRepository.findById(id);
        return reserva.orElse(null);
    }

    public Reserva criarReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public Reserva updateReserva(Long id, Reserva reserva){
        Optional<Reserva> r = reservaRepository.findById(id);
        Reserva reserva1 = r.orElse(null);
        reserva1.setDataReserva(reserva.getDataReserva());
        reserva1.setAreaLazer(reserva.getAreaLazer());
        reserva1.setTipoDeArea(reserva.getTipoDeArea());
        return  reservaRepository.save(reserva1);
    }

    public void deleteReserva(Long id){
        reservaRepository.deleteById(id);
    }

}
