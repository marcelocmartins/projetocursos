package br.com.hbsis.projetocursos.rest;

import br.com.hbsis.projetocursos.entity.ProfessorDTO;
import br.com.hbsis.projetocursos.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorRestController {
    private ProfessorService professorService;

    @Autowired
    public ProfessorRestController(ProfessorService professorService) {this.professorService = professorService;}

    @GetMapping("/professores")
    public List<ProfessorDTO> findAll() {
        return professorService.findAll();
    }

    @GetMapping("/{professorId}")
    public ProfessorDTO findById (@PathVariable int professorId) {
        ProfessorDTO professorDTO = professorService.findProfessorDTOById(professorId);
        return professorDTO;
    }

    @PostMapping("/novo-professor")
    public ResponseEntity cadastrarProfessor(@RequestBody ProfessorDTO professorDTO) {
        professorDTO.setIdProfessor(0);
        professorService.cadastrarProfessor(professorDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{professorId}")
    public ResponseEntity deletaProfessor(@PathVariable int professorId) {
        professorService.deleteById(professorId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualiza")
    public ProfessorDTO atualizaProfessor(@RequestBody ProfessorDTO theProfessor) {
        professorService.atualizaProfessor(theProfessor);
        return theProfessor;
    }
}
