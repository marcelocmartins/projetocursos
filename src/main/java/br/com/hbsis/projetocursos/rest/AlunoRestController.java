package br.com.hbsis.projetocursos.rest;

import java.util.List;

import br.com.hbsis.projetocursos.entity.AlunoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("/aluno")
	public ResponseEntity cadastraAluno(@RequestBody AlunoDTO theAluno) {
		theAluno.setId(0);
		alunoService.cadastraAluno(theAluno);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/aluno")
	public AlunoDTO atualizaAluno(@RequestBody AlunoDTO theAluno) {
		alunoService.atualizaAluno(theAluno);
		return theAluno;
	}

	@DeleteMapping("/aluno/{alunoId}")
	public ResponseEntity deletaAluno(@PathVariable int alunoId) {
		alunoService.deletaAluno(alunoId);
		return ResponseEntity.ok().build();
	}
}