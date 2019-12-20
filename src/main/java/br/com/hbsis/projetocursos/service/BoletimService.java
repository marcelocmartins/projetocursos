package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.Boletim;
import br.com.hbsis.projetocursos.entity.BoletimDTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BoletimService {
	void generateBoletimFromFile(HttpServletResponse response) throws Exception;
	public List<Boletim> findBoletimByAlunoId(int alunoId);
	List<String> generateNotasForBoletim(List<Boletim> notasBoletins);
	public Boletim findById(int theId);
	public void deletaBoletim(int boletimId);
	public void deletaBoletins(List<Boletim> boletins);
	public void aplicarNota(BoletimDTO boletimDTO) throws Exception;
}
	