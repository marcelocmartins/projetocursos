package br.com.hbsis.projetocursos.rest;

import br.com.hbsis.projetocursos.entity.TurmaDTO;
import br.com.hbsis.projetocursos.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaRestController {
    private TurmaService turmaService;

    @Autowired
    public TurmaRestController (TurmaService theTurmaService) {
        this.turmaService = theTurmaService;
    }

    @GetMapping("/turmas")
    public List<TurmaDTO> findAll() {
        return turmaService.findAll();
    }

    @GetMapping("/turma/{turmaId}")
        public TurmaDTO findById (@PathVariable int turmaId) {
            return turmaService.findTurmaDTOById(turmaId);
        }
}

