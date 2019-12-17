package br.com.hbsis.projetocursos.service;

import java.io.File;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import br.com.hbsis.projetocursos.entity.Boletim;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hbsis.projetocursos.dao.BoletimRepositoryImpl;

import javax.servlet.http.HttpServletResponse;


@Service
public class BoletimServiceImpl implements BoletimService{
	
	private BoletimRepositoryImpl boletimRepository;
	
	@Autowired
	public BoletimServiceImpl(BoletimRepositoryImpl theBoletimRepository) {
		this.boletimRepository= theBoletimRepository;
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

	public void aplicarNota(double nota, int professorId, int alunoId, int boletimId) {


	}


}
