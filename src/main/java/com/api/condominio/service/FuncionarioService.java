package com.api.condominio.service;


import com.api.condominio.models.Empresa;
import com.api.condominio.models.Funcionario;
import com.api.condominio.repositories.EmpresaRepository;
import com.api.condominio.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Funcionario> pegarTodosFuncionario(){
        return funcionarioRepository.findAll();
    }

    public Funcionario pegarFuncioarios(Long id){
        Optional<Funcionario> f = funcionarioRepository.findById(id);
        Funcionario funcionario = f.orElse(null);
        return funcionario;
    }

    public Funcionario salvar(Funcionario f){
        Optional<Empresa> empresa = empresaRepository.findById(f.getEmpresa().getId());
        Empresa empresa1 = empresa.orElse(null);
        if (empresa1==null){
            return  funcionarioRepository.save(f);
        }else {
            f.setEmpresa(empresa1);
            return  funcionarioRepository.save(f);
        }

    }

    public Funcionario updateFuncionario(Long id, Funcionario funcionario){
        Optional<Funcionario> funcionario1 = funcionarioRepository.findById(id);
        Funcionario funcionario2 = funcionario1.orElse(null);
        funcionario2.setCargo(funcionario.getCargo());
        funcionario2.setNome(funcionario.getNome());
        funcionario2.setEmpresa(funcionario.getEmpresa());
        Funcionario f1 =  funcionarioRepository.save(funcionario2);
        return  f1;
    }

    public void DeleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }

}
