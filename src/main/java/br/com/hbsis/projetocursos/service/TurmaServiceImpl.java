package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.dao.TurmaRepository;
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

    @Autowired
    public TurmaServiceImpl(TurmaRepository theTurmaRepository) {
        this.turmaRepository = theTurmaRepository;
    }

    @Override
    public List<TurmaDTO> findAll() {
        List<TurmaDTO> listaDeTurmas = new ArrayList<>();
        List<Turma> turmas = turmaRepository.findAll();

        for(Turma turma : turmas) {
            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO.transformTurmaIntoPojo(turma);
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
        Optional<Turma> result = turmaRepository.findById(theId);
        Turma turma = null;

        if(result.isPresent()) {
            TurmaDTO turmaDTO = new TurmaDTO();
            turmaDTO.transformTurmaIntoPojo(result.get());
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
    public void deleteById(int theId) {
        turmaRepository.deleteById(theId);
    }


}
