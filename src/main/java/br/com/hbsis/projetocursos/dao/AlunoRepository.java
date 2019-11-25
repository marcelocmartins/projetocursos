package br.com.hbsis.projetocursos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hbsis.projetocursos.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> 
{

}
