package br.com.hbsis.projetocursos.rest;

import br.com.hbsis.projetocursos.service.JasperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.hbsis.projetocursos.service.BoletimService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/boletim")
public class BoletimRestController {


	private final BoletimService boletimService;
	private final JasperService jasperService;

	@Autowired
	public BoletimRestController(BoletimService boletimService, JasperService jasperService) {
		this.boletimService = boletimService;
		this.jasperService = jasperService;
	}


	@GetMapping("/boletim/{alunoId}")
	public void GenerateBoletimFromFile(HttpServletResponse response ) throws Exception {
		boletimService.generateBoletimFromFile(response);
	}

	@GetMapping("/export/{alunoId}")
	public void GenerateBoletim(HttpServletResponse response, int theId) throws Exception {
		jasperService.generateBoletim(response, theId);
	}
}
