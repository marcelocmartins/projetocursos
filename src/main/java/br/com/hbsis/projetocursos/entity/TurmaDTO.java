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


    public Turma transformTurmaDTOIntoTurma (TurmaDTO turmaDTO, Integer quantidadeAlunos) {


        return Turma.builder()
                .idTurma(turmaDTO.getId())
                .materia(turmaDTO.getMateria())
                .nomeTurma(turmaDTO.getNomeTurma())
                .numeroAlunos(quantidadeAlunos)
                .build();
    }

    public TurmaDTO transformTurmaIntoPojo(Turma turma) {

        return TurmaDTO.builder()
                .id(turma.getIdTurma())
                .materia(turma.getMateria())
                .nomeTurma(turma.getNomeTurma())
                .build();
    }


}


