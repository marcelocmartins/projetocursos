package br.com.hbsis.projetocursos.rest;

import br.com.hbsis.projetocursos.entity.Turma;
import br.com.hbsis.projetocursos.entity.TurmaDTO;
import br.com.hbsis.projetocursos.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
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

    @GetMapping("/{turmaId}")
    public TurmaDTO findById (@PathVariable int turmaId) {
            return turmaService.findTurmaDTOById(turmaId);
        }

    @PostMapping("/nova-turma")
    public ResponseEntity cadastrarTurma(@RequestBody TurmaDTO turmaDTO) {
        turmaDTO.setId(0);
        turmaService.cadastrarTurma(turmaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{turmaId}")
    public ResponseEntity deletaTurma(@PathVariable int turmaId) {
        turmaService.deleteById(turmaId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/turma")
    public TurmaDTO atualizaTurma(@RequestBody TurmaDTO theTurma) {
        turmaService.atualizaTurma(theTurma);
        return theTurma;
    }
}

