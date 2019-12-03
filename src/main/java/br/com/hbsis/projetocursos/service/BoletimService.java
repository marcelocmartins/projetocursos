package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.Boletim;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BoletimService {
	

	void generateBoletimFromFile(HttpServletResponse response) throws Exception;
	public List<Boletim> findBoletimByAlunoId(int alunoId);


	List<String> generateNotasForBoletim(List<Boletim> notasBoletins);
}
	