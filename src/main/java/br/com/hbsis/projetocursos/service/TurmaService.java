package br.com.hbsis.projetocursos.service;

import br.com.hbsis.projetocursos.entity.Turma;
import br.com.hbsis.projetocursos.entity.TurmaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TurmaService {
    public List<TurmaDTO> findAll();
    public TurmaDTO findTurmaDTOById(int theId);
    public Turma findById(int theId);
    public void save(Turma theTurma);
    public void deleteById(int theId);
    public void cadastrarTurma(TurmaDTO turmaDTO);
}
