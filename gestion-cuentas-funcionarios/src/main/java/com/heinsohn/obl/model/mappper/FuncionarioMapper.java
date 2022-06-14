package com.heinsohn.obl.model.mappper;

import com.heinsohn.obl.model.DTO.FuncionarioDTO;
import com.heinsohn.obl.model.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface FuncionarioMapper {

    @Mapping(target = "nombreFuncionario", expression = "java(funcionario.getNombre() + ' ' + funcionario.getApellido())")
    @Mapping(target = "posicion", source = "cargo")
    FuncionarioDTO toDTO(Funcionario funcionario);


}
