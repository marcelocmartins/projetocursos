package br.com.hbsis.projetocursos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.hbsis.projetocursos.entity.Boletim;
import br.com.hbsis.projetocursos.entity.BoletimDTO;

@Repository
public interface BoletimRepository extends JpaRepository<Boletim, Integer> 
{
	public List<Boletim> findBoletimByAlunoId(int alunoId);


}
