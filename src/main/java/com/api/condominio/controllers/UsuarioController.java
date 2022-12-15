package com.api.condominio.controllers;

import com.api.condominio.dto.UsuarioDto;
import com.api.condominio.models.Usuario;
import com.api.condominio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.api.condominio.security.Token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {

	//INICIALIZAÇÃO DO LOGGER
    
    final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
    @Autowired
    private UsuarioService usuarioService;
    
    public UsuarioController(UsuarioService usuarioService) {
    	this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> todos(){
        return ResponseEntity.status(200).body(usuarioService.todos());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> pegarUser(@PathVariable Long id){
        /*Usuario u = usuarioService.usuarioId(id);*/
        return ResponseEntity.status(200).body(usuarioService.usuarioId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUser(@Valid @RequestBody Usuario usuario){    	 
        /* Usuario u = usuarioService.criarUser(usuario);  */        
        logger.info("Usuario cadastrado com sucesso!");
        return ResponseEntity.status(201).body(usuarioService.criarUser(usuario));                      
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@Valid @PathVariable Long id, @RequestBody Usuario usuario){
        /*Usuario u = usuarioService.updateUser(id,usuario);*/
        logger.info("Usuario alterado com sucesso!");
        return ResponseEntity.status(201).body(usuarioService.updateUser(id,usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        usuarioService.deletarUser(id);
        logger.info("Usuario deletado com sucesso!");
        return ResponseEntity.status(204).build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<Token> logar(@Valid @RequestBody UsuarioDto usuario) {
    	Token token = usuarioService.gerarToken(usuario);
    	if (token != null) {
    		return ResponseEntity.ok(token);
    	}
    	return ResponseEntity.status(403).build();
    }  
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
    	Map<String, String> errors = new HashMap<>();
    	
    	ex.getBindingResult().getAllErrors().forEach((error) -> {
    		String fieldName = ((FieldError) error).getField();
    		String errorMessage = error.getDefaultMessage();
    		errors.put(fieldName, errorMessage);
    	});
    	
    	return errors;
    }
    
}    
