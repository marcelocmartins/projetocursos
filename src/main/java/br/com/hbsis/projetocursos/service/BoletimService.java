package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.Boletim;
import br.com.hbsis.projetocursos.entity.BoletimDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface BoletimService {
	

	void generateBoletimFromFile(HttpServletResponse response) throws Exception;
	public List<BoletimDTO> findBoletimByAlunoId(int alunoId);

	
	


}
	