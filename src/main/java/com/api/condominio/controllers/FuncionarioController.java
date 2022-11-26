package com.api.condominio.controllers;

import com.api.condominio.models.Funcionario;
import com.api.condominio.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {


    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> todosFuncionarios(){
        return ResponseEntity.ok()
                .body(funcionarioService.pegarTodosFuncionario());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> pegarUmfuncioanrio(@PathVariable Long id){
        return ResponseEntity.ok()
                .body(funcionarioService.pegarFuncioarios(id));
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok().body(funcionarioService.salvar(funcionario));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario,@PathVariable Long id){
        return ResponseEntity.ok().body(funcionarioService.updateFuncionario(id,funcionario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteF(@PathVariable Long id){
        funcionarioService.DeleteFuncionario(id);
        return ResponseEntity.notFound().build();
    }
}
