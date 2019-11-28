package br.com.hbsis.projetocursos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.hbsis.projetocursos.entity.Aluno;
import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.entity.Boletim;
import br.com.hbsis.projetocursos.service.AlunoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
	
//	@GetMapping("/boletim/{alunoId}")
//	public void GenerateBoletim(HttpServletRequest request, HttpServletResponse response) {
//		return alunoService.findAll();
//	}

	@GetMapping("/aluno/{alunoId}")
	public AlunoDTO findAlunoById(@PathVariable int alunoId) {
		return alunoService.findAlunoById(alunoId);
	}
}



