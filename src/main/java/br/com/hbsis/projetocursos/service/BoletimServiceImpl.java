package br.com.hbsis.projetocursos.service;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.hbsis.projetocursos.dao.BoletimRepository;
import br.com.hbsis.projetocursos.entity.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;


@Service
public class BoletimServiceImpl implements BoletimService{
	
	private BoletimRepository boletimRepository;
	private AlunoService alunoService;
	private ProfessorService professorService;
	private TurmaService turmaService;
	
	@Autowired
	public void BoletimServiceImpl(BoletimRepository theBoletimRepository, AlunoService theAlunoService, ProfessorService theProfessorService, TurmaService theTurmaService) {
		this.boletimRepository= theBoletimRepository;
		this.alunoService = theAlunoService;
		this.professorService = theProfessorService;
		this.turmaService = theTurmaService;
	}

	@Override
	public void generateBoletimFromFile(HttpServletResponse response) throws Exception {
		File boletim = new File("C:\\Users\\marcelo.martins\\Pictures\\Winterhold\\Gatekeeper_(Achievement).png");
		byte[] content = FileUtils.readFileToByteArray(boletim);
		Path path = boletim.toPath();
		String nome = boletim.getName();
		int tamanho = (int) boletim.length();

		response.setContentType("image/png"); // Tipo do Conteúdo
		response.setContentLength(tamanho); // Opcional
		response.setHeader("Content-Disposition", "attachment; filename=\"" + nome + "\"");

		OutputStream output = response.getOutputStream();
		output.write(content);
		output.flush();
		output.close();
	}

	@Override
	public List<Boletim> findBoletimByAlunoId(int alunoId) {

		return boletimRepository.findBoletimByAlunoId(alunoId);
	}

	@Override
	public List<String> generateNotasForBoletim (List<Boletim> notasBoletins) {

		List<String> notas = new ArrayList<>();
		for(Boletim boletim : notasBoletins) {
			String nota = String.valueOf(boletim.getNota());
			notas.add(nota);
		}
		return notas;
	}

	@Override
	public void aplicarNota(BoletimDTO boletimDTO) throws Exception {
		Aluno theAluno = alunoService.findById(boletimDTO.getAlunoId());
		Professor theProfessor = professorService.findById(boletimDTO.getProfessorId());
		Turma theTurma = turmaService.findById(boletimDTO.getTurmaId());
		Boletim boletim = new Boletim();

		List<Boletim> boletinsDoAluno = boletimRepository.findBoletimByAlunoeTurmaId(boletimDTO.getAlunoId(), boletimDTO.getTurmaId());

		if(boletinsDoAluno.size() >= 3) {
			throw new Exception("Todas as notas para esse aluno desse curso já foram preenchidas");
		}

		else {
			boletim.setAluno(theAluno);
			boletim.setProfessor(theProfessor);
			boletim.setTurma(theTurma);
			boletim.setNota(boletimDTO.getNota());

			boletimRepository.save(boletim);
		}
	}

	@Override
	public Boletim findById(int theId) {
		Optional<Boletim> result = boletimRepository.findById(theId);
		Boletim boletim = null;

		if(result.isPresent()) {
			return boletim = result.get();
		}
		else {
			throw new RuntimeException("Não foi possível achar o Boletim do ID: " + theId);
		}
	}

	@Override
	public void deletaBoletins(List<Boletim> boletins) {
		for(Boletim boletim : boletins) {
			Boletim theBoletim = findById(boletim.getIdBoletim());
			boletimRepository.deleteById(theBoletim.getIdBoletim());
		}
	}

	@Override
	public void deletaBoletim(int boletimId) {
		Boletim boletim = findById(boletimId);
		boletimRepository.delete(boletim);
	}



}
