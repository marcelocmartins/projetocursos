package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.dao.ProfessorRepository;
import br.com.hbsis.projetocursos.entity.Professor;
import br.com.hbsis.projetocursos.entity.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository theProfessorRepository) {
        this.professorRepository = theProfessorRepository;
    }

    @Override
    public List<ProfessorDTO> findAll() {
        List<ProfessorDTO> listaDeProfessores = new ArrayList<>();
        List<Professor> professores = professorRepository.findAll();

        for(Professor professor : professores) {
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO = professorDTO.transformProfessorIntoProfessorDTO(professor);
            listaDeProfessores.add(professorDTO);
        }
        return listaDeProfessores;
    }

    @Override
    public Professor findById(Integer theId) {
        Optional<Professor> result = professorRepository.findById(theId);
        Professor professor = null;

        if(result.isPresent()) {
            return professor = result.get();
        }
        else {
            throw new RuntimeException("Não foi possível achar o professor do ID: " + theId);
        }
    }

    @Override
    public ProfessorDTO findProfessorDTOById(Integer theId) {
        Optional<Professor> optionalTurma = professorRepository.findById(theId);

        if(optionalTurma.isPresent()) {
            Professor professor = optionalTurma.get();
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.transformProfessorIntoProfessorDTO(professor);
            return professorDTO;
        }

        else {
            throw new RuntimeException("Não foi possível encontrar o professor: " + theId);
        }
    }
}

