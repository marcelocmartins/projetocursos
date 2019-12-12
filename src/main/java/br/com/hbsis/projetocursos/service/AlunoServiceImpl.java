package br.com.hbsis.projetocursos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.hbsis.projetocursos.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsis.projetocursos.dao.AlunoRepository;
import br.com.hbsis.projetocursos.dao.BoletimRepositoryImpl;

import javax.swing.text.html.Option;

@Service
public class AlunoServiceImpl implements AlunoService {
	private AlunoRepository alunoRepository;
	private BoletimService boletimService;
	private TurmaService turmaService;

	
	@Autowired
	public AlunoServiceImpl(AlunoRepository theAlunoRepository, BoletimService theBoletimRepository, TurmaService theTurmaService) {
		alunoRepository = theAlunoRepository;
		boletimService = theBoletimRepository;
		turmaService = theTurmaService;
		
	}	

	// Listar os alunos na tela para Boletim
	@Override
	public List<AlunoListagemDTO> findAll() {
		List<AlunoListagemDTO> listaDeAlunos = new ArrayList<>();
		List<Aluno> alunos = alunoRepository.findAll();


		for(Aluno aluno : alunos ) {
			int idAlunoBoletim = aluno.getIdAlunos();
			String nomeTurma = aluno.getTurma().getNomeTurma();
			Integer theTurmaId = aluno.getTurma().getIdTurma();
			List<Boletim> boletins = boletimService.findBoletimByAlunoId(idAlunoBoletim);
			List<String> notas = boletimService.generateNotasForBoletim(boletins);

			AlunoListagemDTO alunoListagemDto = new AlunoListagemDTO().transformAlunoIntoAlunoListagem(aluno, nomeTurma, theTurmaId, notas);
			listaDeAlunos.add(alunoListagemDto);
		}

		return listaDeAlunos;
	}


	// Recebe um ID e retorna um AlunoDTO
	@Override
	public AlunoDTO findAlunoDTOById(int theAlunoId) {

		Optional<Aluno> optionalAluno = alunoRepository.findById(theAlunoId);

		if(!optionalAluno.isPresent()) {
			throw new RuntimeException("ERRO: Aluno não encontrado");
		}

		Aluno aluno = optionalAluno.get();
		AlunoDTO alunoDTO = new AlunoDTO().transformAlunoIntoAlunoDTO(aluno, aluno.getTurma());

		return alunoDTO;
	}

	@Override
	public AlunoListagemDTO findAlunoListagembyId(int alunoId) {
		Aluno theAluno = findById(alunoId);
		String theTurma = theAluno.getTurma().getNomeTurma();
		Integer theTurmaId = theAluno.getTurma().getIdTurma();
		List<Boletim> boletins = boletimService.findBoletimByAlunoId(alunoId);
		List<String> notas = boletimService.generateNotasForBoletim(boletins);
		AlunoListagemDTO alunoListagemDTO = new AlunoListagemDTO().transformAlunoIntoAlunoListagem(theAluno, theTurma, theTurmaId, notas);

		return alunoListagemDTO;
	}




	@Override
	public Aluno findById(int theId) {
		Optional<Aluno> result = alunoRepository.findById(theId);
		Aluno aluno = null;

		if(result.isPresent()) {
			return aluno = result.get();
		}
		else {
			throw new RuntimeException("Não foi possível achar o aluno do ID: " + theId);
		}
	}

	@Override
	public void cadastraAluno(AlunoDTO theAlunoDTO) {

		Turma theTurma = turmaService.findById(theAlunoDTO.getTurmaDTO());
		Aluno theAluno = theAlunoDTO.transformAlunoDTOIntoAluno(theAlunoDTO, theTurma);
		int quantidadeAlunosTurma = theTurma.getNumeroAlunos() + 1;
		theTurma.setNumeroAlunos(quantidadeAlunosTurma);
		alunoRepository.save(theAluno);
	}

	@Override
	public void deletaAluno(int alunoId) {
		Aluno aluno = findById(alunoId);
		alunoRepository.delete(aluno);
	}

	@Override
	public AlunoDTO atualizaAluno(AlunoDTO theAlunoDTO) {
		Turma theTurma = turmaService.findById(theAlunoDTO.getTurmaDTO());

		Aluno theAluno = theAlunoDTO.transformAlunoDTOIntoAluno(theAlunoDTO, theTurma);
		theAluno.setIdAlunos(theAlunoDTO.getId());
		alunoRepository.save(theAluno);
		AlunoDTO alunoDTO = theAlunoDTO.transformAlunoIntoAlunoDTO(theAluno, theTurma);
		return alunoDTO;
	}

	@Override
	public void save(Aluno aluno) {alunoRepository.save(aluno);
	}
}
