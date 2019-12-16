package br.com.hbsis.projetocursos.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TurmaDTO {
    private int id;
    private String nomeTurma;
    private String materia;
    private Integer idProfessor;
    private String nomeProfessor;
    private int numeroAlunos;


    public Turma transformTurmaDTOIntoTurma (TurmaDTO turmaDTO, Integer quantidadeAlunos, Professor professor) {


        return Turma.builder()
                .idTurma(turmaDTO.getId())
                .materia(turmaDTO.getMateria())
                .nomeTurma(turmaDTO.getNomeTurma())
                .numeroAlunos(quantidadeAlunos)
                .professor(professor)
                .build();
    }

    public TurmaDTO transformTurmaIntoPojo(Turma turma) {

        return TurmaDTO.builder()
                .id(turma.getIdTurma())
                .materia(turma.getMateria())
                .nomeTurma(turma.getNomeTurma())
                .idProfessor(turma.getProfessor().getIdProfessor())
                .nomeProfessor(turma.getProfessor().getNomeProfessor())
                .numeroAlunos(turma.getNumeroAlunos())
                .build();
    }


}


