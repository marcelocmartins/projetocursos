package br.com.hbsis.projetocursos.rest;

import br.com.hbsis.projetocursos.entity.ProfessorDTO;
import br.com.hbsis.projetocursos.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorRestController {
    private ProfessorService professsorService;

    @Autowired
    public ProfessorRestController(ProfessorService professorService) {this.professsorService = professorService;}

    @GetMapping("/professores")
    public List<ProfessorDTO> findAll() {
        return professsorService.findAll();
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity findById (@PathVariable int professorId) {
        professsorService.findProfessorDTOById(professorId);
        return ResponseEntity.ok().build();
    }
}
