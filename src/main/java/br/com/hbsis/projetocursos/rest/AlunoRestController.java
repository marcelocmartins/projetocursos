package br.com.hbsis.projetocursos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.hbsis.projetocursos.entity.Aluno;
import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.Boletim;
import br.com.hbsis.projetocursos.service.AlunoService;


@RestController
@RequestMapping("/alunos")
public class AlunoRestController {
//	private AlunosRepository alunosRepository;
	private AlunoService alunoService;
	
	@Autowired
	public AlunoRestController(AlunoService theAlunoService) {
		alunoService = theAlunoService;
	}
	
	
	@GetMapping("/lista")
	public List<AlunoDTO> findAll() {
		return alunoService.findAll();
	}
	
	@GetMapping("/boletim/{alunoId}")
	public List<AlunoDTO> GenerateBoletim() {
		return alunoService.findAll();
	}
	
	
	
}



