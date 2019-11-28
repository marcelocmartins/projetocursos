package br.com.hbsis.projetocursos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsis.projetocursos.dao.AlunoRepository;
import br.com.hbsis.projetocursos.dao.BoletimRepositoryImpl;
import br.com.hbsis.projetocursos.entity.Aluno;
import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.BoletimDTO;

@Service
public class AlunoServiceImpl implements AlunoService 
{
	private AlunoRepository alunoRepository;
	private BoletimRepositoryImpl boletimRepository;
	
	@Autowired
	public AlunoServiceImpl(AlunoRepository theAlunoRepository, BoletimRepositoryImpl theBoletimRepository) 
	{
		alunoRepository = theAlunoRepository;
		boletimRepository = theBoletimRepository;
		
	}	
	
	@Override
	public List<AlunoDTO> findAll() 
	{
		List<AlunoDTO> listaDeAlunos = new ArrayList<>();
		List<Aluno> alunos = alunoRepository.findAll();

		for(Aluno aluno : alunos ) {
			AlunoDTO alunoDto = transformAlunoIntoPojo(aluno);
			listaDeAlunos.add(alunoDto);
		}

		return listaDeAlunos;
	}

	public AlunoDTO findAlunoById(int theAlunoId) {

		Optional<Aluno> optionalAluno = alunoRepository.findById(theAlunoId);

		if(!optionalAluno.isPresent()) {
			throw new RuntimeException("ERRO: Aluno não encontrado");
		}

		Aluno aluno = optionalAluno.get();

		return transformAlunoIntoPojo(aluno);
	}


	public AlunoDTO transformAlunoIntoPojo(Aluno aluno) {

		int theId = aluno.getIdAlunos();

		return AlunoDTO.builder()
				.id(aluno.getIdAlunos())
				.cpf(aluno.getCpf())
				.nome(aluno.getNome())
				.idade(aluno.getIdade())
				.boletimDTO(boletimRepository.findBoletimByAlunoId(theId))
				.build();
	}

	@Override
	public Aluno findById(int theId)
	{
		Optional<Aluno> result = alunoRepository.findById(theId);
		Aluno aluno = null;

		if(result.isPresent())
		{
			return aluno = result.get();
		}

		else
		{
			throw new RuntimeException("Não foi possível achar o aluno do ID: " + theId);
		}
	}



	// OS MÉTODOS ABAIXO AINDA NÃO ESTÃO EM FUNCIONAMENTO
	@Override
	public void save(Aluno aluno) 
	{
		alunoRepository.save(aluno);
	}

	@Override
	public void deleteById(int theId) 
	{
		alunoRepository.deleteById(theId);
	}
	


}
