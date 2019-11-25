package br.com.hbsis.projetocursos.service;

import java.util.List;

import br.com.hbsis.projetocursos.entity.Aluno;
import br.com.hbsis.projetocursos.entity.AlunoDTO;


public interface AlunoService 
{
	public List<AlunoDTO> findAll();
	
	public Aluno findById(int theId);
	
	public void save(Aluno theEmployee);
	
	public void deleteById(int theId);
}
