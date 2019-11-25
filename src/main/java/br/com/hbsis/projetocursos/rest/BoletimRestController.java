package br.com.hbsis.projetocursos.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.hbsis.projetocursos.entity.AlunoDTO;
import br.com.hbsis.projetocursos.service.BoletimService;

@RestController
@RequestMapping("/boletim")
public class BoletimRestController {
	
//	private BoletimService boletimService;
//	
//	
//	@GetMapping("exportboletim/{alunoDtoId}")
//	public AlunoDTO generateBoletim(@RequestBody AlunoDTO alunoDTO) {
//		
//		AlunoDTO boletimPdf = boletimService.generateBoletim(alunoDTO);
//		
//		return boletimPdf;
//	}
}
