package com.heinsohn.obl.repository;

import com.heinsohn.obl.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Singleton;

@Singleton
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByNombre(String nombre);

}
