package com.br.escola.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.escola.Model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
