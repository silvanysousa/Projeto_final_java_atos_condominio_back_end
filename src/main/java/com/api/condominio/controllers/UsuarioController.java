package com.api.condominio.controllers;

import com.api.condominio.models.Usuario;
import com.api.condominio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	//INICIALIZAÇÃO DO LOGGER
    
    final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> todos(){
        return ResponseEntity.ok().body(usuarioService.todos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pegarUser(@PathVariable Long id){
        Usuario u = usuarioService.usuarioId(id);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUser(@RequestBody Usuario usuario){    	 
        Usuario u = usuarioService.criarUser(usuario);  
        logger.info("Usuario cadastrado com sucesso!");
        return ResponseEntity.ok().body(u);                      
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario u = usuarioService.updateUser(id,usuario);
        logger.info("Usuario alterado com sucesso!");
        return ResponseEntity.ok().body(u);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        usuarioService.deletarUser(id);
        logger.info("Usuario deletado com sucesso!");
        return ResponseEntity.noContent().build();
    }
}