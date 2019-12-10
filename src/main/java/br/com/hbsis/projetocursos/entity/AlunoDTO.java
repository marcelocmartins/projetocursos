package br.com.hbsis.projetocursos.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AlunoDTO {
	
	private int id;
	private String nome;
	private String cpf;
	private Integer idade;
	private Integer turmaDTO;


	public Aluno transformAlunoDTOIntoAluno(AlunoDTO alunoDTO, Turma turma) {

		return Aluno.builder()
				.cpf(alunoDTO.getCpf())
                .nome(alunoDTO.getNome())
                .idade(alunoDTO.getIdade())
                .turma(turma)
                .build();

	}

	public AlunoDTO transformAlunoIntoAlunoDTO(Aluno aluno, Turma turma) {

		TurmaDTO theTurmaDTO = new TurmaDTO().transformTurmaIntoPojo(turma);

		return AlunoDTO.builder()
				.id(aluno.getIdAlunos())
				.cpf(aluno.getCpf())
				.nome(aluno.getNome())
				.idade(aluno.getIdade())
				.turmaDTO(theTurmaDTO.getId())
				.build();
	}

}