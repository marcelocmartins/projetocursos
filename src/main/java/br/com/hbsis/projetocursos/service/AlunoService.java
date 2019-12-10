package br.com.hbsis.projetocursos.service;

import java.util.List;

import br.com.hbsis.projetocursos.entity.Aluno;
import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.AlunoListagemDTO;


public interface AlunoService 
{
	public List<AlunoListagemDTO> findAll();

    AlunoListagemDTO findAlunoListagembyId(int alunoId);

    public Aluno findById(int theId);
	public void save(Aluno theAluno);
	public AlunoDTO findAlunoDTOById(int theAlunoId);
	public void cadastraAluno(AlunoDTO theAluno);
	public void deletaAluno(int alunoId);
	public AlunoDTO atualizaAluno(AlunoDTO theAluno);
}
