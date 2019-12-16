package br.com.hbsis.projetocursos.dao;

import br.com.hbsis.projetocursos.entity.Professor;
import br.com.hbsis.projetocursos.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer > {
}
