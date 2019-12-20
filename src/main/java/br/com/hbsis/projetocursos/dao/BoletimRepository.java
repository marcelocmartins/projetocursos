package br.com.hbsis.projetocursos.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.hbsis.projetocursos.entity.Boletim;
import br.com.hbsis.projetocursos.entity.BoletimDTO;

import javax.swing.text.html.Option;

@Repository
public interface BoletimRepository extends JpaRepository<Boletim, Integer> {

	@Query("SELECT a FROM Boletim a WHERE a.aluno.idAlunos = :theId")
	public List<Boletim> findBoletimByAlunoId(@Param("theId") int theId);

	@Query("SELECT a FROM Boletim a WHERE a.aluno.idAlunos = :idAlunos AND a.aluno.turma.idTurma = :idTurma")
	public List<Boletim> findBoletimByAlunoeTurmaId(@Param("idAlunos") int idAlunos, @Param("idTurma") int idTurma);
}
