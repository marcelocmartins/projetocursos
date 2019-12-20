package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.dao.TurmaRepository;
import br.com.hbsis.projetocursos.entity.Professor;
import br.com.hbsis.projetocursos.entity.Turma;
import br.com.hbsis.projetocursos.entity.TurmaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaServiceImpl implements TurmaService {
    private TurmaRepository turmaRepository;
    private ProfessorService professorService;

    @Autowired
    public TurmaServiceImpl(TurmaRepository theTurmaRepository, ProfessorService theProfessorService) {
        this.turmaRepository = theTurmaRepository;
        this.professorService = theProfessorService;
    }

    @Override
    public List<TurmaDTO> findAll() {
        List<TurmaDTO> listaDeTurmas = new ArrayList<>();
        List<Turma> turmas = turmaRepository.findAll();

        for(Turma turma : turmas) {
            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO = turmaDTO.transformTurmaIntoPojo(turma);
            listaDeTurmas.add(turmaDTO);
        }

        return listaDeTurmas;
    }

    @Override
    public Turma findById(int theId) {
        Optional<Turma> result = turmaRepository.findById(theId);
        Turma turma = null;

        if(result.isPresent()) {
            return turma = result.get();
        }

        else {
            throw new RuntimeException("Não foi possível achar a turma do ID: " + theId);
        }
    }

    @Override
    public TurmaDTO findTurmaDTOById(int theId) {
        Optional<Turma> optionalTurma = turmaRepository.findById(theId);

        if(optionalTurma.isPresent()) {
            Turma turma = optionalTurma.get();
            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO = turmaDTO.transformTurmaIntoPojo(turma);
            return turmaDTO;
        }

        else {
            throw new RuntimeException("Não foi possível encontrar a turma: " + theId);
        }
    }

    @Override
    public void save(Turma theTurma) {
        turmaRepository.save(theTurma);
    }

    @Override
    public void deleteById(int theId) throws Exception {
        Turma turma = findById(theId);
        if(turma.getNumeroAlunos() > 0) {
            throw new Exception("Não é possível deletar a turma, pois ela tem alunos, remova os alunos da turma antes de deletá-la");
        }

        else {
            turmaRepository.deleteById(theId);
        }
    }

    @Override
    public void cadastrarTurma(TurmaDTO turmaDTO) {
        Professor professor = professorService.findById(turmaDTO.getIdProfessor());
        Turma theTurma = turmaDTO.transformTurmaDTOIntoTurma(turmaDTO, 0, professor);
        turmaRepository.save(theTurma);
    }

    @Override
    public TurmaDTO atualizaTurma(TurmaDTO theTurmaDTO) {

        Professor theProfessor = professorService.findById(theTurmaDTO.getIdProfessor());

        Turma turma = theTurmaDTO.transformTurmaDTOIntoTurma(theTurmaDTO, theTurmaDTO.getNumeroAlunos(),theProfessor );
        turmaRepository.save(turma);
//        TurmaDTO turmaDTO = theTurmaDTO.transformTurmaIntoPojo(theAluno, theTurma);
        return theTurmaDTO;
    }


}
