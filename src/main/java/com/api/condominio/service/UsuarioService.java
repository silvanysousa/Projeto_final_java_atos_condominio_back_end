package com.api.condominio.service;


import com.api.condominio.models.Reserva;
import com.api.condominio.models.Usuario;
import com.api.condominio.repositories.ReservaRepository;
import com.api.condominio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    public List<Usuario> todos(){
        return usuarioRepository.findAll();
    }
    @Transactional
    public Usuario usuarioId(Long id){
        Optional<Usuario> u = usuarioRepository.findById(id);
        Usuario user = u.orElse(null);
        return user;
    }

    public Usuario criarUser(Usuario user){

        List<Reserva> reservas = new ArrayList<>();

        for (Reserva r : user.getReservas()){
            Optional<Reserva> re = reservaRepository.findById(r.getId());
            Reserva reserva = re.orElse(null);
            if(reserva!=null){
                reservas.add(reserva);
            }
            else{
                Reserva novaReserva = new Reserva();
                novaReserva.setTipoDeArea(reserva.getTipoDeArea());
                novaReserva.setDataReserva(reserva.getDataReserva());
                novaReserva.setAreaLazer(reserva.getAreaLazer());
                reservas.add(novaReserva);
            }
        }
        user.setReservas(reservas);

        return usuarioRepository.save(user);
    }

    public Usuario updateUser(Long id,Usuario user){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        Usuario usuario1 =  usuario.orElse(null);
        usuario1.setApartamento(user.getApartamento());
        usuario1.setBloco(user.getBloco());
        usuario1.setCpf(user.getCpf());
        usuario1.setTelefone(user.getTelefone());
        usuario1.setNome(user.getNome());

        usuario1.getReservas().clear();

        for (Reserva reserva : user.getReservas()){
            Optional<Reserva> r = reservaRepository.findById(reserva.getId());
            Reserva reserva1 = r.orElse(null);
            user.addReservas(reserva);

        }
        return usuarioRepository.save(usuario1);
    }

    public void deletarUser(Long id){
        usuarioRepository.deleteById(id);
    }

}
