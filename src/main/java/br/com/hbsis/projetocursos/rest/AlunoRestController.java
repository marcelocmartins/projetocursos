package br.com.hbsis.projetocursos.rest;

import java.util.List;

import br.com.hbsis.projetocursos.entity.AlunoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.hbsis.projetocursos.entity.AlunoListagemDTO;
import br.com.hbsis.projetocursos.service.AlunoService;


@RestController
@RequestMapping("/alunos")
public class AlunoRestController {
	private AlunoService alunoService;
	
	@Autowired
	public AlunoRestController(AlunoService theAlunoService) {
		alunoService = theAlunoService;
	}
	
	
	@GetMapping("/lista")
	public List<AlunoListagemDTO> findAll() {
		return alunoService.findAll();
	}

	@GetMapping("/{alunoId}")
	public AlunoListagemDTO findAlunoById(@PathVariable int alunoId) {
		return alunoService.findAlunoListagembyId(alunoId);
	}

	@PostMapping("/aluno/{turmaId}")
	public AlunoDTO cadastraAluno(@RequestBody AlunoDTO theAluno) {

		alunoService.cadastraAluno(theAluno);
		return theAluno;
	}
}