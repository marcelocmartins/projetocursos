package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.Boletim;

public interface BoletimService {
	

	void generateBoletim(AlunoDTO boletimAluno) throws Exception;

	
	


}
	