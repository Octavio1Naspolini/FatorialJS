package com.br.escola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.escola.Model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {

}
