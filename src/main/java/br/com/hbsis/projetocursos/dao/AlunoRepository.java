package br.com.hbsis.projetocursos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hbsis.projetocursos.entity.Aluno;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> 
{
    @Query("SELECT a FROM Aluno a WHERE a.turma.idTurma = :idTurma")
    public List<Aluno> findAlunosByTurmaId(@Param("idTurma") int idTurma);
}
