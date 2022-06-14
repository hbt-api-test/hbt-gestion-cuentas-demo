package com.heinsohn.obl.services.impl;


import com.heinsohn.obl.clients.EstructuraGestionClient;
import com.heinsohn.obl.exception.ApiRequestException;
import com.heinsohn.obl.model.Cargo;
import com.heinsohn.obl.model.DTO.FuncionarioDTO;
import com.heinsohn.obl.model.Funcionario;
import com.heinsohn.obl.model.mappper.FuncionarioMapper;
import com.heinsohn.obl.repository.IFuncionarioRepository;
import com.heinsohn.obl.services.IFuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class FuncionarioService implements IFuncionarioService {


    private final IFuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;


    @RestClient
    @Inject
    EstructuraGestionClient estructuraGestionClient;

    public FuncionarioService(IFuncionarioRepository funcionarioRepository,
                              FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMapper = funcionarioMapper;

    }



    @Override
    public List<FuncionarioDTO> findAll() {


        List<FuncionarioDTO> funcionarios = funcionarioRepository.findAll()
                .stream()
                .map(funcionario -> funcionarioMapper.toDTO(funcionario))
                .collect(Collectors.toList());



        return funcionarios;
    }

    @Override
    public FuncionarioDTO findById(Long id) {
        return funcionarioMapper.toDTO(funcionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario no encintrado")));
    }

    @Override
    public FuncionarioDTO create(Funcionario funcionario) {

        /*if(funcionario.getCargo().isEmpty()){

            String errorCampoRequerido = "El campo cargo es requerido";
            log.error(errorCampoRequerido);
            throw new ApiRequestException(errorCampoRequerido);

        }*/

        return funcionarioMapper.toDTO(funcionarioRepository.save(funcionario));
    }

    @Override
    public FuncionarioDTO update(Funcionario funcionario) {

        Funcionario actualizarFuncionario = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Funcionario no encontrado"));
        actualizarFuncionario.setNombre(funcionario.getNombre());
        actualizarFuncionario.setApellido(funcionario.getApellido());
        actualizarFuncionario.setCargo(funcionario.getCargo());

        return funcionarioMapper.toDTO(funcionarioRepository.save(actualizarFuncionario));
    }

    @Override
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }

    @Override
    public FuncionarioDTO findByName(String nombre) {
        return funcionarioMapper.toDTO(funcionarioRepository.findByNombre(nombre));
    }

    @Override
    public List<Cargo> getCargo() {
        return estructuraGestionClient.listarCargos();
    }

    @Override
    public Cargo getCargo(Long id) {
        return estructuraGestionClient.listarCargos(id);
    }

}
