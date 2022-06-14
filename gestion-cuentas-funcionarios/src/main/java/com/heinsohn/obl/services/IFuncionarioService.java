package com.heinsohn.obl.services;

import com.heinsohn.obl.model.Cargo;
import com.heinsohn.obl.model.DTO.FuncionarioDTO;
import com.heinsohn.obl.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface IFuncionarioService {

    List<FuncionarioDTO> findAll();
    FuncionarioDTO findById(Long id);
    FuncionarioDTO create(Funcionario funcionario);
    FuncionarioDTO update(Funcionario funcionario);
    void delete(Long id);

    FuncionarioDTO findByName(String nombre);


    List<Cargo> getCargo();
    Cargo getCargo(Long id);

}
