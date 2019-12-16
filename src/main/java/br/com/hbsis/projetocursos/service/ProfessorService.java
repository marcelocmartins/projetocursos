package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.Professor;
import br.com.hbsis.projetocursos.entity.ProfessorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    public List<ProfessorDTO> findAll();
    public Professor findById(Integer theId);
    public ProfessorDTO findProfessorDTOById(Integer theId);
}
